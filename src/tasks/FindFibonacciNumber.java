package tasks;

/**
 * finds a Fibonacci number by index
 *
 * @author Nikolai Tolchelnikov
 */
public class FindFibonacciNumber {
    /**
     * maximum value that can be considered a program
     */
    private static final int MAX_FIBONACCI = 47;

    /**
     * Finds a Fibonacci number by its index number
     *
     * @param n index of the Fibonacci series
     * @return Fibonacci by its index
     * @throws IllegalArgumentException index don't may be negative
     *                                  Fibonacci index above 46 are not intermeddle in Int
     */

    public int getFibonacciNumber(int n) {
        if (n < 0 || n >= MAX_FIBONACCI) {
            throw new IllegalArgumentException("can't be less 0 or more then 46. N = " + n);
        }
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }
}
