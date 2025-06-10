package main.java.NarasimhaKarumanchi.java.t014_Misc;

public class SumOfXLengthSubArrays {
	
	private long xLengthSubArraysSum(int[] arr) {
		int n = arr.length;
		
		int val = 0;
		long finalSum = 0;
				
		int root = (int) Math.sqrt(n);
		
		for(int i = 0; i < root; i++) {
			val += arr[i];
		}
		
		finalSum += val;
		
				
		int si = 1, ei = root;
				
		while(ei < n) {
			val = val + arr[ei] - arr[si-1];
									
			finalSum += val;
			
			si++;
			ei++;
		}
		
		return finalSum;
	}
	
	public static void main(String[] args) {
		
		SumOfXLengthSubArrays soxls = new SumOfXLengthSubArrays();
		int[] arr = new int[] {2,3,1,4,8};
		long sum = soxls.xLengthSubArraysSum(arr);
		
		System.out.println("Sum of x length subarrays : " + sum);
		
	}

}
