package labs.lab3;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The main maze-solving class. First, you should build a solution using a Queue.
 * Once you have a queue-based solution, you should be able to simply copy-and-paste it into
 * the stack-based method and replace your
 * Queue<Integer> q = new LinkedList<>();
 * with
 * Stack<Integer> q = new Stack<>();
 * 
 * and then change .poll() to .pop() and this will hopefully give you a solution using Stacks.
 * 
 *
 */
public class Solver {

	// Leave this here. No other static variables needed. Reference to N is static so that location()-based
	// methods work without you having to pass N into the location or getRow or getCol functions
	static int N;

	public static void solveWithQueue(String filename) {

		// Gets the Maze object from file
		Maze m = MazeReader.readMazeFromFile(filename);
		N = m.getSize();
		
		// This creates your own character map which you can edit so you can keep track of where your solver has looked
		char[][] myMap = new char[N][N];

		// This performs a deep copy of the map
		for (int row=0; row<N; row++) {
			for (int col=0; col<N; col++) {
				myMap[row][col] = m.get(row, col);
			}
		}

		 Queue<Integer> q = new LinkedList<>();



		// Use m.getStartRow() and m.getStartCol() to get the starting location of the maze m
		int start = location(m.getStartRow(), m.getStartCol());
		q.add(start);

		int end = location(m.getTargetRow(), m.getTargetCol());

		
		// this sets the starting location on myMap to another symbol 'x' so that we have a way
		// to see that it has been processed before, so we don't add it to our queue again
		myMap[m.getStartRow()][m.getStartCol()] = 'x';

		// This is just a flag variable indicating that no solution has been found yet
		boolean solutionFound = false;
		
		// Your final output should count the number of iterations of queue-popping this maze takes.
		// So this variable should increment every iteration
		int count = 0;
		
		// Your final output should also report what the largest size the queue reached during this program's execution
		int maxQSize = 1;

		while (!q.isEmpty()) {
			// You can display your map and the state of your queue using a given displayMyMap function.
			// Be sure to re-comment this displayMyMap line when submitting.
			// displayMyMap(myMap,q);

			int nextLocation = q.poll();
            // Use m.getTargetRow() and m.getTargetCol() to get the target of the maze m.
            if(nextLocation == end) {
                solutionFound = true;
                break;
            }
			count++;


			
			// These lines extract the Row and Col index values from the location integer.
			int currentRow = getRow(nextLocation);
			int currentCol = getCol(nextLocation);
			


			// For your answers to match ours, you must search in the order of NORTH, EAST, SOUTH, WEST
			// 'N'ever 'E'at 'S'limy 'W'orms
			
			// NORTH: Check if NORTH position is on the map AND that it is an available spot on myMap
			if (currentRow-1 >=0 && myMap[currentRow-1][currentCol] == '.') {
				myMap[currentRow-1][currentCol] = 'x';
				q.add(location(currentRow-1,currentCol));
			}

			// EAST:
			if (currentCol+1 < m.getSize() && myMap[currentRow][currentCol+1] == '.') {
				myMap[currentRow][currentCol+1] = 'x';
				q.add(location(currentRow,currentCol+1));
			}

			// SOUTH:
			if (currentRow+1 < m.getSize() && myMap[currentRow+1][currentCol] == '.') {
				myMap[currentRow+1][currentCol] = 'x';
				q.add(location(currentRow+1,currentCol));
			}

			// WEST:
			if (currentCol-1 >= 0 && myMap[currentRow][currentCol-1] == '.') {
				myMap[currentRow][currentCol-1] = 'x';
				q.add(location(currentRow,currentCol-1));
			}

			maxQSize = Math.max(maxQSize, q.size());
		}
		
		
		// Nothing to do here. If the above implementation correctly
		// updated the variables: solutionFound, count, and maxQsize, then the following displays your results. 
		if (!solutionFound) {
			System.out.println(filename + " Queue ran out of items after " + count + " iterations. No solution to maze.");
		}
		else {
			System.out.println(filename + " Solution found after " + count + " iterations.");
		}
		System.out.println("The largest size of the queue was " + maxQSize);
	}
	
	public static void solveWithStack(String filename) {

        // Gets the Maze object from file
        Maze m = MazeReader.readMazeFromFile(filename);
        N = m.getSize();

        // This creates your own character map which you can edit so you can keep track of where your solver has looked
        char[][] myMap = new char[N][N];

        // This performs a deep copy of the map
        for (int row=0; row<N; row++) {
            for (int col=0; col<N; col++) {
                myMap[row][col] = m.get(row, col);
            }
        }

        Stack<Integer> stack = new Stack<>();


        // Use m.getStartRow() and m.getStartCol() to get the starting location of the maze m
        int start = location(m.getStartRow(), m.getStartCol());
        stack.push(start);

        int end = location(m.getTargetRow(), m.getTargetCol());


        // this sets the starting location on myMap to another symbol 'x' so that we have a way
        // to see that it has been processed before, so we don't add it to our queue again
        myMap[m.getStartRow()][m.getStartCol()] = 'x';

        // This is just a flag variable indicating that no solution has been found yet
        boolean solutionFound = false;

        // Your final output should count the number of iterations of queue-popping this maze takes.
        // So this variable should increment every iteration
        int count = 0;

        // Your final output should also report what the largest size the queue reached during this program's execution
        int maxQSize = 1;

        while (!stack.isEmpty()) {
            // You can display your map and the state of your queue using a given displayMyMap function.
            // Be sure to re-comment this displayMyMap line when submitting.
            // displayMyMap(myMap,q);

            int nextLocation = stack.pop();
            // Use m.getTargetRow() and m.getTargetCol() to get the target of the maze m.
            if(nextLocation == end) {
                solutionFound = true;
                break;
            }
            count++;



            // These lines extract the Row and Col index values from the location integer.
            int currentRow = getRow(nextLocation);
            int currentCol = getCol(nextLocation);





            // For your answers to match ours, you must search in the order of NORTH, EAST, SOUTH, WEST
            // 'N'ever 'E'at 'S'limy 'W'orms

            // NORTH: Check if NORTH position is on the map AND that it is an available spot on myMap
            if (currentRow-1 >=0 && myMap[currentRow-1][currentCol] == '.') {
                myMap[currentRow-1][currentCol] = 'x';
                stack.add(location(currentRow-1,currentCol));
            }

            // EAST
            if (currentCol+1 < m.getSize() && myMap[currentRow][currentCol+1] == '.') {
                myMap[currentRow][currentCol+1] = 'x';
                stack.add(location(currentRow,currentCol+1));
            }

            // SOUTH:
            if (currentRow+1 < m.getSize() && myMap[currentRow+1][currentCol] == '.') {
                myMap[currentRow+1][currentCol] = 'x';
                stack.add(location(currentRow+1,currentCol));
            }

            // EAST
            if (currentCol-1 >= 0 && myMap[currentRow][currentCol-1] == '.') {
                myMap[currentRow][currentCol-1] = 'x';
                stack.add(location(currentRow,currentCol-1));
            }

            maxQSize = Math.max(maxQSize, stack.size());
        }


        // Nothing to do here. If the above implementation correctly
        // updated the variables: solutionFound, count, and maxQsize, then the following displays your results.
        if (!solutionFound) {
            System.out.println(filename + " Stack ran out of items after " + count + " iterations. No solution to maze.");
        }
        else {
            System.out.println(filename + " Solution found after " + count + " iterations.");
        }
        System.out.println("The largest size of the stack was " + maxQSize);
	}

	

	/**
	 * Creates a location number from a row and column.
	 * e.g. on a 10 by 10 board, row index 4 and column index 3 would yield location 43.
	 * @param row = 0-indexed row 
	 * @param col = 0-indexed column
	 */
	private static int location(int row, int col) {
	    return row * N + col;
	}

	/**
	 * Gets the row index from a location number.
	 * Note that the first row is row 0.
	 * @param location
	 */
	private static int getRow(int location) {
	    return location / N;
	}

	/**
	 * Gets the column index from a location number
	 * Note that the first column is column 0.
	 * @param location
	 */
	private static int getCol(int location) {
	    return location % N;
	}

	
	
	/**
	 * Do not edit this method. It will display the current state of your map, which should 
	 * show all available spaces, all walls, and all locations that have been queued or stacked (currently, or in the past)
	 * 
	 * @param myMap with your 'x' markers that show what has been visited so far 
	 * @param q = current queue or stack to process
	 */
	private static void displayMyMap(char[][] myMap, Collection<Integer> q) {
		for (int row=0; row<N; row++) {
			for (int col=0; col<N; col++) {
				System.out.print(myMap[row][col]);
			}
			if (row == N-1) System.out.println(" Still to visit: locations " + q);
			System.out.println();
		}
		System.out.println();
	}


}
