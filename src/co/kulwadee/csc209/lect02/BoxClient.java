package co.kulwadee.csc209.lect02;

public class BoxClient {
    public static void main(String[] args) {
        Box intBox = new Box();
        intBox.set(18);

        int myBelonging = (int) intBox.get();
        System.out.println("object in the box: " + myBelonging);

        Planet myPlanetInTheBox = (Planet)intBox.get(); // RUNTIME-ERROR: ClassCastException:
                                                        // java.lang.Integer
                                                        // cannot be cast to Planet

        double distance = myPlanetInTheBox.getDistanceFromSun();

    }
}

