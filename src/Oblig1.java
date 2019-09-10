public class Oblig1 {

    public static void bytt(int[] a, int b, int c){

        int mt = a[b];
        a[b] = a[c];
        a[c] = mt;

    }
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

    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }
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




    public static void main (String[] args){
        int[] a = {1,4,9,6,7,4,5,8};
        System.out.println(maks(a));
    }


}
