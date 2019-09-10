public class Oppgave1 {
    public static void bytt(int[] a, int b, int c){

        int mt = a[b];
        a[b] = a[c];
        a[c] = mt;

    }
    public static int maks(int[] a){

        //if (a.length <0 ) {NoSuchElementException​("Error"); }

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


}
