package main.java.NarasimhaKarumanchi.java._0_Arrays.Problems_And_Solutions;

import java.util.Arrays;

public class _1_n_MoveAllZeroesToEndKeepingOrderOfRestSame_EfficientApproach {

	/**
	 * We maintain count of non-zero elements encountered so far.
	 * And evidently, index of zero to be swapped will be count only, as it will be after non-zero element
	 * We don't do anything if we see a zero, but if we see a non-zero element, we swap it with zero element
	 * 
	 * T.C. is O(n) because there is 1 traversal and it takes up O(1) space.
	 *
	 */
	static void moveAllZeroesToEnd(int[] arr) {

		int n = arr.length;

		int count = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] != 0) {
				// swap current non-zero element with zero element
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				// increment count of non-zero elements seen so far
				count++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 5, 0, 90, 8, 0, 56, 0 };
		moveAllZeroesToEnd(arr);
		System.out.print("Modified Array with all zeroes at end: " + Arrays.toString(arr));

	}

}
