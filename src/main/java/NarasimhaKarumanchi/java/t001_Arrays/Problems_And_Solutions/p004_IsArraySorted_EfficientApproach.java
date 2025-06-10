package main.java.NarasimhaKarumanchi.java.t001_Arrays.Problems_And_Solutions;


// Check array is sorted in non-decreasing order or not
public class p004_IsArraySorted_EfficientApproach {
	
	// All we need to check is if arr[i] is greater than equal to arr[i-1] or not, if not,
	// then we return false immediately
	
	// Best case: {10,5,20,40}, in this one, it will find in first comparison only that array not sorted,
	// and will return false, so it will take constant time here
	// Worst case: {7,20,30,10}, here, last element is out of order, and only loop runs n time for it, so 
	// worst case T.C. is O(n2)
	public static boolean isSorted(int[] arr) {
		
		int n = arr.length;
		
		int inc = 0;
		int dec = 0;
		for(int i = 0; i < n-1; i++) {
			if(arr[i] < arr[i+1]) {
				inc++;
			} else if(arr[i] > arr[i+1]) {
				dec++;
			}
		}
		if(inc == 0 ||dec == 0) {
			return true;
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		int[] inp = new int[] {8, 8, 8, 8};
		System.out.println("Is array sorted? :" + isSorted(inp));
	}

}
