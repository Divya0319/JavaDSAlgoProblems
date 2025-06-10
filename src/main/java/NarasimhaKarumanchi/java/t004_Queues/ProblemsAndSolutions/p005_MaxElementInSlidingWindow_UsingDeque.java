package main.java.NarasimhaKarumanchi.java.t004_Queues.ProblemsAndSolutions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class p005_MaxElementInSlidingWindow_UsingDeque {
	
	public int[] maxEleSlidingWindowOptimised(int[] inp, int k) {
		int n = inp.length;
		
		int ri = 0;
		
		// Final result will have n-k+1 elements
		int res[] = new int[n-k+1];
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		/* Process first k(or first window)
		 * elements of array
		 */
		int i;
		for(i = 0; i < k; i++) {
			
			//For every element, the previous 
			//smaller elements are useless	so
			//remove them from qi
			while(!dq.isEmpty() && dq.peekLast() < inp[i]) {
				
				// remove from rear
				dq.removeLast();
			}
			
			// Add new element at rear of queue
			dq.addLast(inp[i]);
		}
		
		res[ri++] = dq.peekFirst();
		
		
		//Process rest of elements,
		//i.e. from inp[k] to inp[n-1]
		for(i = k; i < n ; ++i) {
			//The element at the front of queue
			//is the largest element of previous window,
			//so print it
			
			//Remove the elements
			//which are out of this window
			if(dq.peek() == inp[i-k]) {
				dq.removeFirst();
			}
			
			//remove all elements smaller
			//than the currently being added element
			//(remove useless elements)
			while(!dq.isEmpty() && dq.peekLast() < inp[i]) {
				dq.removeLast();
			}
			
			
			//add current element to rear of qi
			dq.addLast(inp[i]);
			
			// Print the maximum element of last window
			res[ri++] = dq.peek();
			
		}
		
		return res;
		
	}
	
	public static void main(String[] args) {
		p005_MaxElementInSlidingWindow_UsingDeque mainClass = new p005_MaxElementInSlidingWindow_UsingDeque();
		
		int[] inp = new int[] {1,3,-1,-3,5,3,6,7, 18, 4, 16, -2};
		System.out.println("Input: " + Arrays.toString(inp));
		int[] res = mainClass.maxEleSlidingWindowOptimised(inp, 3);
		System.out.println("Maximum elements for each window are as follows: ");
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	
	}
}
