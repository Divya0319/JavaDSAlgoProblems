package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;

public class _1_p_LargestRectangleInHistogram_BruteForce {
	
	public int largestRectangleInHistogram(int[] heights) {
		
		int n = heights.length;
		
		// maximum area is stored in this variable
		int maxArea = 0;
		
		for(int i = 0; i < n; i++) {
			// initially setting left and right smaller as current index only
			int left = i, right = i;
			
			// unless height of any left histogram
			// becomes less than current histogram,
			// we decrement left value
			// (means, left is actually moving left)
			while(heights[left] >= heights[i]) {
				left--;
				
				// when left goes out of bounds of array
				// we break current iteration
				// of while loop
				if(left < 0) break;
			}
			
			// unless height of any right histogram
			// becomes less than current histogram,
			// we increment right value
			// (means, right is actually moving right)
			while(heights[right] >= heights[i]) {
				right++;
				
				// when right goes out of bounds of array
				// we break current iteration
				// of while loop
				if(right > n-1) break;
			}
			
			// updating max area by comparing
			// previously calculated max area
			// with current area
			maxArea = Math.max(maxArea, (right - left - 1) * heights[i]);
			
			System.out.println("Area considering " + heights[i] + " is (" + right + "-(" + left + ")-1) *" + heights[i]
					+ " = " + ((right - left - 1) * heights[i]));
						
		}
		
		return maxArea;
		
	}

	
	
	public static void main(String[] args) {
				
		_1_p_LargestRectangleInHistogram_BruteForce mainClass = new _1_p_LargestRectangleInHistogram_BruteForce();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		System.out.println("Input: " + Arrays.toString(inp));
		
		int largestArea = mainClass.largestRectangleInHistogram(inp);
		
		System.out.println("Max Area: " + largestArea);
		
			
	}

}
