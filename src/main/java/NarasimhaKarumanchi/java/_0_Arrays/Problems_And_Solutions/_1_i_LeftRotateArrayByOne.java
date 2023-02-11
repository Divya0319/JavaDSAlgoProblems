package main.java.NarasimhaKarumanchi.java._0_Arrays.Problems_And_Solutions;

import java.util.Arrays;

public class _1_i_LeftRotateArrayByOne {

	/**
	 * First we store 1st element of array to temp variable
	 * Then, we copy arr[i] to arr[i-1], from 2nd element to last element
	 * In the end, we copy temp variable value to last element, arr[n-1] = temp
	 *
	 */
	static void leftRotateByOne(int[] arr) {

		int n = arr.length;
		int temp = arr[0];
		for(int i = 1; i < n; i++) {
			arr[i-1] = arr[i];
		}
		
		arr[n-1] = temp;
		
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		leftRotateByOne(arr);
		System.out.print("Left rotated Array: " + Arrays.toString(arr));
		
	}

}
