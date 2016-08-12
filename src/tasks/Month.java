package tasks;

/**
 * month name that can be used
 */
public enum Month {

    /**
     * first month
     */
    JANUARY(31, 31),
    /**
     * second month
     */
    FEBRUARY(28, 29),

    /**
     * the third month
     */
    MARCH(31, 31),

    /**
     * fourth month
     */
    APRIL(30, 30),

    /**
     * fifth month
     */
    MAY(31, 31),

    /**
     * sixth month
     */
    JUNE(30, 30),

    /**
     * seventh month
     */
    JULY(31, 31),

    /**
     * eighth month
     */
    AUGUST(31, 31),

    /**
     * ninth month
     */
    SEPTEMBER(30, 30),

    /**
     * tenth month
     * w
     */
    OCTOBER(31, 31),

    /**
     * eleventh month
     */
    NOVEMBER(30, 30),

    /**
     * twelfth month
     */
    DECEMBER(31, 31);

    private final int daysInMonth;
    private final int daysInMonthInLeapYear;

    Month (int daysInMonth, int daysInMonthInLeapYear)
    {
        this.daysInMonth = daysInMonth;
        this.daysInMonthInLeapYear = daysInMonthInLeapYear;
    }

    /**
     * get the number of days in the month in common year
     * @return number of days in the month
     */
    public int getDaysInCommonYear() { return daysInMonth; }

    /**
     * get the number of days in the month in leap year
     * @return number of days in the month
     */
    public int getDaysInLeapYear() { return daysInMonthInLeapYear; }
}
