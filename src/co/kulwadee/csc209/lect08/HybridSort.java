package co.kulwadee.csc209.lect08;

import java.util.Arrays;

public class HybridSort implements Sorter {
	public final int threshold = 50;
	private int partition(int[] A, int p, int r) {
		// use randomized quicksort
		int ridx = Utils.randInt(p, r-1);
		int x = A[r]; A[r] = A[ridx]; A[ridx] = x;
		
		int q = p;
		for (int u = p; u < r; u++) {
			if (A[u] <= A[r]) {
				int tmp = A[u]; A[u] = A[q]; A[q] = tmp;
				q = q + 1;
			}
		}
		int tmp = A[r]; A[r] = A[q]; A[q] = tmp;
		return q;
	}
	private void hybridsort(int[] A, int p, int r) {
		if (p >= r) return;
		if (r-p+1 <= 50) {
			// use INSERTION-SORT for small size subarray
			for (int i = p+1; i <= r; i++) {
				int key = A[i];
				int j = i - 1;
				while (j >= p && A[j] > key) {
					A[j+1] = A[j];
					j = j - 1;
				}
				A[j+1] = key;
			}
		} else {
			int q = partition(A, p, r);
			hybridsort(A, p, q-1);
			hybridsort(A, q+1, r);
		}
	}
	public void sort(int[] A, int N) {
		hybridsort(A, 0, N-1);
	}
	
	public static void main(String[] args) {
		final String SEP = " ";
		
		int[] A = Utils.randInts(99, 15);
		int[] B = Utils.copyA(A);
		Arrays.sort(B);
		Utils.printA(A, SEP);
		
		Sorter sorter = new HybridSort();
		sorter.sort(A, A.length);
		
		if (! Arrays.equals(A, B)) 
			System.out.println("Incorrect sorting");
		Utils.printA(A, SEP);



	}


}
