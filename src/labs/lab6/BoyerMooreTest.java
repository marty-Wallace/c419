package labs.lab6;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoyerMooreTest {

    private ISearch searchAlgorithm;

    @Before
    public void initialize() {
        searchAlgorithm = new BoyerMoore("");
    }

    @Test
    public void simpleContains() {
        searchAlgorithm.setPattern("Hello");
        assertTrue(searchAlgorithm.isIn("Hello World"));
    }

    @Test
    public void emptyContains() {
        searchAlgorithm.setPattern("");
        assertTrue(searchAlgorithm.isIn("ANY STRING"));
    }

    @Test
    public void testEmptyText() {
        searchAlgorithm.setPattern("Any String");
        assertFalse(searchAlgorithm.isIn(""));
    }

    @Test
    public void patternLongerThanText() {
        searchAlgorithm.setPattern("A VERY LONG STRING DOGDOGDOGDOGDOGDOGDOGDOGDOGDOGDOGDOGDOGDOGDOGDOGDOGDOGDOGDOG");
        assertFalse(searchAlgorithm.isIn("Shorter String Dawg"));
    }

    @Test
    public void testCase() {
        searchAlgorithm.setPattern("mARTY lIKES dOGS");
        assertFalse(searchAlgorithm.isIn("Marty Likes Dogs"));
    }

    @Test
    public void offByOneFalse() {
        searchAlgorithm.setPattern("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertFalse(searchAlgorithm.isIn("ABCDEFGHIJKLMNOPQRSTUVWXY"));
    }

    @Test
    public void offByOneTrue() {
        searchAlgorithm.setPattern("ABCDEFGHIJKLMNOPQRSTUVWXY");
        assertTrue(searchAlgorithm.isIn("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    public void isFirst() {
        searchAlgorithm.setPattern("A");
        assertTrue(searchAlgorithm.isIn("ABCD"));
    }

    @Test
    public void isLast() {
        searchAlgorithm.setPattern("D");
        assertTrue(searchAlgorithm.isIn("ABCD"));
    }

    @Test
    public void areSame() {
        searchAlgorithm.setPattern("Jeremiah was a bullfrog");
        assertTrue(searchAlgorithm.isIn("Jeremiah was a bullfrog"));
    }


    @Test
    public void testToString() {
        assertTrue(searchAlgorithm.toString().equals("BoyerMoore"));
    }
}
