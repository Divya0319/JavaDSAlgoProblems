package main.java.NarasimhaKarumanchi.java._0_Arrays.Problems_And_Solutions;

import java.util.Arrays;

public class _1_f_ReverseArray {

	// T.C. is theta(n), bcz the loop traverses the array  exactly floor(n/2) times to reverse it.
	// S.C. is theta(1), as only few variables used here.
	
	/**
	 * We use two variables, left and right, for left most and right most index of array
	 * and we swap both indexes, and then move left and right close to each other on each iteration,
	 * left incremented, and right decremented, until left and right cross each other (left<right)
	 * 
	 * Then we simply return resulting array
	 */
	static int[] reverseArray(int[] arr) {

		int n = arr.length;

		int left = 0, right = n-1;
		while(left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			
			left++;
			right--;
		}
		

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 120, 20 };
		int[] reversedArray = reverseArray(arr);
		
		System.out.println("Reversed Array: " + Arrays.toString(reversedArray));
		
	}

}
