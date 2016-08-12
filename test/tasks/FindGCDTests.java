package tasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * tests fir findsGCD class
 */
public class FindGCDTests {
    static FindsGCD findsGCD = new FindsGCD();

    @Test
    public void testFindGCD() {

        // test
        testGCD(1, 1, 1, 1, 1);
        testGCD(1, 9, 6, 8, 4);
        testGCD(1, 6, 9, 18, 8);
        testGCD(1, -12, -9, -15, 1);

        testGCD(2, 40, -16, 18, 0);

        testGCD(4, 16, 16, 36, 40);
        testGCD(4, -40, -28, -16, 0);

        testGCD(5, 5, 15, 20, 10);
        testGCD(5, -5, -10, -15, 0);
        testGCD(5, 35, 25, -5, -10);
        testGCD(5, -5, -25, 0, -10);

        testGCD(10, 10, 10, 10, 10);
        testGCD(10, 10, 100, 1000, 100000);

        //test negative arg
        testGCD(3, -9, 6, 12, 15);
        testGCD(4, 16, -4, 8, 12);
        testGCD(3, 15, 9, -3, 21);
        testGCD(7, 28, 49, 21, -7);

        // test max & min args
        testGCD(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        testGCD(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    }

    @Test
    public void testException() {
        testExceptionGSD(0, 0, 0, 0);
    }

    private static void testGCD(int nod, int a, int b, int c, int d) {

        assertEquals(nod, findsGCD.getGCDForFour(a, b, c, d));
    }

    private static void testExceptionGSD(int a, int b, int c, int d) {
        try {
            findsGCD.getGCDForFour(a, b, c, d);
            fail();
        } catch (IllegalArgumentException iae) {
            //correct
        }
    }
}
