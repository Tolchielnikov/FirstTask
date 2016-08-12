package tasks;
import org.junit.Test;
import java.util.Random;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

/**
 * test for FindFloorAndStaircase class
 */
public class FindFloorAndStaircaseTests {
    static FindFloorAndStaircase findFloorAndStaircase = new FindFloorAndStaircase();
    private Random random = new Random();

    @Test
    public void testFindFloorAndStaircaseTests() {
        // test
        testFindApt(3,  5, 5, 3, 45);
        testFindApt(10, 5, 5, 3, 150);

        testFindApt(1, 1, 9, 4, 1);
        testFindApt(1, 9, 9, 4, 36);
        testFindApt(2, 1, 9, 4, 37);
        testFindApt(2, 9, 9, 4, 72);
        testFindApt(3, 1, 9, 4, 75);
        testFindApt(3, 9, 9, 4, 108);

        testFindApt(1, 1, 91, 5000, 2500);
        testFindApt(1, 1, 91, 5000, 1358);
        testFindApt(1, 1, 91, 5000, 4453);

        testFindApt(100, 2, 2, 10, 2000);
        testFindApt(50, 5, 5, 10, 2500);

        testFindApt(2, 10, 10, 10, 200);
        testFindApt(1, 15, 15, 10, 150);

        testFindApt(1, 1, 1, 5456456, 4453);
        testFindApt(1, 4453, 5456456, 1, 4453);

        testFindApt(1, 10000, 69872, 2, 20000);
        testFindApt(1, 10001, 69872, 2, 20002);

        testFindApt(1, 1, 3852686, 256556, 256556);
        testFindApt(1, 2, 3852686, 256556, 256557);

        testFindApt(1, 1000000, 385268656, 5, 5000000);

        testFindApt(1, 2, 69872, 2, 3);
        testFindApt(2000, 1, 1, 1, 2000);
        testFindApt(1, 13, 505365, 1, 13);
        testFindApt(1, 1, 1000, 200, 200);
        testFindApt(1, 1, 56526, 855632, 1);
        testFindApt(1, 500, 69872, 2, 1000);
        testFindApt(1, 2000, 2000, 1, 2000);
        testFindApt(200, 1000, 1000, 1, 200000);

        testFindApt(1, 1, random.nextInt(Integer.MAX_VALUE - 1) + 1, 1, 1);
        testFindApt(1, 2, random.nextInt(Integer.MAX_VALUE - 2) + 2, 1, 2);
        testFindApt(1, 1, 10, random.nextInt(Integer.MAX_VALUE - 1) + 1, 1);
        testFindApt(1, 1, 1000, random.nextInt(Integer.MAX_VALUE - 1) + 1, 1);

        // min & max  tests
        testFindApt(1, 1, 1, 1, 1);
        testFindApt(5, 1, 1, 2, 10);
        testFindApt(1, 3, Integer.MAX_VALUE, 5, 15);
        testFindApt(1, 1, 2, Integer.MAX_VALUE, 12);
        testFindApt(Integer.MAX_VALUE, 1, 1, 1, Integer.MAX_VALUE);
        testFindApt(Integer.MAX_VALUE, 1, 1, 1, Integer.MAX_VALUE);
        testFindApt(1, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, 985);
        testFindApt(1, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
        testFindApt(1, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

        //first and last floor in building
        testFindApt(1, 1, 5, 3, 1);
        testFindApt(1, 5, 5, 3, 15);
        testFindApt(2, 1, 5, 3, 16);
        testFindApt(2, 5, 5, 3, 30);
        testFindApt(3, 1, 5, 3, 31);
        testFindApt(3, 5, 5, 3, 45);

    }

    @Test
    public void testException() {
        // test negative arg
        testExcept(-1, 1, 1);
        testExcept(1, -1, 1);
        testExcept(1, 1, -1);
        testExcept(-1, -1, -1);
        testExcept(-1, 1, -1);
        testExcept(1, -1, -1);
        testExcept(-1, -1, 1);
        testExcept(Integer.MIN_VALUE, 76, 23);
        testExcept(89, Integer.MIN_VALUE, 28);
        testExcept(69, 7, Integer.MIN_VALUE);

        // test zero arg
        testExcept(0, 1, 1);
        testExcept(1, 0, 1);
        testExcept(1, 1, 0);
        testExcept(0, 0, 0);

    }


    private static void testFindApt(int expectedStairwell, int expectedPorches, int stairwell, int apartments, int flat) {
        assertEquals(expectedStairwell, findFloorAndStaircase.getPorchesAndStairwell(stairwell, apartments, flat)[0]);
        assertEquals(expectedPorches, findFloorAndStaircase.getPorchesAndStairwell(stairwell, apartments, flat)[1]);
    }

    private static void testExcept(int storeys, int flats, int apartment) {
        try {
            findFloorAndStaircase.getPorchesAndStairwell(storeys, flats, apartment);
            fail();
        } catch (IllegalArgumentException iae) {
            //correct
        }
    }
}

