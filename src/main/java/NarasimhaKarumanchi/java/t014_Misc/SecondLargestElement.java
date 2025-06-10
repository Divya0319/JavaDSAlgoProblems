package main.java.NarasimhaKarumanchi.java.t014_Misc;

public class SecondLargestElement {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2 ,15, 6, 8, 20, 19};
		SecondLargestElement sle = new SecondLargestElement();
		System.out.println(sle.secLargest(arr));

	}
	
	public int secLargest(int[] arr) {
		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				secMax = max;
				max = arr[i];
			} else if(arr[i] > secMax && arr[i] < max) {
				secMax = arr[i];
			}
		}
		
		return secMax;
	}
	
	

}
