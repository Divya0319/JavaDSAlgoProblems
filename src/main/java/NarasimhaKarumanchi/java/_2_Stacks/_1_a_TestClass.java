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
		
		for(int i = 0; i < ns.length; i++) {
			ns[i] = -1;
		}
		
		for(int i = 0; i < a.length; i++) {
			
			for(int j = i+1; j < a.length; j++) {
				if(a[j] <= a[i]) {
					ns[i] = j;
					break;
				}
			}
		}
		
		return ns;
	}
	
	int[] prevSmallerElement(int[] a) {
		int[] ps = new int[a.length];
		
		for(int i = 0; i < ps.length; i++) {
			ps[i] = -1;
		}
		
		for(int i = 0; i < a.length; i++) {
			
			for(int j = i-1; j >= 0; j--) {
				if(a[j] <= a[i]) {
					ps[i] = j;
					break;
				}
			}
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
