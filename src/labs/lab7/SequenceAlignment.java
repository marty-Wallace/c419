package labs.lab7;

public class SequenceAlignment {

    // static String s = "GATTACA";
    // static String t = "ATTACCA";

    static String s = "ATCGACTAATAATATAATTTATATATATACTGACTAGGCTAG";
    static String t = "GATCGACTAGCTAGCATATATATTTTAATTAATTATATGCTG";

    static int [][] traceback = new int[s.length()+1][t.length()+1];
    static int [][] solution = new int[s.length()+1][t.length()+1];

    public static void main(String[] args){
        int m = s.length();
        int n = t.length();

        System.out.println("Best value of sequence alignment is: " + sequence_alignment(m, n));

        StringBuilder a1 = new StringBuilder();
        StringBuilder a2 = new StringBuilder();

        while (m>0 || n>0) {

            if(m == 0) {
                a1.insert(0, '-');
                a2.insert(0, t.charAt(n - 1));
                n--;
            }else if(n == 0) {
                a1.insert(0, s.charAt(m - 1));
                a2.insert(0, '-');
                m--;
            }
            else if (traceback[m][n] == 4) {
                a1.insert(0, s.charAt(m - 1));
                a2.insert(0, t.charAt(n - 1));
                m--; n--;
            }
            else if (traceback[m][n] == 1) {
                a1.insert(0, '-');
                a2.insert(0, t.charAt(n -1));
                n--;
            }
            else if (traceback[m][n] == 2) {
                a1.insert(0, s.charAt(m - 1));
                a2.insert(0, '-');
                m--;
            }
            else if (traceback[m][n] == 3) {
                a1.insert(0, s.charAt(m - 1));
                a2.insert(0, t.charAt(n - 1));
                m--;
                n--;
            }
            else { System.out.println("Critical error"); }
        }
        System.out.println(a1);
        System.out.println(a2);

    }

    static int sequence_alignment(int m, int n) {
        if (m == 0 && n == 0){
            return 0;
        }
        if (m == 0){
            int a = sequence_alignment(m, n-1) - 1;
            traceback[m][n] = 1;
            solution[m][n] = a;
            return a;
        }
        if (n == 0){
            int b = sequence_alignment(m-1, n) - 1;
            traceback[m][n] = 2;
            solution[m][n] = b;
            return b;
        }
        if (solution[m][n] != 0) return solution[m][n];
        if (s.charAt(m-1) == t.charAt(n-1)) {
            traceback[m][n]=4;
            solution[m][n] = 1 + sequence_alignment(m-1, n-1);
            return solution[m][n];
        }
        int a = sequence_alignment(m, n-1) - 1;
        int b = sequence_alignment(m-1, n) - 1;
        int c = sequence_alignment(m-1, n-1) - 2;

        if (a >= b && a >= c) {
            traceback[m][n]=1;
            solution[m][n]=a;
            return a;
        }
        else if(b >= a && b >= c) {
            traceback[m][n]=2;
            solution[m][n]=b;
            return b;
        }
        else {
            traceback[m][n]=3;
            solution[m][n]=c;
            return c;
        }
    }
}
