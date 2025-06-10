package main.java.NarasimhaKarumanchi.java.t004_Queues.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedStack;


public class p001_ReverseQueueUsingStack<T> {
	
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
		p001_ReverseQueueUsingStack<Integer> mainClass = new p001_ReverseQueueUsingStack<>();
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
		System.out.println("Given queue: " + lq.toString());
		
		try {
			System.out.println("Reversed queue: " + mainClass.reverseQueueUsingStack(lq).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
