package tasks;

import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

/**
 * Test for DataExchange class
 */
public class DataExchangeTests {
    static DataExchange dataExchange = new DataExchange();
    private Random random = new Random();

    @Test
    public void testExceptionDataExchange() {
        exceptionTestForNull();
        exceptionTest(0);
        exceptionTest(3);
        exceptionTest(1);
    }

    @Test
    public void testDataExchange() {
        // test max & min
        testAB(Integer.MIN_VALUE, Integer.MIN_VALUE);
        testAB(Integer.MAX_VALUE, Integer.MAX_VALUE);
        testAB(Integer.MIN_VALUE, Integer.MAX_VALUE);
        testAB(random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE));
        testAB(-random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE));
        testAB(-random.nextInt(Integer.MAX_VALUE), -random.nextInt(Integer.MAX_VALUE));
        testAB(random.nextInt(Integer.MAX_VALUE), -random.nextInt(Integer.MAX_VALUE));

        testAB(1, 1);
        testAB(6, 6);
        testAB(0, 0);
        testAB(4, -8);
        testAB(-1, 2);
        testAB(-4, -10);
        testAB(90, -90);
        testAB(54, -38);
        testAB(545, 544);
        testAB(600, 500);
        testAB(-128, 127);
        testAB(7, 3456786);
        testAB(-132454, -3);
        testAB(13328, 544346);

    }

    private static void testAB(int a, int b) {
        int arrTest[] = new int[]{a, b};
        dataExchange.dataExchange(arrTest);
        assertEquals(a, arrTest[1]);
        assertEquals(b, arrTest[0]);
    }

    private static void exceptionTest(int i) {
        try {
            int arrTest[] = new int[i];
            dataExchange.dataExchange(arrTest);
            fail();
        } catch (IllegalArgumentException iae) {
            //correct
        }
    }

    private static void exceptionTestForNull() {
        try {
            dataExchange.dataExchange(null);
            fail();
        } catch (IllegalArgumentException iae) {
            //correct
        }
    }
}
