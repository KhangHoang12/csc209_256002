package co.kulwadee.csc209.lect02;

public class PairClient2 {
    public static void main(String[] args) {
        String[] words = {"java", "c", "c++", "scala", "python",
                          "nodejs", "perl", "sql", "objectiveC"};

        Pair<String, String> minmax = ArrayAlg2.minmax(words);
        System.out.println("min = " + minmax.getFirst());
        System.out.println("max = " + minmax.getSecond());
    }
}

class ArrayAlg2 {
    public static Pair<String, String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) < 0) min = a[i];
            if (max.compareTo(a[i]) > 0) max = a[i];
        }
        return new Pair<>(min, max);


    }
}

