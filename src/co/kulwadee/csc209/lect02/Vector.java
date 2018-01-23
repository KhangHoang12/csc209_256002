package co.kulwadee.csc209.lect01;

public class Vector {
    // instance variables
    private int N;
    private double[] coords;

    /**
     * Creates a vector with the given Cartesian coordinates
     * @param a an array of doubles containing coordinate values.
     */
    public Vector(double[] a) {
        // copy coordinate values in a to coords
        N = a.length;
        coords = new double[N];
        for (int i = 0; i < N; i++)
            coords[i] = a[i];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < N-1; i++)
            sb.append(coords[i] + ", ");
        sb.append(coords[N-1] + ")");
        return sb.toString();
    }

    /**
     * Returns the sum of this vector and b.
     * @param b another vector.
     *
     * @return the vector this + b
     */
    public Vector plus(Vector b) {
        double[] c = new double[N];
        for (int i = 0; i < N; i++)
            c[i] = coords[i] + b.coords[i];
        return new Vector(c);
    }

    /**
     * Returns the difference of this vector and b.
     * @param b another vector.
     *
     * @return the vector this - b
     */
    public Vector minus(Vector b) {
        /* INSERT YOUR CODE HERE */

        return null;
        /* INSERT YOUR CODE HERE */
    }

    /**
     * Returns the scalar product of this vector and b.
     * @param t a scalar value.
     *
     * @return the vector t*thisVector
     */
    public Vector times(double t) {
        double[] c = new double[N];
        for (int i = 0; i < N; i++)
            c[i] = t * coords[i];
        return new Vector(c);
    }

    /**
     * Returns the dot product of this vector and b.
     * https://en.wikipedia.org/wiki/Dot_product
     *
     * @param b another vector.
     *
     * @return the vector this dot b
     */
    public double dot(Vector b) {
        double dotProd = 0.0;
        /* INSERT YOUR CODE HERE */

        /* INSERT YOUR CODE HERE */
        return dotProd;
    }

    /**
     * Returns the magnitude of this vector
     *
     * @return the magnitude
     */
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    /**
     * Returns the unit vector with the same direction as this vector.
     */
    public Vector direction() {
        return this.times(1.0 / this.magnitude());
    }
}
