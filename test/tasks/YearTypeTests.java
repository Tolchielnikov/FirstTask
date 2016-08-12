package tasks;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * test for YearType class
 */
public class YearTypeTests {
    @Test
    public void testYearType() {
        //test amount yeas types
        assertEquals(2, YearType.values().length);

        //test
        testYear("COMMON");
        testYear("LEAP");
    }

    public static void testYear(String year) {
        assertNotNull(YearType.valueOf(year));
    }
}
