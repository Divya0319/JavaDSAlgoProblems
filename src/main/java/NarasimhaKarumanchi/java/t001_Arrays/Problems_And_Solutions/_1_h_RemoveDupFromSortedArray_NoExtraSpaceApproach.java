package main.java.NarasimhaKarumanchi.java.t001_Arrays.Problems_And_Solutions;


public class _1_h_RemoveDupFromSortedArray_NoExtraSpaceApproach {

	/**
	 * Here, we take use of sorted nature of array, and we compare next element with last updated index
	 * If current element is same as last updated index, we ignore it,
	 * or else, we increment index and insert this new element
	 * T.C. is O(n) and S.C. is O(1), as this solution takes no extra space
	 *
	 */
	static int removeDuplicate(int[] arr) {

		int n = arr.length;
		int res = 1;
		for(int i = 1; i < n; i++) {
			if(arr[i] != arr[res-1]) {
				arr[res] = arr[i];
				res++;
			}
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
