package labs.lab5;

import java.util.Iterator;

/** Example usage of the Requests class and its iterator.
 *  You can play all you like here.
 * 
 * @author cosc419
 *
 */

public class MainCustomers {

	public static void main(String[] args) {

		Requests r = new Requests();
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
			if (c.getName().equals("CowboyNeal")) i.remove();
			System.out.println(c);
		}

		
		System.out.println("-----------BONUS-----------");
		
		i = r.iterator();
		while(i.hasNext()) {
			Customer c = i.next();
			System.out.println(c);
		}

		/*
		 * Expected output is:
		 * 
		 * [Jim, Platinum]
		 * [Jessica, Platinum]
		 * [Jenny, Gold]
		 * [Jackie, Gold]
		 * [Julie, Silver]
		 * [Jason, Silver]
		 * [CowboyNeal, Silver]
		 * [Val, Bronze]
		-----------BONUS-----------
		 * [Jim, Platinum]
		 * [Jessica, Platinum]
		 * [Jenny, Gold]
		 * [Jackie, Gold]
		 * [Julie, Silver]
		 * [Jason, Silver]
		 * [Val, Bronze]
		 */
		
	}

}
