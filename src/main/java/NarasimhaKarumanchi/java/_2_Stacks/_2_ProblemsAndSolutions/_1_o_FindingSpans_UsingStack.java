package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;

import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_o_FindingSpans_UsingStack {
	
	public int[] findSpans(int[] prices) {
		int[] spans = new int[prices.length];
		LinkedStack<Integer> stk = new LinkedStack<>();
		
		stk.push(0);
		
		for(int i = 0; i < prices.length; i++) {
			while(!stk.isEmpty() && prices[stk.peek()] <= prices[i]) {
				stk.pop();
			}
			
			if(stk.isEmpty()) {
				spans[i] = i + 1;
			} else {
				spans[i] = i - stk.peek();
			}
			
			stk.push(i);
		}
		
		return spans;
	}

	
	
	public static void main(String[] args) {
				
		_1_o_FindingSpans_UsingStack mainClass = new _1_o_FindingSpans_UsingStack();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		int[] spans = mainClass.findSpans(inp);
		
		System.out.println(Arrays.toString(spans));
		
			
	}

}
