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
		
		for(int i = a.length - 1; i >= 0; i--) {
			while(!stk.isEmpty() && a[stk.peek()] >= a[i]) {
				stk.pop();
			}
			
			if(stk.isEmpty()) {
				ns[i] = -1;
			} else {
				ns[i] = stk.peek();
			}
			
			stk.push(i);
		}
		
		return ns;
	}
	
	int[] prevSmallerElement(int[] a) {
		int[] ps = new int[a.length];
		
		LinkedStack<Integer> stk = new LinkedStack<>();
		
		for(int i = 0; i < a.length; i++) {
			while(!stk.isEmpty() && a[stk.peek()] >= a[i]) {
				stk.pop();
			}
			
			if(stk.isEmpty()) {
				ps[i] = -1;
			} else {
				ps[i] = stk.peek();
			}
			
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
