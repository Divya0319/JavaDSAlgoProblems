package main.java.NarasimhaKarumanchi.java.t001_Arrays.Problems_And_Solutions;

public class p005_SecondLargestElementInArray_TwoTraversal {

	// first thing we do here is find index of largest element
	// then next, we find largest among the remaining elements
	// to find second largest
	static int findIndexOfSecondLargest(int[] arr) {

		int n = arr.length;

		int largest = getLargest(arr);

		int res = -1; // initializing -1 because there might be case when there is no 2nd largest
		for (int i = 0; i < n; i++) {
			if (arr[i] != arr[largest]) { // going inside loop only for those elements which are not equal to largest
				if (res == -1) { // we are setting res first time here, found first second largest candidate
					res = i;
					// else, this case reaches when res is already set previously, and we found
					// another
					// candidate for second largest(curr element is greater than previous largest)
				} else if (arr[i] > arr[res]) {
					res = i;
				}
			}
		}

		return res;

	}

	static int getLargest(int[] arr) {
		int n = arr.length;
		int largest = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[largest]) { // if current element is greater than current largest
				largest = i;  // update largest
			}
		}

		return largest;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 10, 10 };
		int secondLargestIndex = findIndexOfSecondLargest(arr);
		if (secondLargestIndex == -1)
			System.out.println("No Second largest element");
		else {
			System.out.println("Second largest element: " + arr[findIndexOfSecondLargest(arr)]);
		}
	}

}
