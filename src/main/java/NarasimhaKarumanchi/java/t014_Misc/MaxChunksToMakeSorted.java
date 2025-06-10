package main.java.NarasimhaKarumanchi.java.t014_Misc;

public class MaxChunksToMakeSorted {
	
	public int maxChunksToMakeSorted(int[] arr) {
		int n = arr.length;
		int ans = 0;
		int maxVal = arr[0];
		
		for(int i = 0; i < n; i++) {
			if(arr[i] > maxVal) {
				maxVal = arr[i];
			}
			
			if(i == maxVal) {
				ans++;
			}
		}
		
		return ans;	
	}
	
	public static void main(String[] args) {
		MaxChunksToMakeSorted mctms = new MaxChunksToMakeSorted();
		int[] arr = new int[] {2, 3, 0, 1, 6, 5, 4, 7, 8};
		int ans = mctms.maxChunksToMakeSorted(arr);
		
		System.out.println("Max no. of chunks: " + ans);
	}

}
