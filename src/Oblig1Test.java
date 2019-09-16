import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Oblig1Test {

    @Test
     void maks() {
        int[] verdier={1,5,2,3,5,7,3,1,2,3};

        assertEquals(7,Oblig1.maks(verdier));

    }
}