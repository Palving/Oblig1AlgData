import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    // oppgave 1
    public static void bytt(int[] a, int b, int c){

        int mt = a[b];
        a[b] = a[c];
        a[c] = mt;

    }

    // oppgave 1
    public static int maks(int[] a){

        if (a.length == 0 ) {throw new NoSuchElementException​("Error"); }

        for (int i = 0; i < a.length-1 ; i++){

            if (a[i] > a[i+1]){
                bytt(a, i, i+1);
            }

        }

        int storsteTall =a[a.length-1];

        return storsteTall;
    }

    // oppgave 1
    public static int ombyttninger(int[] a){

        if (a.length == 0 ) {throw new NoSuchElementException​("Error"); }

        int ombyttninger = 0;

        for (int i = 0; i < a.length-1 ; i++){

            if (a[i] > a[i+1]){
                bytt(a, i, i+1);
                ombyttninger++;
            }

        }



        return ombyttninger;
    }

    // oppgave 2
    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) { return 0; }
        ;

        int antallLike = 1;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                throw new IllegalStateException("Ikke sortert!!!");
            }
            else if (a[i]<a[i+1]){
                antallLike++;
            }
        }
        return antallLike;
    }

    // oppgave 3
    public static int antallUlikeUsortert(int[] a){
        if (a.length == 0) { return 0; }


        int antallLike = 0;

        for (int i = 0; i < a.length;i++){
            boolean unik = false;

            for (int j =0; j< i;j++){
                if(a[i] == a[j]){
                    unik =true;
                    break;
                }
            }
            if (!unik) {
                antallLike++;
            }
        }
        return antallLike;

    }

    //oppgave 4

    public static void delsortering(int[] a) {
        int antallOddetall = 0;
        int antallPartall = 0;

        // finne oddetall først
        int teller=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 > 0) {
                antallOddetall++;
                bytt(a,i,teller);
                teller++;

            }
        }



        for (int i=0;i<antallOddetall;i++){
            for (int x=0;x<antallOddetall;x++){
                if (a[i]<a[x]){
                    bytt(a, x,i);
                }

            }
        }

        for (int i=antallOddetall;i<a.length;i++) {
            for (int x = antallOddetall; x < a.length; x++) {
                if (a[i] < a[x]) {
                    bytt(a, x, i);
                }
            }
        }

        System.out.print(Arrays.toString(a));
    }



    // oppgave 5
    public static void byttChar (char[] a, int b, int c){
        char mt = a[b];
        a[b] = a[c];
        a[c] = mt;
    }

    // oppgave 5
    public static void rotasjon(char[] a){
        char temp = a[a.length-1];


        for (int i  = a.length-1; i >0; i--){
            a[i] = a[i-1];
        }

        a[0] = temp;




    }

    // oppgave 6
    public static void rotasjonBakover(char[] a){
        char temp = a[0];


        for (int i  = 0; i < a.length-1; i++){
            a[i] = a[i+1];
        }

        a[a.length-1] = temp;


    }

    //oppgave 6

    public static void rotasjon(char[] a, int k){

        if (k < 0){
            for (int i = 0; i < k; i++) {
                rotasjonBakover(a);
            }
        }
        else {

            for (int i = 0; i < k; i++) {
                rotasjon(a);
            }
        }
    }

    // oppgave 8
    public static int min(int[] a){
        int minsteverdi = a[0];
        int q = 0;

        for(int i = 0; i < a.length;i++){
            if (a[i] < minsteverdi){
                minsteverdi = a[i];
                q= i;

            }
        }
        return q;
    }

// Opppgave 8

    public static int[] indekssortering(int [] a){

            int[] indeks = new int[a.length];
            int[] b = a;

            for (int i = 0; i < a.length; i++){
                indeks[i] = min(b);
                b[indeks[i]] = 100000000;
            }


            return indeks;
        }



    // oppgave 9
    public static int[] tredjeMin(int[] a){

        int n = a.length;
        if (n < 3){ throw new NoSuchElementException("Tabellen har for få verdier"); }

        /*int[] treFørste ={a[0],a[1],a[2]} ;
        int[] indeksTF = indekssortering(treFørste);*/


        // hjelpevariabler
        /*int m = indeksTF[0];
        int nm = indeksTF[1];
        int nnm = indeksTF[2];*/

        int m = 0;
        int nm = 1;
        int nnm = 2;
        if (a[1] < a[0]){
            m = 1;
            nm = 0;
        }
        else if (a[2] < a[0]){
            m= 2;
            nnm=0;

        }
        else if(a[1] < a[2]){
            nm = 2;
            nnm=1;

        }

        //hjelpevariabler2
        int minste = a[m];
        int nestminst = a[nm];
        int tredjeminst = a[nnm];


        for (int i = 3; i < n; i++)
        {
            if (a[i] < tredjeminst)
            {
                if (a[i] < nestminst) {

                    if (a[i] < minste) {
                        nnm = nm;
                        tredjeminst = nestminst;

                        nm = m;
                        nestminst = minste;     // ny nest minst

                        m = i;
                        minste = a[m];              // ny minste
                    } else {
                        nnm = nm;
                        tredjeminst = nestminst;

                        nm = i;
                        nestminst = a[nm];         // ny nest minst
                    }
                }
                else {
                    nnm= i;
                    tredjeminst = a[nnm];
                }

            }
        } // for



        return new int[] {m,nm,nnm};

    }





    // Oppgave 10

    public static boolean inneholdt(String a, String b){

        StringBuilder asb=new StringBuilder(a);
        StringBuilder bsb=new StringBuilder(b);

        char bokstav='a';
        boolean statuser[]=new boolean[asb.length()];

        for (int i=0;i<asb.length();i++) {

            bokstav = asb.charAt(i);

            for (int j = 0; j < bsb.length(); j++) {

                if (bokstav == (bsb.charAt(j))) {
                    System.out.println("match funnet, sletter" + bsb.charAt(j));
                    bsb.deleteCharAt(j);
                    statuser[i] = true;
                    j = bsb.length(); // hopp ut av loop hvis match funnet
                } else {
                    statuser[i] = false;

                }
            }
        }

        for (boolean s : statuser) {
            if (!s){
                return false;
            }
        }
        return true;
    }




    public static void main (String[] args){
       // int[] a = {6,10,9,4,1,3,8,5,2,7};
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f','g','h','i','j' };
        rotasjonBakover(charArray);

        //System.​out​.println(Arrays.​toString(​charArray));
        //delsortering(a);
        //System.out.println(a.length);
    }


}
