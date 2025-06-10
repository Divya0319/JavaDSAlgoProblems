package main.java.NarasimhaKarumanchi.java.t001_Arrays.Problems_And_Solutions;

import java.util.Arrays;

public class _1_m_MoveAllZeroesToEndKeepingOrderOfRestSame_NaiveApproach {

	/**
	 * We traverse the array from left side, and we don't do anything when we found non-zero
	 * but we take some action as soon as we found a zero
	 * As soon as we find a zero, we again go to right of this zero, until we find first non-zero element
	 * When we find a non-zero element, we SWAP the current element with zero found previously
	 * 
	 * T.C. is O(n2) because there is nested loop present, running n times each on average
	 *
	 */
	static void moveAllZeroesToEnd(int[] arr) {

		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				for (int j = i + 1; j < n; j++) {
					if (arr[j] != 0) {
						arr[i] = arr[i] + arr[j];
						arr[j] = arr[i] - arr[j];
						arr[i] = arr[i] - arr[j];
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 5, 0, 0, 8, 0, 9, 0 };
		moveAllZeroesToEnd(arr);
		System.out.print("Modified Array with all zeroes at end: " + Arrays.toString(arr));

	}

}
