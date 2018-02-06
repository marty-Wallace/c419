package labs.lab4;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Smallest Buckets
 * K=19 collisions= 52248 max bucket=5
 * K=43 collisions= 51850 max bucket=5
 * K=9 collisions= 54500 max bucket=6
 *
 *
 * Least Collisions
 * K=29 collisions= 51783 max bucket=6
 * K=31 collisions= 51789 max bucket=6
 * K=43 collisions= 51850 max bucket=5
 *
 */
public class Hashing {

	// with 341116 words, a table size of 1mil keeps the load factor low
	static final int tableSize = 1000000;

	public static void main(String[] args) throws IOException {
	    ArrayList<Result> list = new ArrayList<>();
		for(int k = 1; k <=45; k++) {
            // Leave these two lines alone for opening the input file
            FileReader f = new FileReader("res/labs/lab4/englishWords.txt");
            Scanner sc = new Scanner(f);
            int[] counts = new int[tableSize];
            // This loop runs through the words in the file
            while (sc.hasNext()) {
                String s = sc.nextLine();
                int hash = hash(s, k) % tableSize;
                if (hash < 0) {
                    hash += tableSize;
                }
                counts[hash]++;
            }

            int max = 0;
            int totalCollisions = 0;
            for (int i : counts) {
                max = i > max ? i : max;
                totalCollisions += i > 0? i - 1: 0;
            }
            list.add(new Result(k, totalCollisions, max));
            f.close();
        }
        // Print out the k values with the smallest bucket sizes
        list.sort(Comparator.comparingInt(r -> r.maxBucket));
        System.out.println("Smallest Buckets");
        for(Result r : list) {
            System.out.println(r);
        }
        System.out.println();

        // Print out the K values with the smallest number of collisions
        list.sort(Comparator.comparingInt(r -> r.collisions));
        System.out.println("Least Collisions");
        for(Result r : list) {
            System.out.println(r);
        }
        System.out.println();
	}


	public static int hash(String s, int k) {
		int value = 0;
        for(int i = 0; i < s.length(); i++) {
            value =  value * k + s.charAt(i);
        }
		// s[0]*k^(n-1) + s[1]*k^(n-2) + ... + s[n-1]
		return value;
	}
}

class Result {
    private int k;
    int collisions;
    int maxBucket;

    public Result(int k, int collisions, int maxBucket) {
        this.k = k;
        this.collisions = collisions;
        this.maxBucket = maxBucket;
    }

    public String toString() {
        return "K=" + k + " collisions= " + collisions + " max bucket=" + maxBucket;
    }
}
