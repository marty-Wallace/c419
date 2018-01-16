package labs.lab1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * It is good habit to test each method for correctness when testing a class, this example only
 * uses simple getters/setters but with higher complexity code comes more complicated and involved tests
 * see AdministrationTest for an example
 */
public class UniClassTest {
    UniClass COSC222;
    UniClass MATH200;

    Teacher Andrew;
    Teacher Jennifer;

    Student bill;
    Student ben;
    Student bob;

    @Before
    public void initialize() throws Exception{
        bob = new Student(18, "Bob Maher", new String []{"COSC 222","COSC 311", "MATH 200", "MATH 220"});
        bill = new Student(19, "Bill Cosby", new String []{"COSC 222", "COSC 404", "ENGL 112"});
        ben = new Student(24, "Ben Mckenny", new String []{"COSC 222", "COSC 111", "MATH 200", "PHYS 101"});

        Andrew = new Teacher(36,"Andrew Peterson",  new String []{"COSC 222", "COSC 404", "COSC 111"}, "Computer Science");
        Jennifer = new Teacher(36,"Jennifer Lopez",  new String []{"MATH 200", "MATH 220"}, "Mathematics");

        COSC222 = new UniClass(new Student[]{bob,bill,ben}, Andrew, "COSC 222");
        MATH200 = new UniClass(new Student[]{bob,ben}, Jennifer, "MATH 200");
    }

    @Test
    public void testGetProf() throws Exception {

        assertEquals(COSC222.getProf(), Andrew);
        assertEquals(MATH200.getProf(),Jennifer);
    }

    @Test
    public void testGetClassCode() throws Exception {

        assertEquals(COSC222.getClassCode(), "COSC 222");
        assertEquals(MATH200.getClassCode(), "MATH 200");
    }
}