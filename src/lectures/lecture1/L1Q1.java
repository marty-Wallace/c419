package lectures.lecture1;

import java.util.HashSet;

public class L1Q1 {

    public static void main(String[] args ) {

        long timer = System.currentTimeMillis();
        System.out.println(joinLength1(1, 70_000_000));
        System.out.println(System.currentTimeMillis() - timer + " (ms)");
        timer = System.currentTimeMillis();
        System.out.println(joinLength2(1, 70_000_000));
        System.out.println(System.currentTimeMillis() - timer + " (ms)");
        timer = System.currentTimeMillis();
        System.out.println(joinLength3(1, 70_000_000));
        System.out.println(System.currentTimeMillis() - timer + " (ms)");

    }

    static int joinLength1(int a, int b) {
        int count = 0;
        while (a <= b) {
            count += Integer.toString(a++).length();
        }
        return count;
    }

    static int joinLength2(int a, int b) {
        StringBuilder s = new StringBuilder();
        while(a <= b) {
            s.append(Integer.toString(a++));
        }
        return s.length();
    }

    static int joinLength3(int a, int b) {
        int count = 0;
        int aLength = Integer.toString(a).length();
        int nextPower = (int) Math.pow(10, aLength);
        int next = Math.min(nextPower, b);
        count += (next - a) * aLength;
        while((int) Math.pow(10, ++aLength) <= b) {
            count += ((int) Math.pow(10, aLength) - (int) Math.pow(10, aLength-1)) * aLength;
        }

        count += (b + 1 - (int) Math.pow(10, aLength-1)) * aLength;
        return count;
    }

}
