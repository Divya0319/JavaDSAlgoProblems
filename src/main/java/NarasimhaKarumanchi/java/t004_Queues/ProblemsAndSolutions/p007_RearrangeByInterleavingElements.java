package main.java.NarasimhaKarumanchi.java.t004_Queues.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedStack;

public class p007_RearrangeByInterleavingElements {

	public LinkedQueue<Integer> interleavingQueue(LinkedQueue<Integer> q) {

		if (q.size() % 2 != 0) {
			throw new IllegalArgumentException("Queue size mist be even");
		}

		LinkedStack<Integer> s = new LinkedStack<>();
		int halfSize = q.size() / 2;

		try {

		

		for (int i = 0; i < halfSize; i++) {

			s.push(q.deQueue());

		}

		while (!s.isEmpty()) {
			q.enQueue(s.pop());
		}

		for (int i = 0; i < halfSize; i++) {

			q.enQueue(q.deQueue());

		}

		for (int i = 0; i < halfSize; i++) {
			s.push(q.deQueue());
		}
		
		while(!s.isEmpty()) {
			q.enQueue(s.pop());
			q.enQueue(q.deQueue());
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return q;
	}

	public static void main(String[] args) {
		p007_RearrangeByInterleavingElements mainClass = new p007_RearrangeByInterleavingElements();
		
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
		
		queue = mainClass.interleavingQueue(queue);
		
		System.out.println("Interleaved queue: " + queue.toString());

	}
}
