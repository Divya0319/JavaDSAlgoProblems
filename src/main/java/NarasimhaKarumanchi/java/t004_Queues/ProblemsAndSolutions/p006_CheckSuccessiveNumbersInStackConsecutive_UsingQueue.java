package main.java.NarasimhaKarumanchi.java.t004_Queues.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedStack;

public class p006_CheckSuccessiveNumbersInStackConsecutive_UsingQueue {

	public boolean checkSuccesssiveNosInStackConsecutive(LinkedStack<Integer> s) {
		LinkedQueue<Integer> queue = new LinkedQueue<>();

		// initializing pairwiseOrdered true initially
		// and as soon as any pair comes out to be
		// non-consecutive, we change it to false
		boolean pairwiseOrdered = true;

		// putting all elements of stack into queue
		while (!s.isEmpty()) {
			queue.enQueue(s.pop());
		}

		// putting all elements of queue back to stack
		// (it reverses the stack)
		while (!queue.isEmpty()) {
			try {
				s.push(queue.deQueue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		while (!s.isEmpty()) {

			int n1 = s.pop();
			queue.enQueue(n1);

			if (!s.isEmpty()) {
				int n2 = s.pop();
				queue.enQueue(n2);

				if (Math.abs(n2 - n1) != 1) {
					pairwiseOrdered = false;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			try {
				s.push(queue.deQueue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return pairwiseOrdered;
	}

	public static void main(String[] args) {
		p006_CheckSuccessiveNumbersInStackConsecutive_UsingQueue mainClass = new p006_CheckSuccessiveNumbersInStackConsecutive_UsingQueue();
		
		LinkedStack<Integer> stack = new LinkedStack<>();
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);
		stack.push(14);
		stack.push(15);
		stack.push(44);
		System.out.println("Input stack: " + stack.toString());
		
		boolean isPairwiseConsecutive = mainClass.checkSuccesssiveNosInStackConsecutive(stack);
		
		System.out.println("Is stack pairwise consecutive? : " + isPairwiseConsecutive);

	}
}
