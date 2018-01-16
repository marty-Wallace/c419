package lectures.lecture2;

public class L2Q1 {

    public static void main(String[] args) {
        int a = 6, b = 7;
        System.out.println(countPaths(a, b));
    }

    static int countPaths(int a, int b) {
        if(a == 0 || b == 0) {
            return 1;
        }
        return countPaths(a-1, b) + countPaths(a, b-1);
    }
}
