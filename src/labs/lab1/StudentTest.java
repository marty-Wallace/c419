package labs.lab1;

import org.junit.Before;
import org.junit.Test;

/**
 * TODO: complete the following test. Use other test cases in the other Test files for sample syntax.
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
        //TODO: test that the classes array returned is correct
    }

    @Test
    public void testGetAge() throws Exception {
        //TODO: test that the age returned is correct
    }
}	