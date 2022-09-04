package main.java.NarasimhaKarumanchi.java._3_Queues._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java._3_Queues.ListNode;
import main.java.NarasimhaKarumanchi.java._3_Queues.StackService;

public class _3_StackUsing2Queues<T> implements StackService<T> {
	
	private LinkedQueue<T> q1 = new LinkedQueue<T>();
	private LinkedQueue<T> q2= new LinkedQueue<T>();

	@Override
	public void push(T data) {
		if(q1.isEmpty()) {
			q2.enQueue(data);
		} else {
			q1.enQueue(data);
		}
		
	}

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
		ListNode<T> front;
		try {
		if(q1.isEmpty()) 
			front = q2.getFront();
		 else 
			front = q1.getFront();
			
		 while(front != null) {
			result += front.getData() + " ";
			front = front.getNext();
		 }
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return result + "]";
	}
	
	public static void main(String[] args) {
		_3_StackUsing2Queues<Integer> swtq = new _3_StackUsing2Queues<>();
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
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	

}
