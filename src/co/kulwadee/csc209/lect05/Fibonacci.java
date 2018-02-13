package co.kulwadee.csc209.lect05;

public class Fibonacci {
    // recursive implementation
    // this version is horribly inefficient
    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // non-recursive implementation
    // using 'dynamic programming' approach,
    // this is a much better way (than recursion) 
    // to implement fibonacci function
    public static long fibonacci_dyn(int n) {
        if (n == 0) return 0;
        // use an array F to remember previously computed fibonacci numbers.
        long[] F = new long[n+1];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i-1] + F[i-2];
        }
        return F[n];
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("fibonacci_dyn(" + n + ") = " + fibonacci_dyn(n));
        System.out.println("fibonacci(" + n + ") = " + fibonacci(n));
    }

}
