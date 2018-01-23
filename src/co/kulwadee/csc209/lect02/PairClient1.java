package co.kulwadee.csc209.lect02;

public class PairClient1 {
    public static void main(String[] args) {
        int[] numbers = {10, 9, 2, -1, 5, 100, -88, 7, 30, 8};

        Pair<Integer, Integer> minmax = ArrayAlg1.minmax(numbers);
        System.out.println("min = " + minmax.getFirst());
        System.out.println("max = " + minmax.getSecond());
    }
}

class ArrayAlg1 {
    public static Pair<Integer, Integer> minmax(int[] a) {
        if (a == null || a.length == 0) return null;
        int min = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min < a[i]) min = a[i];
            if (max > a[i]) max = a[i];
        }
        return new Pair<>(min, max);
    }
}

