/**
 * A quick implementation of Max-heap
 */

package co.kulwadee.csc209.lect11;

public class BinaryHeap {
    public int[] A;
    public int heapSize;
    /** 
     * Create a max-heap from a given input array.
     * @param arr the input array. the first element is at index 1!
     */
    public BinaryHeap(int[] arr) {
        this.A = buildMaxHeap(arr);
        this.heapSize = this.A.length-1;
    }
    public int left(int i)   { return 2*i; }
    public int right(int i)  { return 2*i + 1; }
    public int parent(int i) { return i/2; }
                            
    /**
     * Correct a single violation at index i of max-heap A
     *
     * @param A a max heap with a single violaiton at A
     * @param i position of the violation
     */
    public void maxHeapify(int[] A, int heapSize, int i) {

        int l = left(i);
        int r = right(i);

        int largest = i;
        if (l <= heapSize && A[l] > A[largest]) {
            largest = l;
        }
        if (r <= heapSize && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;

            maxHeapify(A, heapSize, largest);
        }
    }

    public int[] buildMaxHeap(int[] A) {
        int[] aHeap = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            aHeap[i] = A[i];
        }

        int heapSize = A.length-1;

        for (int i = A.length / 2; i != 0; i--) {
            maxHeapify(aHeap, heapSize, i);
        }
        return aHeap;
    }

    public static void main(String[] args) {
        //int[] A = {0, 5, 3, 17, 10, 84, 19, 6, 22, 9};
        int[] A = {0, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        BinaryHeap aHeap = new BinaryHeap(A);

        for (int i = 0; i <= aHeap.heapSize; i++) 
            System.out.print(aHeap.A[i] + " ");
        System.out.println();
    }
}   

