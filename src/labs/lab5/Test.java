package labs.lab5;

// TODO: there are 3 "to do" items below, and 1 bonus TODO
import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Before;

public class Test {

	/* Declaration of the test objects */
	
	Requests r;
	Iterator<Customer> i;
	/* Instantiation of the objects */
	
	@Before
	public void initialize() {
		System.out.println("Initializing");
		r = new Requests();
		
	}

	@org.junit.Test
	public void test1() {
		System.out.print("Test 1: ");
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		System.out.print("Check");
	}

	@org.junit.Test
	public void test2() {
		System.out.print("Test 2: ");
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
	}

	@org.junit.Test
	public void test3() {
		System.out.print("Test 3: ");
        r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
	}

	@org.junit.Test
	public void test4() {
		System.out.print("Test 4: ");
        r.add("Jim", 0);
		r.add("Jenny",0);
		r.add("Julie",0);
		r.add("Jason",0);
		r.add("Jessica",0);
		r.add("Jackie", 0);
		r.add("CowboyNeal", 0);
		r.add("Val", 0);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
	}

	@org.junit.Test
	public void test5() {
		System.out.print("Test 5: ");
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Joseph",5);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		System.out.print("Test 1: ");
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
	}

	// test if removal works
	@org.junit.Test
	public void test6() {
		System.out.print("Test 6: ");
        r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Joseph",5);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		while(i.hasNext()) {
			Customer c = i.next();
			if (c.getName().equals("CowboyNeal")){
				i.remove();
			}
		}
		i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"Val");
	}
	
}
