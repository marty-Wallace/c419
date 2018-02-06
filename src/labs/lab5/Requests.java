package labs.lab5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/** This class maintains customer requests of customer loyalty types: Platinum, Gold, Silver, and Bronze. 
 * These will be implemented as loyalty 0, 1, 2, 3, respectively.
 * It implements the Iterable interface, meaning
 * a user can create an iterator to iterate through the items it contains.
 * 
 * The order in which customers should be iterated is through their loyalty rank first, (platinum first, bronze last)
 * and then in order in which these customers were placed in the collection.
 * 
 * @author cosc419
 *
 */

public class Requests implements Iterable<Customer> {

	private int size;
	private ArrayList<LinkedList<Customer>> reqs;
	
	public Requests() {
		size = 0;

		// This is going to be an arrayList of 4 LinkedLists
		reqs = new ArrayList<>();
		
		reqs.add(new LinkedList<>()); // index 0 is platinum
		reqs.add(new LinkedList<>()); // index 1 is gold
		reqs.add(new LinkedList<>()); // index 2 is silver
		reqs.add(new LinkedList<>()); // index 3 is bronze
	}

	/**
	 * Adds a customer by name,loyalty (0=platinum, 1=gold, 2=silver, 3=bronze)
	 * @param name
	 * @param loy
	 */
	public void add(String name, int loy) {
		//Leave this method as is. Complete the next method.
		add(new Customer(name,loy));
	}
	
	public void add(Customer c) {
		// Leave this line as is. If a customer is invalid, its loyalty program is set to -1
		if (c.getLoyalty() == -1) return;
		if (c.getLoyalty() < 0 || c.getLoyalty() > 3) {
			return;
		}
		reqs.get(c.getLoyalty()).add(c);
		size++;
	}

	@Override
	public Iterator<Customer> iterator() {
		// Do not move this class. It is an inner-class to the Requests class
		// See https://stackoverflow.com/questions/5849154/can-we-write-our-own-iterator-in-java
		// For an example of creating your own iterator.
		
		Iterator<Customer> itr = new Iterator<Customer>() {

			private int index = 0;

			@Override
			public boolean hasNext() {
			    return index < size;
			}

			@Override
			public Customer next() {
				//the cusomters in Platinum go first (if any), the customers in Gold go next (if any), etc.
                int tempIndex = index;
                int loyaltyIndex = 0;
                for(int i = 0; i < reqs.size(); i++) {
                	if(tempIndex < reqs.get(i).size()) {
                		break;
					}
					tempIndex -= reqs.get(i).size();
                	loyaltyIndex++;
				}
				index++;
				return reqs.get(loyaltyIndex).get(tempIndex);
			}
		
			@Override
			public void remove() {
				//TODO: You can earn up to 8/10 marks for this assignment
				// without completing this method.
				// .remove is in the Iterable interface, but it is an optional method that can be omitted.
				// This method must remove the last item returned by this iterator

				if(index == 0) {
					return;
				}

				int tempIndex = index -1;
				int loyaltyIndex = 0;
				for(int i = 0; i < reqs.size(); i++) {
					if(tempIndex < reqs.get(i).size()){
						break;
					}
					tempIndex -= reqs.get(i).size();
					loyaltyIndex++;
				}
				reqs.get(loyaltyIndex).remove(tempIndex);
				index--;
				size--;
			}
			
		};
		return itr;
	}
	
	
	
	
}
