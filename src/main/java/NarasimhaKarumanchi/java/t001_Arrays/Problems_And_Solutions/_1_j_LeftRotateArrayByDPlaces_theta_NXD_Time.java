package main.java.NarasimhaKarumanchi.java.t001_Arrays.Problems_And_Solutions;

import java.util.Arrays;

public class _1_j_LeftRotateArrayByDPlaces_theta_NXD_Time {

	/**
	 * Calling left rotate by one, d times, will effectively left rotate by d times
	 *
	 */
	static void leftRotateByDPlaces(int[] arr, int d) {

		for(int i = 0; i < d; i++) {
			leftRotateByOne(arr);
		}
		
	}
	
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
		int d = 3;
		leftRotateByDPlaces(arr, d);
		System.out.print("Left rotated Array by " + d + " places: " + Arrays.toString(arr));
		
	}

}
