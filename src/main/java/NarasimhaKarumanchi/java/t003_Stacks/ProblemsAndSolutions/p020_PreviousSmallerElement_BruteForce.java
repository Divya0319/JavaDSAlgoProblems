package main.java.NarasimhaKarumanchi.java.t003_Stacks.ProblemsAndSolutions;

import java.util.Arrays;

public class p020_PreviousSmallerElement_BruteForce {
	
	public int[] nextSmaller(int[] inp) {
		
		int n = inp.length;
		
		int[] prevSmallers = new int[n];
		for(int k = 0; k < n; k++) {
			prevSmallers[k] = -1;
		}
		
		for(int i = 0; i < n; i++) {
						
			for(int j = i-1; j >= 0; j--) {
				if(inp[j] < inp[i]) {
					prevSmallers[i] = inp[j];
					break;
				} 
			}
		}
		
		return prevSmallers;
		
	}

	
	
	public static void main(String[] args) {
				
		p020_PreviousSmallerElement_BruteForce mainClass = new p020_PreviousSmallerElement_BruteForce();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		System.out.println("Input: " + Arrays.toString(inp));
		
		int[] prevSmallers = mainClass.nextSmaller(inp);
		
		System.out.println("Previous smaller: " + Arrays.toString(prevSmallers));
		
			
	}

}
