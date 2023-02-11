package main.java.NarasimhaKarumanchi.java._0_Arrays.Problems_And_Solutions;

import java.util.Arrays;

public class _1_k_LeftRotateArrayByDPlaces_theta_N_Time_theta_N_space {

	/**
	 * Previously, we were storing only 1st element of array in temp, now we store 1st d elements in a temp array.
	 * We first move elements from d+1 to last position, one position left
	 * Then, we move first d elements to (n-d+i) position.
	 * 
	 * T.C. is theta(n) as theta(d) + theta(n-d) + theta(d) = theta(n+d) = theta(n)
	 * S.C. is theta(d) as a temp array of size d
	 *
	 */
	static void leftRotateByDPlaces(int[] arr, int d) {
		
		int n = arr.length;

		int[] temp = new int[d];
		for(int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}
		
		for(int i = d; i < n; i++) {
			arr[i-d] = arr[i];
		}
		
		for(int i = 0; i < d; i++) {
			arr[n-d+i] = temp[i];
		}
		
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int d = 3;
		leftRotateByDPlaces(arr, d);
		System.out.print("Left rotated Array by " + d + " places: " + Arrays.toString(arr));
		
	}

}
