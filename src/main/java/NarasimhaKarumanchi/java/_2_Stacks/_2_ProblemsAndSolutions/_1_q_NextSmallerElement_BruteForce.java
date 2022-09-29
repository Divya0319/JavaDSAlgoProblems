package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;

public class _1_q_NextSmallerElement_BruteForce {
	
	public int[] nextSmaller(int[] inp) {
		
		int n = inp.length;
		
		int[] nextSmallers = new int[n];
		for(int k = 0; k < n; k++) {
			nextSmallers[k] = -1;
		}
		
		for(int i = 0; i < n; i++) {
						
			for(int j = i+1; j < n; j++) {
				if(inp[j] < inp[i]) {
					nextSmallers[i] = inp[j];
					break;
				} 
			}
		}
		
		return nextSmallers;
		
	}

	
	
	public static void main(String[] args) {
				
		_1_q_NextSmallerElement_BruteForce mainClass = new _1_q_NextSmallerElement_BruteForce();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		System.out.println("Input: " + Arrays.toString(inp));
		
		int[] nextSmaller = mainClass.nextSmaller(inp);
		
		System.out.println("Next smaller: " + Arrays.toString(nextSmaller));
		
			
	}

}
