package main.java.NarasimhaKarumanchi.java.t003_Stacks.ProblemsAndSolutions;

import java.util.Arrays;

import main.java.NarasimhaKarumanchi.java.t003_Stacks.LinkedStack;

public class p017_FindingSpans_UsingStack {
	
	public int[] findSpans(int[] prices) {
		int n = prices.length;
		
		// Stack will hold indices of elements of array
		LinkedStack<Integer> stk = new LinkedStack<>();
		
		int[] spans = new int[n];
		// Initially, stack will have 0th index, 
		// because 1st element is already processed from array
		stk.push(0);
		// first element of spans array will be 1
		// because for first element in array,
		// it will be maximum only from its past
		spans[0] = 1;
		
		// we will begin counting from 2nd element of array
		for(int i = 1; i < n; i++) {
			
			// unless stack is not empty
			// and current index element is greater or equal to stack top
			// we pop from stack
			while(!stk.isEmpty() && prices[i] >= prices[stk.peek()]) {
				stk.pop();
			}
			
			// if stack becomes empty, we set that index's span as i+1
			// or else, we set it as (i - stack's top)
			spans[i] = stk.isEmpty() ? i + 1 : i - stk.peek();
			
			// at last, we push current index to stack
			// to be available for next index element
			stk.push(i);
		}
		
		return spans;
	}

	
	
	public static void main(String[] args) {
				
		p017_FindingSpans_UsingStack mainClass = new p017_FindingSpans_UsingStack();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		int[] spans = mainClass.findSpans(inp);
		
		System.out.println(Arrays.toString(spans));
		
			
	}

}
