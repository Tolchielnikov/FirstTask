package tasks;

/**
 * finds the greatest common divisor (getGCDForTwo) of the 4 numbers
 *
 * @author Nikolai Tolchelnikov
 *         Created by on 11.07.2016.
 */
public class FindsGCD {
    /**
     * finds the greatest common divisor (gcd) of the 4 numbers
     *
     * @param a 1st
     * @param b 2nd
     * @param c 3rd
     * @param d 4th
     * @return gcd for 4 numbers
     */
    public int getGCDForFour(int a, int b, int c, int d) {
        if (a == 0 && b == 0 && c == 0 && d == 0) {
            throw new IllegalArgumentException("can not be gcd for all arguments zeros");
        }

        int gcdForFour = getGCDForTwo(getGCDForTwo(a, b), getGCDForTwo(c, d));

        return Math.abs(gcdForFour);
    }

    /**
     * finds the greatest common divisor (gcd) of the 2 numbers
     *
     * @param a 1st
     * @param b 2nd
     * @return gcd for 2 numbers
     */
    private int getGCDForTwo(int a, int b) {
        if (b == 0) return a;
        int x = a % b;
        return getGCDForTwo(b, x);
    }
}
