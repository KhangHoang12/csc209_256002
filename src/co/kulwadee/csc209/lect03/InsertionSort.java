package co.kulwadee.csc209.lect03;
import java.text.DecimalFormat;

public class InsertionSort {

    /**
     * Sorts the elements (in place) using selection sort.
     */
    public static void insertionSort(int[] array) {
        int i, j, key;
        for (j = 1; j < array.length; j++) {
            key = array[j];
            i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i+1] = array[i];
                i = i - 1;
            }
            array[i+1] = key;
        }
    }

    public static int randInteger(int min, int max) {
        return min + (int)(Math.random() * (max-min) + 1);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static long testInsertionSort(int[] array) {
        long startTime, endTime;
        startTime = System.nanoTime();
        /* debug
        if (array.length == 16) {
            System.out.print("nosort: ");
            printArray(array);
        }*/
        insertionSort(array);
        /* debug
        if (array.length == 16) {
            System.out.print("sorted: ");
            printArray(array);
        }
        */
        endTime   = System.nanoTime();
        return endTime - startTime;
    }
    public static double nanoToSeconds(long ns) {
        return ns * 10E-9;
    }

    public static String formatDecimal(double d) {
        DecimalFormat df = new DecimalFormat("#.#####");
        return df.format(d);
    }

    public static void main(String[] args) {
        int min = 1, max = 100;
        int[] numElements = {16, 32, 64, 128, 256, 512, 1024};

        for (int k = 0; k < numElements.length; k++) {
            int arraySize = numElements[k];
            // init. a random array of arraySize integers
            int[] A = new int[arraySize];
            for (int i = 0; i < A.length; i++) {
                A[i] = randInteger(min, max);
            }
            // run the selection sorting
            long duration = testInsertionSort(A);
            // print stat
            System.out.println(arraySize + ": " + formatDecimal(nanoToSeconds(duration)));
        }

    }
}
