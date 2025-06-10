package main.java.NarasimhaKarumanchi.java.t001_Arrays.Problems_And_Solutions;

public class p002_LargestElementInArray_EfficientApproach {
	
	// T.C. will always be theta(n) time, not best case or worst case, it will always traverse theta(n) time
	public static int findLargest(int[] arr) {

		int n = arr.length;
		int largest = 0;

		for (int i = 1; i < n; i++) {
			if(arr[i] > arr[largest]) {
				largest = i;
			}
		}

		return largest;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 30, 100, 40, 50 };
		System.out.println("Largest: " + arr[findLargest(arr)]);
	}
}
