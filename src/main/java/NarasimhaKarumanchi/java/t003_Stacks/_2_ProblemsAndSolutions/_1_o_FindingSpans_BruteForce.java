package main.java.NarasimhaKarumanchi.java.t003_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;

public class _1_o_FindingSpans_BruteForce {
	
	public int[] findSpans(int[] prices) {
		int[] spans = new int[prices.length];
		spans[0] = 1;
		
		for(int i = 1; i < prices.length; i++) {
			
			// Initially, every index will be maximum in itself, 
			// before beginning of comparison
			spans[i] = 1;
			
			// here, we take every index,
			// and we check every element from beginning for that index
			// hence, we get O(n) time complexity
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
