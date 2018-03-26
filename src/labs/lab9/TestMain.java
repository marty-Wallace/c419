package labs.lab9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class TestMain {

	public static void main(String[] args) throws FileNotFoundException {

		Graph g1 = readGraph("res/labs/lab9/small1");
        Graph g2 = readGraph("res/labs/lab9/small2");
        Graph g3 = readGraph("res/labs/lab9/medium1");
        Graph g4 = readGraph("res/labs/lab9/medium2");
        Graph g5 = readGraph("res/labs/lab9/medium3");
        Graph g6 = readGraph("res/labs/lab9/medium4");

		//
        System.out.println(connectable(g1));
        System.out.println(connectable(g2));
        System.out.println(connectable(g3));
        System.out.println(connectable(g4));
        System.out.println(connectable(g5));
        System.out.println(connectable(g6));

	}

	public static boolean connectable(Graph g) {

	    //System.out.println(g);
	    HashSet<String> seen = new HashSet<>();

	    String colour = g.getKeySet()
                .stream()
                .findFirst()
                .get();

	    Stack<String> st = new Stack<>();
	    st.push(colour);
	    while(!st.isEmpty()) {
	        String current = st.pop();
	        seen.add(current);
	        g.getNbrs(current)
                    .stream()
                    .filter(c -> !seen.contains(c))
                    .forEach(st::push);
        }

        if (seen.size() != g.getKeySet().size() || !seen.containsAll(g.getKeySet())) {
	        return false;
        }

        int oddCount = 0;
        for( String s: g.getKeySet()) {
	        if(g.getNbrs(s).size() % 2 == 1){
	            oddCount++;
            }
        }
        return oddCount <= 2 && oddCount != 1;
    }

	/**
	 * This function reads a list of edges from a given filename
	 * and returns a simple Graph.
	 * DO NOT EDIT THIS METHOD.
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Graph readGraph(String filename) throws FileNotFoundException {

		FileReader f = new FileReader(filename);
		Scanner sc = new Scanner(f);

		Graph g = new Graph();
		while (sc.hasNext()) {
			String u = sc.next();
			String v = sc.next();
			g.add(u);
			g.add(v);
			g.add(u,v);
		}
		sc.close();
		return g;
	}
}
