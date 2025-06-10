package main.java.NarasimhaKarumanchi.java.t003_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;

import main.java.NarasimhaKarumanchi.java.t003_Stacks.LinkedStack;

public class _1_v_LargestRectangleInHistogram_UsingStack {
	
	public int largestRectangleInHistogram(int[] heights) {
		
		int n = heights.length;
		
		// maximum area is stored in this variable
		int maxArea = 0;
		int[] nextSmallers = new int[n];
		
		// this array will hold indices of
		// next smallers of given input 
		nextSmallers = nextSmallerElement(heights, n);
		
		// this array will hold indices of
		// previous smallers of given input 
		int[] prevSmallers = new int[n];
		prevSmallers = prevSmallerElement(heights, n);
		
		for(int i = 0; i < n; i++) {
			int l = heights[i];
			
			// when next smaller becomes -1
			// then breadth might come negative
			// and will result in negative area
			// so we reset that next smaller to last index
			if(nextSmallers[i] == -1) {
				nextSmallers[i] = n;
			}
			int b = nextSmallers[i] - prevSmallers[i] - 1;
			maxArea = Math.max(maxArea, l * b);
			
			System.out.println("Area considering " + heights[i] + " is (" + nextSmallers[i] + "-(" + prevSmallers[i] + ")-1) * " + heights[i]
					+ " = " + (l * b));
		}
		
		return maxArea;
		
	}

	int[] nextSmallerElement(int[] heights, int n) {
		int[] nextSmallers = new int[n];
		LinkedStack<Integer> stk = new LinkedStack<>();
		
		// putting -1 initially in stack
		// as next smaller will be -1
		// for last element
		stk.push(-1);
		
		for(int i = n-1; i >= 0; i--) {
			int curr = heights[i];
			
			// don't pop from stack if top of stack is -1
			while(stk.peek() != -1 && heights[stk.peek()] >= curr) {
				stk.pop();
			}
			
			nextSmallers[i] = stk.peek();
			// pushing index value instead of element
			stk.push(i);
		}
		
		return nextSmallers;
	}
	
	int[] prevSmallerElement(int[] heights, int n) {
		int[] prevSmallers = new int[n];
		LinkedStack<Integer> stk = new LinkedStack<>();
		
		// putting -1 initially in stack
		// as previous smaller will be -1
		// for first element
		stk.push(-1);
		
		for(int i = 0; i < n; i++) {
			int curr = heights[i];
			while(stk.peek() != -1 && heights[stk.peek()] >= curr) {
				stk.pop();
			}
			
			prevSmallers[i] = stk.peek();
			
			// pushing index value instead of element
			stk.push(i);
		}
		
		return prevSmallers;
	}
	
	
	public static void main(String[] args) {
				
		_1_v_LargestRectangleInHistogram_UsingStack mainClass = new _1_v_LargestRectangleInHistogram_UsingStack();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		System.out.println("Input: " + Arrays.toString(inp));
		
		int largestArea = mainClass.largestRectangleInHistogram(inp);
		
		System.out.println("Max Area: " + largestArea);
		
			
	}

}
