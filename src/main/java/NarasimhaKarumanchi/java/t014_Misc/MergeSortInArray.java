package main.java.NarasimhaKarumanchi.java.t014_Misc;

import java.util.Arrays;

public class MergeSortInArray {
	
	// this method is assuming that array from s to mid is already sorted
	// and array from mid+1 to e is already sorted.
	// Its job is to merge these two arrays and ultimately sort the given array.
	public void merge(int[] arr, int s, int mid, int e) {
		int[] b = new int[arr.length];
		int i = s;
		int j = mid+1;
		int k = s;  // this k pointer will be used to fill result array
		while(i <= mid && j <= e) {
			if(arr[i] < arr[j]) {
				b[k] = arr[i];
				i++;
			} else {
				b[k] = arr[j];
				j++;
			}
			k++;
		}
		
		if(i > mid) {
			while(j <= e) {
				b[k] = arr[j];
				j++;
				k++;
			}
		} else {
			while(i <= mid) {
				b[k] = arr[i];
				i++;
				k++;
			}
		}
		
		for(k = s; k <= e; k++) {
			arr[k] = b[k];
		}
						
	}
	
	public void printArray(int[] arr) {
		System.out.print("Sorted array: [");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public void mergeSort(int[] arr, int s, int e) {
		if(s < e) {
			int mid = (s + e) / 2;
			mergeSort(arr, s, mid);
			mergeSort(arr, mid+1, e);
			merge(arr, s, mid, e);
		}
		
	}
	public static void main(String[] args) {
		
		int[] inp = new int[] {23, 76, 21, 3, 5, 10, 1, 16, 53};
		int len = inp.length;
		
		System.out.println("Given array: " + Arrays.toString(inp));
		
		MergeSortInArray mainClass = new MergeSortInArray();
		mainClass.mergeSort(inp, 0, len-1);
		// Even though we are passing local created array to this print method
		// it is actually referencing to single array created in heap,
		// So, when you modify the array in your method via that reference,
		// you're modifying the single array object that exists on the heap.
		mainClass.printArray(inp);
	}

}
