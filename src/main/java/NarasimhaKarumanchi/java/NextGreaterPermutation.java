package main.java.NarasimhaKarumanchi.java;

import java.util.Arrays;

public class NextGreaterPermutation {
	
	public void nextGreaterPermutation(int[] arr) {
		int n = arr.length;
		
		int i = n-1;
		
		for(; i >= 0; i--) {
			if(arr[i-1] < arr[i]) {
				break;
				
			}
		}
		
		i--;
		
		for(int j = n-1; j > i; j--) {
			if(arr[j] > arr[i]) {
				// swap arr[i] with arr[j]
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				
				break;
			}
		}
		
		reversePartOfSubArray(arr, i+1, n-1);
		
	}
	
	public void reversePartOfSubArray(int[] arr, int s, int e) {
		while(s < e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			
			s++;
			e--;
		}
	}
	
	public static void main(String[] args) {
		NextGreaterPermutation ngp = new NextGreaterPermutation();
		int[] arr = new int[] {1, 2, 3, 7, 6, 5};
		ngp.nextGreaterPermutation(arr);
		System.out.println("Next greater permutation: " + Arrays.toString(arr));
	}

}
