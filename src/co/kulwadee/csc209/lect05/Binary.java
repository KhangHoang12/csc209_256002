package co.kulwadee.csc209.lect05;

public class Binary {
    public static String convert(int N) {
        if (N == 0) return "0";
        if (N == 1) return "1";
        return convert(N/2) + (N % 2);
    }
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        if (N <= 0) {
            System.out.println("N must be positive.");
        } else {
            System.out.println(convert(N));
        }

    }
}


