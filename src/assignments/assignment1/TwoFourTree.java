package assignment1;

public class TwoFourTree {

    static class Node {
        int size;
        int[] keys = new int[3];
        Node[] children = new Node[4];
    }

    public static boolean find(Node r, int k) {
        // Make sure node is valid
        if (r == null ||  r.size == 0)
            return false;
        for(int i = 0; i < r.size; i++)
            if(k == r.keys[i])
                return true;
            else if(k < r.keys[i])
                return find(r.children[i], k);
        // If we made it here then k > all keys call on rightmost child
        return find(r.children[r.size], k);
    }
}
