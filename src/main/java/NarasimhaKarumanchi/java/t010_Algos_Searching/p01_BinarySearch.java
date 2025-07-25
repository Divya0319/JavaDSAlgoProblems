package main.java.NarasimhaKarumanchi.java.t010_Algos_Searching;

public class p01_BinarySearch {
	
	public int binarySearch(int[] items, int target) {
		
		int l = 0;
		
		int r = items.length - 1;
		
		while(l <= r) {
			int mid = l + (r-l)/2;
			
			if(items[mid] == target) {
				return mid;
			} 
			
			if(items[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		p01_BinarySearch mainClass = new p01_BinarySearch();
		
		int[] items = new int[] {8, 14, 19, 32, 45, 51, 76, 79, 98};
		
		int result = mainClass.binarySearch(items, 76);
		
		if(result != -1) {
			System.out.println("Item found at index " + result);
		} else {
			System.out.println("Item not found");
		}
		
	}

}
