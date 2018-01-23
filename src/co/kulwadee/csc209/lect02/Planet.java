package co.kulwadee.csc209.lect02;

public class Planet implements Comparable {
    private String name;
    private double radius;  // in kilometre
    private double distanceFromSun; // in Million kilometre

    public Planet(String name, double radius, double distanceFromSun) {
        this.name = name;
        this.radius = radius;
        this.distanceFromSun = distanceFromSun;
    }
    public String getName() {
        return name;
    }
    public double getRadiusInKm() {
        return radius;
    }
    public double getDistanceFromSun() {
        return distanceFromSun;
    }
    public String toString() {
        return String.format("%s, Radius(km)=%.2f, Distance from the Sun(Mil.km)=%.2f",
                name, radius, distanceFromSun);
    }

    /**
     * Compares planets by size (radius in kilometres).
     * @param otherObject another Planet object
     * @return a negative value if this planet is smaller,
     * zero if the two planets have equal radii,
     * a positive value otherwise.
     */
    public int compareTo(Object otherObject) {
        Planet other = (Planet) otherObject;
        return Double.compare(radius, other.radius);
    }
}


