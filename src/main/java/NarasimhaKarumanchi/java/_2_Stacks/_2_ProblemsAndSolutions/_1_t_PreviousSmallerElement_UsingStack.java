package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;

import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_t_PreviousSmallerElement_UsingStack {
	
	public int[] nextSmaller(int[] inp) {
		
		int n = inp.length;
		
		int[] prevSmallers = new int[n];
		LinkedStack<Integer> stk = new LinkedStack<>();
		
		stk.push(-1);
		
		for(int i = 0; i < n; i++) {
			int curr = inp[i];
			while(stk.peek() >= curr) {
				stk.pop();
			}
			
			// if reached this line, that means
			// you have found previous smaller element
			
			// store the previous smaller
			prevSmallers[i] = stk.peek();
			// push current element
			// for checking for upcoming element
			stk.push(curr);
		}
		
		return prevSmallers;
		
	}

	
	
	public static void main(String[] args) {
				
		_1_t_PreviousSmallerElement_UsingStack mainClass = new _1_t_PreviousSmallerElement_UsingStack();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		System.out.println("Input: " + Arrays.toString(inp));
		
		int[] prevSmallers = mainClass.nextSmaller(inp);
		
		System.out.println("Previous smaller: " + Arrays.toString(prevSmallers));
		
			
	}

}
