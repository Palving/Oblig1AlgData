import java.util.Arrays;

public class Oblig1 {

    // oppgave 1
    public static void bytt(int[] a, int b, int c){

        int mt = a[b];
        a[b] = a[c];
        a[c] = mt;

    }

    // oppgave 1
    public static int maks(int[] a){

        //if (a.length ==  ) { NoSuchElementException​("Error"); }

        for (int i = 0; i < a.length-1 ; i++){
            //if (i+1<a.length){
            if (a[i] > a[i+1]){
                bytt(a, i, i+1);
            }
            //}
        }

        int storsteTall =a[a.length-1];

        return storsteTall;
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





    public static void main (String[] args){
       // int[] a = {6,10,9,4,1,3,8,5,2,7};
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f','g','h','i','j' };
        rotasjonBakover(charArray);

        //System.​out​.println(Arrays.​toString(​charArray));
        //delsortering(a);
        //System.out.println(a.length);
    }


}
