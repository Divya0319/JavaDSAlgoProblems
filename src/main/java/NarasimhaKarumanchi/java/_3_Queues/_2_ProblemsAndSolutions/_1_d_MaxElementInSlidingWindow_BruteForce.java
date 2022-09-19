package main.java.NarasimhaKarumanchi.java._3_Queues._2_ProblemsAndSolutions;

import java.util.ArrayList;
import java.util.Arrays;

public class _1_d_MaxElementInSlidingWindow_BruteForce {
	
	public void maxEleSlidingWindow(int[] inp, int k) {
		int j, max;
		int n = inp.length;
		// looping from i from 0 to number of windows possible (n-k)
		for(int i = 0; i <= n-k; i++) {
			// created an ArrayList to print considered window elements at each step
			ArrayList<Integer> tempArr = new ArrayList<>();
			// setting max to first element of input array initially
			max = inp[i];
			// also adding this first element to ArrayList
			tempArr.add(inp[i]);
			for(j = 1; j < k; j++) {
				// looping from 2nd element to kth element of current window
				// and adding that element to ArrayList as well
				tempArr.add(inp[i+j]);
				// since i holds the beginning index of the current window, we have to do i+j to progress in window
				if(inp[i+j] > max) {
					// updating max value here
					max = inp[i+j];
				}
			}
			// Printing maximum of current window
			System.out.println("Maximum of " + tempArr.toString() + " is " + max);
		}
	}
	
	public static void main(String[] args) {
		_1_d_MaxElementInSlidingWindow_BruteForce mainClass = new _1_d_MaxElementInSlidingWindow_BruteForce();
		
		int[] inp = new int[] {1,3,-1,-3,5,3,6,7, 18, 4, 16, -2};
		System.out.println("Input: " + Arrays.toString(inp));
		mainClass.maxEleSlidingWindow(inp, 3);
	
	}
}
