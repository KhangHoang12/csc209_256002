import java.util.Scanner;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        int N;
        public Node(Key key, Value val, int N) {
            this.key = key; this.val = val; this.N = N;
        }
    }

    public BST() { }

    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else           return x.N;
    }
    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (x == null) return  null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public Key min() {
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }
    public Key max() {
        return max(root).key;
    }
    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }
    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void deleteMax() {
        root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key) {
        root = delete(root, key);
    }
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> breadthFirstOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();

        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

    public Iterable<Key> depthFirstOrder() {
        Queue<Key> keys = new Queue<Key>();
        Stack<Node> stack = new Stack<Node>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node x = stack.pop();
            if (x == null) continue;
            keys.enqueue(x.key);
            stack.push(x.right);
            stack.push(x.left);
        }
        return keys;
    }

    public static void main(String args[]) {
        BST<String, Integer> st = new BST<>();
        Scanner scn = new Scanner(System.in);

        String keyToDel = null; // save a key for testing our delete method below
        for (int i = 0; scn.hasNext(); i++) {
            String key = scn.next();
            if (i % 3 == 0) keyToDel = key;
            st.put(key, i);
        } 

        System.out.println("breadth first traversal..");

        for (String s : st.breadthFirstOrder())
            System.out.println(s + " " + st.get(s));

        System.out.println("depth first traversal..");

        for (String s : st.depthFirstOrder())
            System.out.println(s + " " + st.get(s));

        String minkey = st.min();
        String maxkey = st.max();
        System.out.println("Min. key = " + minkey);
        System.out.println("Max. key = " + maxkey);

        st.deleteMin();
        System.out.println("After deleting '" + minkey + "' = " + st.min());
        st.deleteMax();
        System.out.println("After deleting '" + maxkey + "' = " + st.max());

        if (keyToDel != null) {
            st.delete(keyToDel);
            System.out.println("After deleting '" + keyToDel + "'...");
            for (String s : st.breadthFirstOrder())
                System.out.println(s + " " + st.get(s));
        }
    }
}
