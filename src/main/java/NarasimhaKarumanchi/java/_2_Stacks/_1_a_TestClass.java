package main.java.NarasimhaKarumanchi.java._2_Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class _1_a_TestClass<T>  {
	
	int largest, second_l;
	
	public int largestRectangleInHistogram(int[] heights) {
		
		int n = heights.length;
		
		int maxArea = 0;
		
		int[] ns = new int[n];
		int[] ps = new int[n];
		
		ns = nextSmallerElement(heights);
		ps = prevSmallerElement(heights);
		
		for(int i = 0; i < n; i++) {
			
			// if there is no next smaller, then -1 would cause problem in area calculation
			// hence we increase next smaller to n
			if(ns[i] == -1) {
				ns[i] = n;
			}
			
			int currArea = (ns[i] - ps[i] - 1) * heights[i];
			
			maxArea = Math.max(maxArea, currArea);
			
			System.out.println("Area considering " + heights[i] + " is " + currArea);
			
		}
		
		return maxArea;
	}
	
	int[] nextSmallerElement(int[] a) {
		int[] ns = new int[a.length];
		
		LinkedStack<Integer> stk = new LinkedStack<>();
		
		// we start from n-1 because, for last element,
		// next smaller will be -1, as nothing is there on right of last
		// so, we begin next smaller calculation from last element for stack approach
		for(int i = a.length - 1; i >= 0; i--) {
			
			// until stack has some contents, and element referred by top of stack is greater than current element of array
			// keep popping from stack, until we find a smaller element index in stack
			while(!stk.isEmpty() && a[stk.peek()] >= a[i]) {
				stk.pop();
			}
			
			
			// if stack is empty, there is no next smaller for current element
			// otherwise, if stack is non-empty, top of stack index is next smaller
			if(stk.isEmpty()) {
				ns[i] = -1;
			} else {
				ns[i] = stk.peek();
			}
			
			// every time, we push the index of element, not the element
			stk.push(i);
		}
		
		return ns;
	}
	
	int[] prevSmallerElement(int[] a) {
		int[] ps = new int[a.length];
		
		LinkedStack<Integer> stk = new LinkedStack<>();
		
		// for first element, prev smaller will be -1 itself
		// hence we begin prev smaller calculation from start of array
		for(int i = 0; i < a.length; i++) {
			// until stack has some contents, and element referred by top of stack is greater than current element of array
			// keep popping from stack, until we find a smaller element index in stack
			while(!stk.isEmpty() && a[stk.peek()] >= a[i]) {
				stk.pop();
			}
			
			// if stack is empty, there is no prev smaller for current element
			// otherwise, if stack is non-empty, top of stack index is prev smaller
			if(stk.isEmpty()) {
				ps[i] = -1;
			} else {
				ps[i] = stk.peek();
			}
			
			// every time, we push the index of element, not the element
			stk.push(i);
		}
		
		return ps;
		
	}
	
	
	
	public static void main(String[] args) {
		_1_a_TestClass<String> mainClass = new _1_a_TestClass<>();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		System.out.println("Input: " + Arrays.toString(inp));
		
		int maxArea = mainClass.largestRectangleInHistogram(inp);
		
		System.out.println("Max Area: " + maxArea);
	}
}
