package co.kulwadee.csc209.lect01;

public class VectorClient {
    public static void main(String[] args) {
        Vector x = new Vector(new double[]{0, 3, 4, 0});
        Vector y = new Vector(new double[]{0, -3, 1, -4});

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("x + y = " + x.plus(y));
        System.out.println("x - y = " + x.minus(y));
        System.out.println("3x = " + x.times(3));
        System.out.println("x . y = " + x.dot(y));
        System.out.println("| x | = " + x.magnitude());
        System.out.println("Direction of x = " + x.direction());

    }
}
