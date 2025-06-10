package main.java.NarasimhaKarumanchi.java.t014_Misc;

import java.util.HashMap;

public class MaxFreqElementInArray {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 1, 1, 2, 3, 4, 4, 5, 4, 5};
		MaxFreqElementInArray mfea = new MaxFreqElementInArray();
		System.out.println(mfea.maxFreqElement(arr));

	}
	
	public int maxFreqElement(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int n = arr.length;
		
		int maxFreq = 1;
		int mostFreqElement = -1;
		
		for(int i = 0; i < n; i++) {
			if(hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
				
				if(maxFreq < hm.get(arr[i])) {
					maxFreq = hm.get(arr[i]);
					mostFreqElement = arr[i];
				} else if(maxFreq == hm.get(arr[i])) {
					mostFreqElement = Math.max(mostFreqElement, arr[i]);
				}
			} else {
				hm.put(arr[i], 1);
			}
		}
		
		return mostFreqElement;
	}

}
