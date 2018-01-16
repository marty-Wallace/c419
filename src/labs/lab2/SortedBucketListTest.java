package labs.lab2;

// This file will pass all tests without errors when BucketList
// and SortedBucket are implemented

// TODO: there are 3 "to do" items below


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SortedBucketListTest {

	/* Declaration of the test objects */
	
	BucketList<String> b;
	ArrayList<Entry<String>> everyone;
	Entry<String> jim, val, C, B, A, Aplus;
	
	/* Instantiation of the objects */
	
	@Before
	public void initialize() {
		everyone = new ArrayList<>();
		jim = new Entry<>(94 , "Jim");
		val = new Entry<>(93 , "Val");
		C = new Entry<>(68 , "C-Student");
		B = new Entry<>(72 , "B-Student");
		A = new Entry<>(84 , "A-Student");
		Aplus = new Entry<>(98 , "A-plus-Student");

		everyone.add(jim);
		everyone.add(val);
		everyone.add(C);
		everyone.add(B);
		everyone.add(A);
		everyone.add(Aplus);

	}

	/* Various tests follow */
	
	@Test
	public void test1() {
		// BucketList constructor takes (min,max,numBuckets)
		b = new BucketList<String>(0,100,6);
		b.addAll(everyone);
		ArrayList<Entry<String>> list4 = new ArrayList<>();
		list4.add(C);
		list4.add(B);
		list4.add(A);
		ArrayList<Entry<String>> list5 = new ArrayList<>();
		list5.add(val);
		list5.add(jim);
		list5.add(Aplus);
		//System.out.println(list4);
		//System.out.println(list5);
		//System.out.println(b);
		
		// .equals in ArrayLists compares corresponding items
		assertTrue(b.getBucket(4).equals(list4)
					&& b.getBucket(5).equals(list5)
					&& b.getBucket(0).isEmpty()
					&& b.getBucket(1).isEmpty()
					&& b.getBucket(2).isEmpty()
					&& b.getBucket(3).isEmpty());
	}

	@Test
	public void test2() {
		// BucketList constructor takes (min,max,numBuckets)
		b = new BucketList<>(0,100,5);
		b.addAll(everyone);

		// Figure out (on paper?) where these 6 Entry objects should
		// be in the case of 5 buckets. Then build a test
		// like in test1() to check each of the 5 buckets
		// for the correct contents (and correct order of contents)
		// (Note that list4 and list5 in test1 had their elements
		// added so that the resulting list is in sorted order so
		// that testing the corresponding bucket is easier.

		// Use whichever lists you need (see test1() )

		ArrayList<Entry<String>> list3 = new ArrayList<>();

		list3.add(C);
		list3.add(B);

		ArrayList<Entry<String>> list4 = new ArrayList<>();
		list4.add(A);
		list4.add(val);
		list4.add(jim);
		list4.add(Aplus);

		assertTrue(b.getBucket(0).isEmpty() // complete this test
                && b.getBucket(1).isEmpty()
				&& b.getBucket(2).isEmpty()
				&& b.getBucket(3).equals(list3)
                && b.getBucket(4).equals(list4)
				    );
	}

	@Test
	public void test3() {
		// BucketList constructor takes (min,max,numBuckets)
		b = new BucketList<>(0,100,4);
		b.addAll(everyone);
		
		// Write this test similar to test2(). But this time these
		// six Entry Objects are added into a BucketList with 4 buckets

		ArrayList<Entry<String>> list2 = new ArrayList<>();

		list2.add(C);
		list2.add(B);

		ArrayList<Entry<String>> list3 = new ArrayList<>();
		list3.add(A);
		list3.add(val);
		list3.add(jim);
		list3.add(Aplus);
		assertTrue(b.getBucket(0).isEmpty()
				&& b.getBucket(1).isEmpty()
				&& b.getBucket(2).equals(list2)
				&& b.getBucket(3).equals(list3)
		);
	}
	
	@Test
	public void emptyTest() {
		// BucketList constructor takes (min,max,numBuckets)
		// Testing if we can construct in the negative range, and if
		// it will still perform "sort" without crashing if all buckets
		// are empty
		b = new BucketList<String>(-50,50,6);
		assertTrue(b.getNumBuckets()==6 && b.getSortedOrder().size()==0); 
	}

	@Test
	public void perfectStudentTest() {
		// test where an Entry named "perfect" with a score of 100 will
		// be placed in a BucketList which stores grades from 0 to 100 and
		// having 10 buckets.
		
		b = new BucketList<>(0,100,10);
		b.add(new Entry<>(100,"perfect"));
		assertTrue(b.getBucket(9).size()==1); 
	}

	@Test
	public void outOfBoundsTest1() {
		// tests if we can add an Entry with key value larger than max
		
		b = new BucketList<>(0,100,10);
		b.add(new Entry<>(110,"superPerfect"));
		assertTrue(b.getBucket(9).size()==1); 
	}

	@Test
	public void outOfBoundsTest2() {
		// tests if we can add an Entry with key value less than min
		
		b = new BucketList<String>(0,100,10);
		b.add(new Entry<>(-110,"notSoPerfect"));
		assertTrue(b.getBucket(0).size()==1); 
	}

	/**
	 * Tests that the list is in sorted order
	 */
	@Test
	public void additionalTest() {
		//Write an additional test that
		//is different from the above
		b = new BucketList<>(0,100,10);
		b.addAll(everyone);

        Entry<String> marty = new Entry<>(108, "Marty");
        Entry<String> youngdum = new Entry<>(-18, "Young Dum");

        b.add(marty);
        b.add(youngdum);

        ArrayList<Entry<String>> sorted = new ArrayList<>();

        sorted.add(youngdum);
		sorted.add(C);
		sorted.add(B);
		sorted.add(A);
		sorted.add(val);
		sorted.add(jim);
		sorted.add(Aplus);
		sorted.add(marty);

		assertTrue(b.getSortedOrder().equals(sorted));

	}

}
