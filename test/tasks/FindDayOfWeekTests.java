package tasks;
import org.junit.Test;
import static tasks.Month.*;
import static tasks.YearType.*;
import java.util.Random;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

/**
 * test for FindDayOfWeek class
 */
public class FindDayOfWeekTests {
    static FindDayWeek findDayWeek = new FindDayWeek();
    private Random random = new Random();

    @Test
    public void testFindDayOfWeek() {
        //tests by month
        testFindDay("сб", 2, 19, JANUARY, COMMON);
        testFindDay("вт", 7, 31, JANUARY, COMMON);
        testFindDay("чт", 3, 2, JANUARY, COMMON);

        testFindDay("пн", 5, 8, FEBRUARY, LEAP);
        testFindDay("вт", 7, 28, FEBRUARY, COMMON);
        testFindDay("ср", 7, 15, FEBRUARY, COMMON);

        testFindDay("вт", 5, 8, MARCH, LEAP);
        testFindDay("пн", 7, 19, MARCH, LEAP);
        testFindDay("вс", 7, 19, MARCH, COMMON);

        testFindDay("сб", 1, 28, APRIL, COMMON);
        testFindDay("пт", 5, 8, APRIL, LEAP);
        testFindDay("пн", 2, 8, APRIL, COMMON);

        testFindDay("вс", 5, 8, MAY, LEAP);
        testFindDay("ср", 5, 25, MAY, LEAP);
        testFindDay("пн", 5, 30, MAY, LEAP);

        testFindDay("пт", 1, 29, JUNE, COMMON);
        testFindDay("сб", 5, 25, JUNE, LEAP);
        testFindDay("чт", 5, 30, JUNE, LEAP);

        testFindDay("вс", 5, 17, JULY, LEAP);
        testFindDay("пт", 4, 17, JULY, COMMON);
        testFindDay("ср", 2, 24, JULY, COMMON);
        testFindDay("пн", 5, 25, JULY, LEAP);
        testFindDay("пн", 1, 2, JULY, COMMON);

        testFindDay("ср", 5, 31, AUGUST, LEAP);
        testFindDay("пн", 5, 1, AUGUST, LEAP);
        testFindDay("сб", 4, 1, AUGUST, COMMON);

        testFindDay("чт", 5, 1, SEPTEMBER, LEAP);
        testFindDay("вт", 4, 1, SEPTEMBER, COMMON);
        testFindDay("ср", 2, 11, SEPTEMBER, COMMON);

        testFindDay("вс", 5, 30, OCTOBER, LEAP);
        testFindDay("ср", 5, 26, OCTOBER, LEAP);
        testFindDay("вт", 5, 26, OCTOBER, COMMON);

        testFindDay("вт", 3, 25, NOVEMBER, COMMON);
        testFindDay("вт", 5, 15, NOVEMBER, LEAP);
        testFindDay("чт", 5, 10, NOVEMBER, LEAP);

        testFindDay("пт", 5, 30, DECEMBER, LEAP);
        testFindDay("ср", 5, 28, DECEMBER, LEAP);
        testFindDay("вт", 5, 28, DECEMBER, COMMON);

        // test first day of year
        testFindDay("пт", 5, 1, JANUARY, LEAP);
        testFindDay("вт", 2, 1, JANUARY, LEAP);
        testFindDay("ср", 3, 1, JANUARY, LEAP);
        testFindDay("чт", 4, 1, JANUARY, LEAP);
        testFindDay("чт", 4, 1, JANUARY, COMMON);
        testFindDay("вс", 7, 1, JANUARY, COMMON);
        testFindDay("ср", 3, 1, JANUARY, COMMON);
        testFindDay("вт", 2, 1, JANUARY, COMMON);
        testFindDay("пн", 1, 1, JANUARY, COMMON);
        testFindDay("сб", 6, 1, JANUARY, COMMON);

        // test last day of year
        testFindDay("ср", 2, 31, DECEMBER, LEAP);
        testFindDay("чт", 3, 31, DECEMBER, LEAP);
        testFindDay("пт", 4, 31, DECEMBER, LEAP);
        testFindDay("сб", 5, 31, DECEMBER, LEAP);
        testFindDay("чт", 4, 31, DECEMBER, COMMON);
        testFindDay("вс", 7, 31, DECEMBER, COMMON);
        testFindDay("ср", 3, 31, DECEMBER, COMMON);
        testFindDay("вт", 2, 31, DECEMBER, COMMON);
        testFindDay("пн", 1, 31, DECEMBER, COMMON);
        testFindDay("сб", 6, 31, DECEMBER, COMMON);

        // test first adn last day of month
        testFirstAndLastDay("пн", "ср", 31, JANUARY);
        testFirstAndLastDay("чт", "ср", 28, FEBRUARY);
        testFirstAndLastDay("чт", "сб", 31, MARCH);
        testFirstAndLastDay("вс", "пн", 30, APRIL);
        testFirstAndLastDay("вт", "чт", 31, MAY);
        testFirstAndLastDay("пт", "сб", 30, JUNE);
        testFirstAndLastDay("вс", "вт", 31, JULY);
        testFirstAndLastDay("ср", "пт", 31, AUGUST);
        testFirstAndLastDay("сб", "вс", 30, SEPTEMBER);
        testFirstAndLastDay("пн", "ср", 31, OCTOBER);
        testFirstAndLastDay("чт", "пт", 30, NOVEMBER);
        testFirstAndLastDay("сб", "пн", 31, DECEMBER);

        // test last day of august
        testFindDay("ср", 5, 31, AUGUST, LEAP);
        testFindDay("вс", 3, 31, AUGUST, COMMON);
        testFindDay("пт", 1, 31, AUGUST, COMMON);
        testFindDay("пн", 4, 31, AUGUST, COMMON);

        // test  Feb.
        testFindDay("пн", 5, 29, FEBRUARY, LEAP);
        testFindDay("пт", 2, 1, FEBRUARY, LEAP);
        testFindDay("пт", 2, 29, FEBRUARY, LEAP);
        testFindDay("чт", 1, 1, FEBRUARY, COMMON);
        testFindDay("ср", 1, 28, FEBRUARY, COMMON);
        testFindDay("сб", 4, 28, FEBRUARY, COMMON);
    }

    @Test
    public void testException() {
        // test test negative arguments
        testToException(-1, 1, JANUARY, LEAP);
        testToException(1, -1, JULY, LEAP);
        testToException(-1, 1, JANUARY, COMMON);
        testToException(1, -1, JULY, COMMON);
        testToException(-random.nextInt(Integer.MAX_VALUE), 1, DECEMBER, COMMON);
        testToException(2, -random.nextInt(Integer.MAX_VALUE), MAY, COMMON);

        // test max arguments
        testToException(Integer.MAX_VALUE, 1, DECEMBER, LEAP);
        testToException(1, Integer.MAX_VALUE, DECEMBER, LEAP);
        testToException(Integer.MAX_VALUE, 1, DECEMBER, COMMON);
        testToException(1, Integer.MAX_VALUE, DECEMBER, COMMON);

        //test parameter limit
        testToException(8, 1, JULY, LEAP);
        testToException(1, 32, JULY, LEAP);
        testToException(8, 1, JULY, COMMON);
        testToException(1, 32, JULY, COMMON);
        testToException(random.nextInt(Integer.MAX_VALUE - 8) + 8, 1213, AUGUST, LEAP);
        testToException(5654, random.nextInt(Integer.MAX_VALUE - 32) + 32, SEPTEMBER, LEAP);

        // test zero arguments
        testToException(0, 1, AUGUST, LEAP);
        testToException(1, 0, AUGUST, LEAP);
        testToException(0, 1, AUGUST, COMMON);
        testToException(1, 0, AUGUST, COMMON);

        // test Feb.
        testToException(5, 29, FEBRUARY, COMMON);
        testToException(1, 29, FEBRUARY, COMMON);
        testToException(5, 30, FEBRUARY, LEAP);

        // test fo null
        testToException(1, 1, null, COMMON);
        testToException(1, 1, JULY, null);
        testToException(1, 1, null, null);
    }

    private static void testFindDay(String d, int newYear, int day, Month month, YearType year) {
        assertEquals(d, findDayWeek.getDayWeek(newYear, day, month, year));
    }

    private static void testFirstAndLastDay(String firstDay, String lastDay, int lastDayOfMonth, Month month) {
        assertEquals(firstDay, findDayWeek.getDayWeek(1, 1, month, COMMON));
        assertEquals(lastDay, findDayWeek.getDayWeek(1, lastDayOfMonth, month, COMMON));
    }

    private static void testToException(int newYear, int day, Month month, YearType year) {
        try {
            findDayWeek.getDayWeek(newYear, day, month, year);
            fail();
        } catch (IllegalArgumentException iae) {
            //correct
        }
    }
}
