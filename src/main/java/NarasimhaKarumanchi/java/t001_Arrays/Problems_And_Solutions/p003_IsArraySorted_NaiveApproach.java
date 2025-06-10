package main.java.NarasimhaKarumanchi.java.t001_Arrays.Problems_And_Solutions;


// Check array is sorted in non-decreasing order or not
public class p003_IsArraySorted_NaiveApproach {
	
	// Best case: {10,5,20,40}, in this one, it will find in first comparison only that array not sorted,
	// and will return false, so it will take constant time here
	// Worst case: {7,20,30,10}, here, last element is out of order, so comparison will happen for every element
	// starting from 1st, and will happen n times, hence, worst case T.C. is O(n2).
	public static boolean isSorted(int[] arr) {
		
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				if(arr[j] < arr[i]) {  // if next element is smaller than current element
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		int[] inp = new int[] {7, 20, 30, 10};
		System.out.println("Is array sorted? :" + isSorted(inp));
	}

}
