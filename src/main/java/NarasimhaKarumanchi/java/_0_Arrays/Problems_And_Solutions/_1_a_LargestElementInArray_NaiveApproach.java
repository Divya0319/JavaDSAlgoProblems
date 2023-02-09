package main.java.NarasimhaKarumanchi.java._0_Arrays.Problems_And_Solutions;

public class _1_a_LargestElementInArray_NaiveApproach {

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
