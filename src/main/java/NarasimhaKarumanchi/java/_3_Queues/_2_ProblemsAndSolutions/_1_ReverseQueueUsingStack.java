package main.java.NarasimhaKarumanchi.java._3_Queues._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedStack;


public class _1_ReverseQueueUsingStack<T> {
	
	public LinkedQueue<T> reverseQueueUsingStack(LinkedQueue<T> queue) throws Exception {
		LinkedStack<T> stk = new LinkedStack<>();
		while(!queue.isEmpty()) {
			stk.push(queue.deQueue());
		}
		
		while(!stk.isEmpty()) {
			queue.enQueue(stk.pop());
		}
		
		return queue;
	}
	
	public static void main(String[] args) {
		_1_ReverseQueueUsingStack<Integer> mainClass = new _1_ReverseQueueUsingStack<>();
		LinkedQueue<Integer> lq = new LinkedQueue<>();
		lq.enQueue(5);
		System.out.println(lq.toString());
		lq.enQueue(6);
		System.out.println(lq.toString());
		lq.enQueue(7);
		System.out.println(lq.toString());
		lq.enQueue(8);
		System.out.println(lq.toString());
		lq.enQueue(9);
		System.out.println(lq.toString());
		lq.enQueue(10);
		System.out.println(lq.toString());
		
		try {
			System.out.println(mainClass.reverseQueueUsingStack(lq).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
