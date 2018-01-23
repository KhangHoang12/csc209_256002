package co.kulwadee.csc209.lect02;

import java.util.List;
import java.util.ArrayList;

public class ListClient<T> {
    private List<T> list;

    public ListClient() {
        list = new ArrayList<T>();
    }
    private List<T> getList() {
        return list;
    }
    public static void main(String[] args) {
        ListClient<Planet> lce = new ListClient<Planet>();
        List<Planet> list = lce.getList();

        System.out.println("# Concrete class: " + list.getClass());
        System.out.println();

        list.add(0, new Planet("Mercury", 2440, 57.9));
        list.add(1, new Planet("Venus", 6052, 108.2));
        list.add(2, new Planet("Earth", 6371, 149.6));
        list.add(3, new Planet("Mars", 3390, 227.9));
        list.add(4, new Planet("Jupiter", 69911, 778.3));
        list.add(5, new Planet("Saturn", 58232, 1427.0));
        list.add(6, new Planet("Uranus", 25362, 2871.0));
        list.add(7, new Planet("Neptune", 24622, 4497.1));
        list.add(8, new Planet("Pluto", 1188, 5913));

        System.out.println("Access List via positional index: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i));
        }
        System.out.println();

        list.remove(2);  // remove the Earth

        System.out.println("Access List via iterator: ");
        int idx = 0;
        for (Planet p : list) {
            System.out.println(String.format("%d: %s", idx++, p.toString()));
        }

    }
}
