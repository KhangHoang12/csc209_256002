package co.kulwadee.csc209.lect01;

/*
 * A class for representing an Electric co.kulwadee.csc209.lect01.Charge
 * https://en.wikipedia.org/wiki/Electric_charge
 *
 * We are only interested in its position in 2-D plane and value (Q in coulomb)
 */
public class Charge {
    // instance variables
    private final double rx, ry;
    private final double q;

    // constructor
    public Charge(double x0, double y0, double q0) {
        rx = x0; ry = y0; q = q0;
    }

    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx*dx + dy*dy);
    }

    public String toString() {
        return q + " at " + "(" + rx + ", " + ry + ")";
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        // instantiate a co.kulwadee.csc209.lect01.Charge object c1 of q = 21.3
        // place it at position (0.51, 0.63)
        Charge c1 = new Charge(0.51, 0.63, 21.3);

        // instantiate a co.kulwadee.csc209.lect01.Charge object c2 of q = 81.9
        // place it at position (0.13, 0.94)
        Charge c2 = new Charge(0.13, 0.94, 81.9);

        double v1 = c1.potentialAt(x, y);
        double v2 = c2.potentialAt(x, y);
        System.out.printf("c1's potential at (%.2f, %.2f) is %.2e\n", x, y, v1);
        System.out.printf("c2's potential at (%.2f, %.2f) is %.2e\n", x, y, v2);
        System.out.printf("Total potential at (%.2f, %.2f) is %.2e\n", x, y, (v1 + v2));
    }


}
