package main.java.NarasimhaKarumanchi.java.t003_Stacks.ProblemsAndSolutions;

import java.util.Arrays;

import main.java.NarasimhaKarumanchi.java.t003_Stacks.LinkedStack;

public class p019_NextSmallerElement_UsingStack {
	
	public int[] nextSmaller(int[] inp) {
		
		int n = inp.length;
		
		int[] nextSmallers = new int[n];
		LinkedStack<Integer> stk = new LinkedStack<>();
		
		// Initially pushing -1 to stack
		// bcz for last element,next smaller will be -1 only
		stk.push(-1);
		
		// looping from right to left of input array
		for(int i = n-1; i >= 0; i--) {
			int curr = inp[i];
			// until top of stack is greater than current element
			// pop from stack
			while(stk.peek() >= curr) {
				stk.pop();
			}
			
			// if reached this line, that means
			// you have found next smaller element
			
			// store the next smaller
			nextSmallers[i] = stk.peek();
			// push current element
			// for checking for upcoming element
			stk.push(curr);
		}
		
		return nextSmallers;
		
	}

	
	
	public static void main(String[] args) {
				
		p019_NextSmallerElement_UsingStack mainClass = new p019_NextSmallerElement_UsingStack();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		System.out.println("Input: " + Arrays.toString(inp));
		
		int[] nextSmallers = mainClass.nextSmaller(inp);
		
		System.out.println("Next smaller: " + Arrays.toString(nextSmallers));
		
			
	}

}
