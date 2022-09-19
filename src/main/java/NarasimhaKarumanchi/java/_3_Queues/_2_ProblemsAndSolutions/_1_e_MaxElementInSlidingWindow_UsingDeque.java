package main.java.NarasimhaKarumanchi.java._3_Queues._2_ProblemsAndSolutions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _1_e_MaxElementInSlidingWindow_UsingDeque {
	
	public int[] maxEleSlidingWindowOptimised(int[] inp, int k) {
		int n = inp.length;
		
		int ri = 0;
		int r[] = new int[n-k+1];
		
		Deque<Integer> qi = new ArrayDeque<>();
		
		/* Process first k(or first window)
		 * elements of array
		 */
		int i;
		for(i = 0; i < k; i++) {
			
			//For every element, the previous 
			//smaller elements are useless	so
			//remove them from qi
			while(!qi.isEmpty() && inp[i] >= inp[qi.peekLast()]) {
				
				// remove from rear
				qi.removeLast();
			}
			
			// Add new element at rear of queue
			qi.addLast(i);
		}
		
		r[ri++] = inp[qi.peek()];
		
		
		//Process rest of elements,
		//i.e. from inp[k] to inp[n-1]
		for(; i < n ; ++i) {
			//The element at the front of queue
			//is the largest element of previous window,
			//so print it
			
			//Remove the elements
			//which are out of this window
			while(!qi.isEmpty() && qi.peek() <= i-k) {
				qi.removeFirst();
			}
			
			//remove all elements smaller
			//than the currently being added element
			//(remove useless elements)
			while(!qi.isEmpty() && inp[i] >= inp[qi.peekLast()]) {
				qi.removeLast();
			}
			
			
			//add current element to rear of qi
			qi.addLast(i);
			
			// Print the maximum element of last window
			r[ri++] = inp[qi.peek()];
			
		}
		
		return r;
		
	}
	
	public static void main(String[] args) {
		_1_e_MaxElementInSlidingWindow_UsingDeque mainClass = new _1_e_MaxElementInSlidingWindow_UsingDeque();
		
		int[] inp = new int[] {1,3,-1,-3,5,3,6,7, 18, 4, 16, -2};
		System.out.println("Input: " + Arrays.toString(inp));
		int[] res = mainClass.maxEleSlidingWindowOptimised(inp, 3);
		System.out.println("Maximum elements for each window are as follows: ");
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	
	}
}
