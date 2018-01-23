package co.kulwadee.csc209.lect02;

import java.util.ArrayList;

public class PairClient3 {
    public static void main(String[] args) {
        ArrayList<Pair<String, Double>> shoppingCart = new ArrayList<>();

        shoppingCart.add(new Pair<>("bread", 30.50));
        shoppingCart.add(new Pair<>("jam", 100.25));
        shoppingCart.add(new Pair<>("butter", 60.50));
        shoppingCart.add(new Pair<>("milk", 25.75));
        shoppingCart.add(new Pair<>("yogurt", 26.75));

        for (Pair<String, Double> shoppngItem : shoppingCart)
            System.out.println(shoppngItem.getFirst() + ": " + shoppngItem.getSecond() + " Baht");
    }
}

