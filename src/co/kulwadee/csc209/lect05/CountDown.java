/*
 * example from: https://books.trinket.io/thinkjava2/chapter8.html
 */
package co.kulwadee.csc209.lect05;

public class CountDown {
    public static void countdown(int n) {
        if (n == 0) {
            System.out.println("Blastoff!");
        } else {
            System.out.println(n);
            countdown(n - 1);
        }
    }

    public static void main(String[] args) {
        countdown(5);
    }
}
