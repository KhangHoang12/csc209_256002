package co.kulwadee.csc209.lect02;

public class GBoxClient {
    public static void main(String[] args) {
        GBox<Integer> intBox = new GBox<Integer>();
        intBox.set(18);

        int myBelonging = intBox.get();
        System.out.println("object in the box: " + myBelonging);

        //Planet myPlanetInTheBox = intBox.get(); // COMPILE-TIME ERROR: Incompatible Type:

        //double distance = myPlanetInTheBox.getDistanceFromSun();

    }
}
