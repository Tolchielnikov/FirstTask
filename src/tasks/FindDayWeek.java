package tasks;
import static tasks.Month.*;

/**
 * finds the day of the week using the specified parameters
 * Created by zOpa on 15.07.2016.
 */
public class FindDayWeek {

    /**
     *  days per week
     */
    private static final int DAYS_OF_WEEK = 7;

    /**
     * all days of the week
     */
    private static final String weekdaysName[] = {"вс", "пн", "вт", "ср", "чт", "пт", "сб"};

    /**
     * the number of days in each month, common year
     */

//    private static final int allLastDaysOfMonthInCommonYear[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * the number of days in each month, leap year
     */
  //  private static final int allLastDaysOfMonthInLeapYear[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * calculates the day of the week given the date and day new year
     *
     * @param newYearDay day week of January 1st
     * @param day        day of the month that you want to find
     * @param month      of the year that you want to find
     * @param year       a leap or a common year
     * @return day of the week the desired date
     * @throws IllegalArgumentException day can't be negative or more days in month
     * @throws IllegalArgumentException new year day can't be negative or more days in week
     */
    public String getDayWeek(int newYearDay, int day, Month month, YearType year) {

        if (month == null) {                                   //check month
            throw new IllegalArgumentException("month type don't can be empty");
        }

        if (year == null) {                                   //check year type
            throw new IllegalArgumentException("year type don't can be empty");
        }

        if (day <= 0) {                                      //check days in month
            throw new IllegalArgumentException("day can not be negative  = " + day);
        }

        if (newYearDay <= 0 || newYearDay > DAYS_OF_WEEK) {  //check days in week
            throw new IllegalArgumentException("can't be 0 or less of mount more than 12. New YearType Day = " + newYearDay + " valid values = 1 to 7");
        }

        checkDayOfMonth(day, month, year);                  //check days in month

        int allDay=0;       //the number of days elapsed from 01.01 to desired date;

        if (year == YearType.LEAP) {
          //  allDay = getAllDay(month, allLastDaysOfMonthInLeapYear);
        } else {
           // allDay = getAllDay(month, allLastDaysOfMonthInCommonYear);
        }

        allDay = allDay + day + newYearDay - 1; // in allDay considered first day of year

        int dayOfWeek = (allDay % DAYS_OF_WEEK);

        return weekdaysName[dayOfWeek];
    }

    /**
     * find the number of days elapsed from 01.01 to past months
     *
     * @param month           month name
     * @param lastDaysOfMonth array stores all the last days of the month
     * @return all the past days by month
     */

    private static int getAllDay(Month month, int lastDaysOfMonth[]) {
        int allDay = 0;
        for (int i = 0; i < month.ordinal(); i++) {
            allDay += lastDaysOfMonth[i];
        }
        return allDay;
    }

    /**
     * check number of days in the month, taking into account the leap year and non-leap year
     *
     * @param day   day of month
     * @param month month of year
     * @param year  year type
     * @return true if all ok and false if day not value
     */
    private static void checkDayOfMonth(int day, Month month, YearType year) {
        if (year == YearType.COMMON) {
    //        if (day > month) {
   //             throw new IllegalArgumentException("Day can be = " + day + " valid value = 1 to " + allLastDaysOfMonthInCommonYear[month.ordinal()]);
            }
      //  } else if (day > allLastDaysOfMonthInLeapYear[month.ordinal()]) {
 //           throw new IllegalArgumentException("Day can be = " + day + " valid value = 1 to " + allLastDaysOfMonthInCommonYear[month.ordinal()]);
        }
  //  }
}
