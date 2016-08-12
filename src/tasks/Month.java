package tasks;

/**
 * months types that can be used
 */
public enum Month {

    /**
     * first month
     */
    JANUARY(31),
    /**
     * second month
     */
    FEBRUARY(28, 29),

    /**
     * the third month
     */
    MARCH(31),

    /**
     * fourth month
     */
    APRIL(30),

    /**
     * fifth month
     */
    MAY(31),

    /**
     * sixth month
     */
    JUNE(30),

    /**
     * seventh month
     */
    JULY(31),

    /**
     * eighth month
     */
    AUGUST(31),

    /**
     * ninth month
     */
    SEPTEMBER(30),

    /**
     * tenth month
     * w
     */
    OCTOBER(31),

    /**
     * eleventh month
     */
    NOVEMBER(30),

    /**
     * twelfth month
     */
    DECEMBER(31);

    Month(int daysInMonth) {

    }

    Month(int daysInMonth, int daysInMonthInLeapYear) {

    }
}
