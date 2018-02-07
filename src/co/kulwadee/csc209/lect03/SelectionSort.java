package co.kulwadee.csc209.lect03;

public class SelectionSort {
    /**
     * Swaps the elements at index i and j.
     */
    public static void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Finds the index of the lowest value
     * starting from the index at start (inclusive)
     * and going to the end of the array.
     */
    public static int indexLowest(int[] array, int start) {
        int lowIndex = start;
        for (int i = start; i < array.length; i++) {
            if (array[i] < array[lowIndex]) {
                lowIndex = i;
            }
        }
        return lowIndex;
    }

    /**
     * Sorts the elements (in place) using selection sort.
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {  
            int j = indexLowest(array, i);        // n + n-1 + n-2 + .. + 1 = n(n+1)/2
            swapElements(array, i, j);            // n 
        }
    }

    public static int randInteger(int min, int max) {
        return min + (int)(Math.random() * (max-min) + 1);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int min = 1, max = 100;
        int[] A = new int[10];
        for (int i = 0; i < A.length; i++) {
            A[i] = randInteger(min, max);
        }
        System.out.print("       A: ");
        printArray(A);

        selectionSort(A);

        System.out.print("sorted A: ");
        printArray(A);
    }
}
