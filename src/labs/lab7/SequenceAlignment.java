package labs.lab7;

public class SequenceAlignment {

    public static final int MATCH = 4;
    public static final int NO_MATCH = 3;
    public static final int SKIP_RIGHT = 2;
    public static final int SKIP_LEFT = 1;

    public static final int MATCH_VALUE = 1;
    public static final int NO_MATCH_PENALTY = -2;
    public static final int SKIP_LEFT_PENALTY = -1;
    public static final int SKIP_RIGHT_PENALTY = -1;


    // static String left = "GATTACA";
    // static String right = "ATTACCA";

    static String left = "ATCGACTAATAATATAATTTATATATATACTGACTAGGCTAG";
    static String right = "GATCGACTAGCTAGCATATATATTTTAATTAATTATATGCTG";

    static int [][] traceback = new int[left.length()+1][right.length()+1];
    static int [][] solution = new int[left.length()+1][right.length()+1];

    public static void main(String[] args){
        int ell = left.length();
        int arr = right.length();

        System.out.println("Best value of sequence alignment is: " + sequence_alignment(ell, arr));

        StringBuilder a1 = new StringBuilder();
        StringBuilder a2 = new StringBuilder();

        while (ell > 0 || arr > 0) {
            if (traceback[ell][arr] == MATCH) {
                a1.insert(0, left.charAt(ell--));
                a2.insert(0, right.charAt(arr--));
            }
            else if (ell == 0 || traceback[ell][arr] == SKIP_LEFT) {
                a1.insert(0, '-');
                a2.insert(0, right.charAt(arr--));
            }
            else if (arr == 0 || traceback[ell][arr] == SKIP_RIGHT) {
                a2.insert(0, '-');
                a1.insert(0, left.charAt(ell--));
            }
            else if (traceback[ell][arr] == NO_MATCH) {
                a1.insert(0, left.charAt(ell--));
                a2.insert(0, right.charAt(arr--));
            }
            else {
                System.out.println("Critical error");
                throw new RuntimeException("Unknown Number in traceback table");
            }
        }
        System.out.println(a1);
        System.out.println(a2);

    }

    static int sequence_alignment(int ell, int arr) {
        if (ell == 0 && arr == 0){
            return 0;
        }
        if (solution[ell][arr] != 0) {
            return solution[ell][arr];
        }
        if(ell == 0) {
            int leftSkipValue = sequence_alignment(ell, arr-1) - SKIP_LEFT_PENALTY;
            traceback[ell][arr] = SKIP_LEFT;
            solution[ell][arr] = leftSkipValue;
            return leftSkipValue;
        }
        if(arr == 0) {
            int rightSkipValue = sequence_alignment(ell-1, arr) - SKIP_RIGHT_PENALTY;
            traceback[ell][arr] = SKIP_RIGHT;
            solution[ell][arr] = rightSkipValue;
            return rightSkipValue;
        }

        if (left.charAt(ell-1) == right.charAt(arr-1)) {
            traceback[ell][arr] = MATCH;
            solution[ell][arr] = sequence_alignment(ell-1, arr-1) + MATCH_VALUE;
            return solution[ell][arr];
        }

        int leftSkipValue = sequence_alignment(ell, arr-1) - SKIP_LEFT_PENALTY;
        int rightSkipValue = sequence_alignment(ell-1, arr) - SKIP_RIGHT_PENALTY;
        int noMatchValue = sequence_alignment(ell-1, arr-1) - NO_MATCH_PENALTY;

        if (leftSkipValue >= rightSkipValue && leftSkipValue >= noMatchValue) {
            traceback[ell][arr] = SKIP_LEFT;
            solution[ell][arr] = leftSkipValue;
            return leftSkipValue;
        }
        else if(rightSkipValue >= leftSkipValue && rightSkipValue >= noMatchValue) {
            traceback[ell][arr] = SKIP_RIGHT;
            solution[ell][arr] = rightSkipValue;
            return rightSkipValue;
        }
        else {
            traceback[ell][arr] = NO_MATCH;
            solution[ell][arr] = noMatchValue;
            return noMatchValue;
        }
    }
}
