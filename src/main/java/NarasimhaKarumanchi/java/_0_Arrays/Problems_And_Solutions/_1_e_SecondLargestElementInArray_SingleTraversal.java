package main.java.NarasimhaKarumanchi.java._0_Arrays.Problems_And_Solutions;

public class _1_e_SecondLargestElementInArray_SingleTraversal {

	// T.C. is theta(n) and does 1 traversal of array
	/**
	 *	Consider a stream of arrays coming 10,20,30,40.. and largest and 2nd largest already found
	 *	then, new element comes in, 'x', which arises these three cases,
	 * 	1. when x is greater than largest element already found
	 * 		sec_largest = largest;  // simply make x as largest, and old largest as second largest now
	 * 		largest = x;
	 * 	2. when x is equal to largest, nothing changes, simply ignore this case
	 * 	3. when x is less than largest,
	 * 		3.1 when never seen 2nd largest before - 12,12,12,12.. x=7, then simply sec_largest = x;
	 * 		3.2 when x is less than 2nd largest itself, then we simply ignore this case.
	 * 		3.3 when x is less than largest and greater than 2nd largest,  sec_largest = x; 
	 */
	static int findIndexOfSecondLargest(int[] arr) {

		int n = arr.length;

		int res = -1, largest = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[largest]) { 
				res = largest;
				largest = i;
			} else if(arr[i] != arr[largest]) {
				if(res == -1 || arr[i] > arr[res]) {
					res = i;
				}
			}
		}

		return res;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 10, 20 };
		int secondLargestIndex = findIndexOfSecondLargest(arr);
		if (secondLargestIndex == -1)
			System.out.println("No Second largest element");
		else {
			System.out.println("Second largest element: " + arr[findIndexOfSecondLargest(arr)]);
		}
	}

}
