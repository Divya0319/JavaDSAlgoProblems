package main.java.NarasimhaKarumanchi.java._2_Stacks;

import main.java.NarasimhaKarumanchi.java._3_Queues.DynamicQueueService;
import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedStack;
import main.java.NarasimhaKarumanchi.java._3_Queues.ListNode;

public class _1_a_TestClass<T> implements DynamicQueueService<T> {
	
	LinkedStack<T> s1 = new LinkedStack<>();
	LinkedStack<T> s2 = new LinkedStack<>();

	
	@Override
	public void enQueue(T data) {
		
		s1.push(data);
	}

	@Override
	public T deQueue() throws Exception {
		
		if(s2.isEmpty()) {
			while(s1.size() > 1) {
				s2.push(s1.pop());
			}
			
			return s1.pop();
		} else {
			return s2.pop();
		}
		
	}

	@Override
	public int size() {
		return s1.size() + s2.size();
	}

	@Override
	public boolean isEmpty() {
		
		return s1.isEmpty() && s2.isEmpty();
	}
	
	public String toString() {
		String result = "[";
		try {
			if (s2.isEmpty()) {

				LinkedStack<T> tempStack = new LinkedStack<>();
				ListNode<T> top = s1.getTop();
				while (top != null) {
					tempStack.push(top.getData());
					top = top.getNext();
				}
				while (!tempStack.isEmpty()) {
					result += tempStack.pop() + ", ";
				}

			} else {
				ListNode<T> top1 = s1.getTop();
				LinkedStack<T> tempStack = new LinkedStack<>();
				ListNode<T> top2 = s2.getTop();
				while (top2 != null) {
					result += top2.getData() + ", ";
					top2 = top2.getNext();
				}
				while (top1 != null) {
					tempStack.push(top1.getData());
					top1 = top1.getNext();
				}
				while (!tempStack.isEmpty()) {
					result += tempStack.pop() + ", ";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result + "]";
	}

	
	public static void main(String[] args) {
		_1_a_TestClass<Integer> mainClass = new _1_a_TestClass<>();
		
		mainClass.enQueue(56);
		mainClass.enQueue(5);
		mainClass.enQueue(8);
		mainClass.enQueue(23);
		mainClass.enQueue(89);
		mainClass.enQueue(21);
		mainClass.enQueue(52);
		mainClass.enQueue(90);
		
		System.out.println(mainClass.toString());
		try {
			mainClass.deQueue();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println(mainClass.toString());

		
	}



}
