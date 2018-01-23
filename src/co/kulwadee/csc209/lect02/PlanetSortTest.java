package co.kulwadee.csc209.lect02;

import java.util.Arrays;

public class PlanetSortTest {
    public static void main(String[] args) {
        Planet[] planets = new Planet[9];

        planets[0] = new Planet("Mercury", 2440, 57.9);
        planets[1] = new Planet("Venus", 6052, 108.2);
        planets[2] = new Planet("Earth", 6371, 149.6);
        planets[3] = new Planet("Mars", 3390, 227.9);
        planets[4] = new Planet("Jupiter", 69911, 778.3);
        planets[5] = new Planet("Saturn", 58232, 1427.0);
        planets[6] = new Planet("Uranus", 25362, 2871.0);
        planets[7] = new Planet("Neptune", 24622, 4497.1);
        planets[8] = new Planet("Pluto", 1188, 5913);

        Arrays.sort(planets);      // class Planet must implement the Comparable interface

        for (Planet p : planets)
            System.out.println(p);

    }
}
