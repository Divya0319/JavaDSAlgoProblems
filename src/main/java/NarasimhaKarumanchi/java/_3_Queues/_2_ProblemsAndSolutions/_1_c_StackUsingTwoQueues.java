package main.java.NarasimhaKarumanchi.java._3_Queues._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java._3_Queues.ListNode;
import main.java.NarasimhaKarumanchi.java._3_Queues.StackService;

public class _1_c_StackUsingTwoQueues<T> implements StackService<T> {
	
	private LinkedQueue<T> q1 = new LinkedQueue<T>();
	private LinkedQueue<T> q2= new LinkedQueue<T>();

	
	/* 
	 * for pushing, we push into whichever queue is NOT empty
	 * and time complexity for it is O(1)
	 */
	
	@Override
	public void push(T data) {
		if(q1.isEmpty()) {
			q2.enQueue(data);
		} else {
			q1.enQueue(data);
		}
		
	}
	
	/*
	 * for popping, we pop from whichever queue is NOT empty
	 * if q2 is empty, we transfer n-1 elements from q2 to q1, 
	 * and pop last element from q2
	 *  else we transfer n-1 elements from q1 to q2
	 *  and pop last element from q1.
	 *  In either case, time complexity comes out as O(1).
	 */

	@Override
	public T pop() {
		int i = 0, size;
		try {
		if(q2.isEmpty()) {
			size = q1.size();
			while(i < size - 1) {
				q2.enQueue(q1.deQueue());
				i++;
			}
			return q1.deQueue();
		} else {
			size = q2.size();
			while(i < size - 1) {
				q1.enQueue(q2.deQueue());
				i++;
			}
			return q2.deQueue();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// it simply returns front of q2 or 
	// rear of q1,
	// so it runs in O(1) time
	@Override
	public T peek() {
		if(!q2.isEmpty()) {
			try {
				return q2.first();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return q1.getRear();
	}

	@Override
	public int size() {
		return q1.size() + q2.size();
	}

	@Override
	public boolean isEmpty() {
		return q1.isEmpty() && q2.isEmpty();
	}
	
	public String toString() {
		String result = "[";
		ListNode<T> front = null;
		try {
		if(q1.isEmpty()) 
			front = q2.getFront();
		 else 
			front = q1.getFront();
			
		 while(front.getNext() != null) {
			result += front.getData() + ", ";
			front = front.getNext();
		 }
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return result + front.getData() + "]";
	}
	
	public static void main(String[] args) {
		_1_c_StackUsingTwoQueues<Integer> swtq = new _1_c_StackUsingTwoQueues<>();
		try {
		swtq.push(5);
		System.out.println(swtq.toString());
		swtq.push(6);
		System.out.println(swtq.toString());
		swtq.push(7);
		System.out.println(swtq.toString());
		swtq.push(8);
		System.out.println(swtq.toString());
		swtq.push(9);
		System.out.println(swtq.toString());
		swtq.push(10);
		System.out.println(swtq.toString());
		swtq.push(11);
		System.out.println(swtq.toString());
		swtq.pop();
		System.out.println(swtq.toString());
		swtq.pop();
		System.out.println(swtq.toString());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	

}
