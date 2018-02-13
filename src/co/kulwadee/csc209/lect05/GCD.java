/**
 * https://introcs.cs.princeton.edu/java/23recursion/Euclid.java.html
 */
package co.kulwadee.csc209.lect05;

public class GCD {
    // recursive implementation
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int d = gcd(p, q);
        int d2 = gcd2(p, q);
        System.out.println("gcd_recursive(" + p + ", " + q + ") = " + d);
        System.out.println("gcd_nonrecursive(" + p + ", " + q + ") = " + d2);
    }
}
