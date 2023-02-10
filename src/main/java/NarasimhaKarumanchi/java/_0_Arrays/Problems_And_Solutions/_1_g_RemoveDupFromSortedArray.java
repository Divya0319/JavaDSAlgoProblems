package main.java.NarasimhaKarumanchi.java._0_Arrays.Problems_And_Solutions;


public class _1_g_RemoveDupFromSortedArray {

	/**
	 * We create a temp array of size equal to input array, and create a variable 'res' holding size of temp array
	 * Then we copy first element from input to temp array, bcz in any case, 1st element of input array will come
	 * as part of output
	 * After that, we start checking from 2nd element of input, if it is equal to last element inserted in temp array
	 * If it is not equal, we add this element to temp array and increment res value.
	 * After input array traversed, we copy all elements from temp array to input array, and return res value
	 * 
	 *
	 */
	static int removeDuplicate(int[] arr) {

		int n = arr.length;
		int[] temp = new int[n];
		temp[0] = arr[0];
		int res = 1;
		for(int i = 1; i < n; i++) {
			if(temp[res-1] != arr[i]) {
				temp[res] = arr[i];
				res++;
			}
		}
		
		for(int i = 0; i < res; i++) {
			arr[i] = temp[i];
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 10, 20, 20, 50, 100, 100 };
		int noDupSize = removeDuplicate(arr);
		System.out.print("No Dup Array: [");
		for(int i = 0; i < noDupSize; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("]");

		
	}

}
