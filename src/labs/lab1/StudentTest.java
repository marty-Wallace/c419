package labs.lab1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

/**
 * complete the following test. Use other test cases in the other Test files for sample syntax.
 */
public class StudentTest {

    Student bill;
    Student ben;
    Student bob;

    @Before
    public void initialize() throws Exception{
        bob = new Student(18, "Bob Maher", new String []{"COSC 222","COSC 311", "MATH 200", "MATH 220"});
        bill = new Student(19, "Bill Cosby", new String []{"COSC 222", "COSC 404", "ENGL 112"});
        ben = new Student(24, "Ben Mckenny", new String []{"COSC 222", "COSC 111", "MATH 200", "PHYS 101"});
    }

    @Test
    public void testGetClasses() throws Exception {
        String[] classes = bob.getClasses();
        assertTrue(Arrays.equals(classes, new String[]{"COSC 222", "COSC 311", "MATH 200", "MATH 220"}));
        classes = bill.getClasses();
        assertTrue(Arrays.equals(classes, new String[]{"COSC 222", "COSC 404", "ENGL 112"}));
        classes = ben.getClasses();
        assertTrue(Arrays.equals(classes, new String[]{"COSC 222", "COSC 111", "MATH 200", "PHYS 101"}));
    }

    @Test
    public void testGetAge() throws Exception {
        assertTrue(bob.getAge() == 18);
        assertTrue(bill.getAge() == 19);
        assertTrue(ben.getAge() == 24);
    }
}	