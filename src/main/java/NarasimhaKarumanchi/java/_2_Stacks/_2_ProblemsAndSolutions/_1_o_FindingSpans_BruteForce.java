package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;

public class _1_o_FindingSpans_BruteForce {
	
	public int[] findSpans(int[] prices) {
		int[] spans = new int[prices.length];
		spans[0] = 1;
		
		for(int i = 0; i < prices.length; i++) {
			spans[i] = 1;
			for(int j = i - 1; (j >= 0) && (prices[j] <= prices[i]); j--) {
				spans[i]++;
			}
		}
		
		return spans;
	}

	
	
	public static void main(String[] args) {
				
		_1_o_FindingSpans_BruteForce mainClass = new _1_o_FindingSpans_BruteForce();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		int[] spans = mainClass.findSpans(inp);
		
		System.out.println(Arrays.toString(spans));
		
			
	}

}
