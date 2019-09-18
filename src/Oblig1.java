//Studentnr: Jon Rafoss - s331379
// Magnus Palving Christiansen - s326302
// Mats Groesvik - 331405


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

        if (a.length == 0 ) throw new NoSuchElementException("Tom array");

        for (int i = 0; i < a.length-1 ; i++){

            if (a[i] > a[i+1]) {
                bytt(a, i, i + 1);
            }
        }

        int storsteTall =a[a.length-1];

        return storsteTall;
    }

    public static int ombyttinger(int[] a){
        if (a.length == 0 ) throw new NoSuchElementException("Tom array");

        int teller=0;
        for (int i = 0; i < a.length-1 ; i++){

            if (a[i] > a[i+1]) {
                bytt(a, i, i + 1);
                teller++;
            }
        }



        return teller;
    }


    // oppgave 2
    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) return 0;


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


   // oppgave 4

    public static void delsortering(int[] a) {

// så lenge v delelig med 2 og h !delelig med 2 bytt v med h

        int v = 0;
        int h = a.length - 1;

        while (v <= h) {
            if ((a[v] % 2 == 0 || a[v]*-1 % 2 == 0) && (a[h] % 2 > 0 || a[h]*-1 % 2 > 0)) // oddetall bytt mot partall
            {
                bytt(a, v, h);

                v++;
                h--;
            }

            else if (a[v] % 2 == 0 || a[v]*-1 % 2 == 0) {
                   h--;

            }

            else if (a[h] % 2 > 0  ||  a[h]*-1 % 2 > 0){
                 v++;
            }

            else if ((a[v] % 2 > 0 || a[v]*-1 % 2 > 0)  && (a[h] % 2 ==0 ||  a[h]*-1 % 2 > 0)){
           // verken
                v++;
                h--;
            }

    }

        for (int i=0;i<v;i++){

            for (int x=0;x<v;x++){
                if (a[i]<a[x]){
                    bytt(a,x,i);

                }
            }
        }

        for (int i=v;i<a.length;i++){
            for (int x=v;x<a.length;x++){
                if (a[i]<a[x]){
                    bytt(a,x,i);
                }
            }
        }
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

        if (a.length==0){
            return;
        }


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

    //Oppgave 7a
    public static String flett(String s, String t) {

        StringBuilder c = new StringBuilder();
        String h = s + t;

        for (int i = 0; i < h.length(); i++) {

            if (i < s.length()) {
                c.append(s.charAt(i));
            }

            if (i < t.length()) {
                c.append(t.charAt(i));
            }
        }
        return c.toString();
    }


    //oppgave 7b

        public static String flett(String ... s){

            StringBuilder ut=new StringBuilder();
            int sum=0;
            int lengsteOrd=0;
            for (String ord : s){
                StringBuilder sb=new StringBuilder(ord);
                sum+=sb.length();

                if (sb.length()>lengsteOrd){
                    lengsteOrd=sb.length();
                }
            }

            int teller=0; // bokstav-peker
            int i=0;  // ord-peker
            while (teller<lengsteOrd){

                if (new StringBuilder(s[i]).length() > teller){
                    ut.append(s[i].charAt(teller));

                }
                if (i==s.length-1){
                    teller++;
                    i=-1; // reset i, start på første ord igjen
                }

                i++; // neste ord
            }
            return ut.toString();


    }

// Opppgave 8

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

    // oppgave 8
    public static int[] indekssortering(int[] a){

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

        int[] treFørste ={a[0],a[1],a[2]} ;
        int[] indeksTF = indekssortering(treFørste);


        // hjelpevariabler
        int m = indeksTF[0];
        int nm = indeksTF[1];
        int nnm = indeksTF[2];



        int minste = a[indeksTF[0]];
        int nestminst = a[indeksTF[1]];
        int tredjeminst = a[indeksTF[2]];


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







}
