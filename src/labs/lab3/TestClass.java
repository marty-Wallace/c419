package labs.lab3;

public class TestClass {

	public static void main(String[] args) {

		/*
        //Once your queue-based method is ready, try running these.

        Solver.solveWithQueue("res/labs/lab3/maze1.txt");
        Solver.solveWithStack("res/labs/lab3/maze1.txt");
        Solver.solveWithQueue("res/labs/lab3/maze2.txt");
        Solver.solveWithStack("res/labs/lab3/maze2.txt");
        Solver.solveWithQueue("res/labs/lab3/maze3.txt");
        Solver.solveWithStack("res/labs/lab3/maze3.txt");

        Expected output of above:

        Solution found after 33 iterations.
        The largest size of the queue was 3

        Solution found after 33 iterations.
        The largest size of the stack was 3

        Solution found after 76 iterations.
        The largest size of the queue was 10

        Solution found after 22 iterations.
        The largest size of the stack was 14

        Queue ran out of items after 66 iterations. No solution to maze.
        The largest size of the queue was 2

        Stack ran out of items after 66 iterations. No solution to maze.
        The largest size of the stack was 2

        Your code will be tested on all 10 mazes, both queue and stack methods.
        The following for-loop will run both methods for all 10 files.

        */
        for (int i=1; i <= 10; i++) {
            Solver.solveWithQueue("res/labs/lab3/maze"+i+".txt");
            Solver.solveWithStack("res/labs/lab3/maze"+i+".txt");
            System.out.println();
        }

		
	}

}
