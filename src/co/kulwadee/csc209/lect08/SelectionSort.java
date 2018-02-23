package co.kulwadee.csc209.lect08;

import java.util.Arrays;

public class SelectionSort implements Sorter {

	public void sort(int[] A, int N) {
		for (int i = 0; i < N; i++) {
			int smallest = i;
			for (int j = i + 1; j < N; j++)
				if (A[smallest] > A[j]) smallest = j;
			int tmp = A[i]; A[i] = A[smallest]; A[smallest] = tmp;
		}
	}

	public static void main(String[] args) {
		final String SEP = " ";
		
		int[] A = Utils.randInts(99, 15);
		int[] B = Utils.copyA(A);
		Arrays.sort(B);
		Utils.printA(A, SEP);
		
		Sorter sorter = new SelectionSort();
		sorter.sort(A, A.length);
		
		if (! Arrays.equals(A, B)) 
			System.out.println("Incorrect sorting");
		Utils.printA(A, SEP);
	}

}
