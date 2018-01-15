package co.kulwadee.csc209.lect01;

public class ComplexClient {
    public static void main(String[] args) {
        Complex a = new Complex(3.0, 4.0);
        Complex b = new Complex(-2.0, 3.0);
        Complex c = a.times(b);
        Complex d = a.plus(b);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}
