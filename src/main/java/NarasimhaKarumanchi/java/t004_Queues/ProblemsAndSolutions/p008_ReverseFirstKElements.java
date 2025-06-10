package main.java.NarasimhaKarumanchi.java.t004_Queues.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedStack;

public class p008_ReverseFirstKElements {

	public LinkedQueue<Integer> reverseFirstKElements(LinkedQueue<Integer> q, int k) {
		
		try {
			
			if(k  > q.size()) {
				throw new IllegalArgumentException("K must be less than queue size");
			}
			
			else if( k > 0) {
				LinkedStack<Integer> s = new LinkedStack<>();
				
				for(int i = 0; i < k; i++) {
					s.push(q.deQueue());
				}
				
				while(!s.isEmpty()) {
					q.enQueue(s.pop());
				}
				
				for(int i = 0; i < q.size() - k; i++) {
					q.enQueue(q.deQueue());
				}
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return q;
	}

	public static void main(String[] args) {
		p008_ReverseFirstKElements mainClass = new p008_ReverseFirstKElements();
		
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(9);
		queue.enQueue(10);
		queue.enQueue(11);
		queue.enQueue(12);
		
		System.out.println("Input queue: " + queue.toString());
		
		int k = 7;
		
		queue = mainClass.reverseFirstKElements(queue, k);
		
		System.out.println("Queue after reversing first  " + k + "elements : " + queue.toString());

	}
}
