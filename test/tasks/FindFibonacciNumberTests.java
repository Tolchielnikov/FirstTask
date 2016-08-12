package tasks;

import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

/**
 * Tests for FindFibonacciNumber class
 */
public class FindFibonacciNumberTests {
    static FindFibonacciNumber findFibonacciNumber = new FindFibonacciNumber();
    private Random random = new Random();

    @Test
    public void testFindFibonacciNumber() {
        //tests
        testFib(0, 0);
        testFib(1, 1);
        testFib(1, 2);
        testFib(2, 3);
        testFib(3, 4);
        testFib(5, 5);
        testFib(8, 6);

        testFib(144, 12);
        testFib(4181, 19);
        testFib(17711, 22);
        testFib(317811, 28);
        testFib(39088169, 38);
        testFib(701408733, 44);
        testFib(1836311903, 46);
    }

    @Test
    public void testException() {
        testExcept(Integer.MAX_VALUE);
        testExcept(Integer.MIN_VALUE);
        testExcept(random.nextInt(Integer.MAX_VALUE - 47) + 47);
        testExcept(-random.nextInt(Integer.MAX_VALUE));
        testExcept(47);
        testExcept(-1);
    }

    static private void testFib(int fib, int input) {
        assertEquals(fib, findFibonacciNumber.getFibonacciNumber(input));
    }

    static private void testExcept(int input) {
        try {
            findFibonacciNumber.getFibonacciNumber(input);
            fail();
        } catch (IllegalArgumentException iae) {
            // correct
        }
    }
}
