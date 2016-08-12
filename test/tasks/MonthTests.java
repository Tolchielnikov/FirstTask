package tasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * tests for Month class
 */
public class MonthTests {

    @Test
    public void testMonthType() {
        // test amount months
        assertEquals(12, Month.values().length);

        // test months
        testMonth("DECEMBER");
        testMonth("NOVEMBER");
        testMonth("OCTOBER");
        testMonth("SEPTEMBER");
        testMonth("AUGUST");
        testMonth("JULY");
        testMonth("JUNE");
        testMonth("MAY");
        testMonth("APRIL");
        testMonth("MARCH");
        testMonth("FEBRUARY");
        testMonth("JANUARY");

        // test order of month
        testOrderOfMonth("JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER");
    }

    public static void testMonth(String month) {
        assertNotNull(Month.valueOf(month));
    }

    public static void testOrderOfMonth(String first, String second, String third, String fourth, String fifth, String sixth, String seventh, String eighth, String ninth, String tenth, String eleventh, String twelfth) {
        String months[] = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth};
        for (int i = 0; i < months.length - 1; i++) {
            assertTrue(months[i] + " mast be after " + months[i + 1], Month.valueOf(months[i]).ordinal() < Month.valueOf(months[i + 1]).ordinal());
        }
    }
}
