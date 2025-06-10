package main.java.NarasimhaKarumanchi.java.t001_Arrays.Problems_And_Solutions;

import java.util.Arrays;

public class _1_l_LeftRotateArrayByDPlaces_theta_N_Time_theta_1_Space {

	/**
	 * We first reverse starting d elements, then we reverse remaining elements after d position
	 * Then we reverse the whole resultant array
	 * 
	 * T.C. is theta(n) as theta(d)+theta(n-d)+theta(n) = theta(2n) = theta(n)
	 * S.C. is theta(1) as no extra space needed.
	 *
	 */
	static void leftRotateByDPlaces(int[] arr, int d) {
		
		int n = arr.length;

		reverse(arr, 0, d-1);
		reverse(arr, d, n-1);
		reverse(arr, 0, n-1);
		
	}
	
	static void reverse(int[] arr, int l, int r) {
		while(l < r) {
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int d = 3;
		leftRotateByDPlaces(arr, d);
		System.out.print("Left rotated Array by " + d + " places: " + Arrays.toString(arr));
		
	}

}
