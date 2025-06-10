package main.java.NarasimhaKarumanchi.java.t001_Arrays.Problems_And_Solutions;

public class _1_a_LargestElementInArray_NaiveApproach {
	
	// Best case: it will traverse theta(n) time, if first element is itself largest,
	// then, we have to traverse whole array only once, and can declare that 1st element is largest
	// Worst case: when last element is largest, we have to traverse whole array n times, because we begin
	// comparison from 1st element, and go till last element, so theta(n2) time.
	// So, on average, it will take O(n2) time.

	public static int findLargest(int[] arr) {

		int n = arr.length;

		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if (arr[j] > arr[i]) {
					flag = false;
					break;
				}
			}

			if (flag == true) {
				return i;
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 30, 100, 40, 50 };
		System.out.println("Largest: " + arr[findLargest(arr)]);
	}

}
