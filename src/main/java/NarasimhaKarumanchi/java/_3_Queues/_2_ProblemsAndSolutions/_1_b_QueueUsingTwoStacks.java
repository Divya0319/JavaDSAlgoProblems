package main.java.NarasimhaKarumanchi.java._3_Queues._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._3_Queues.ListNode;
import main.java.NarasimhaKarumanchi.java._3_Queues.DynamicQueueService;
import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedStack;

public class _1_b_QueueUsingTwoStacks<T> implements DynamicQueueService<T> {

	private LinkedStack<T> s1 = new LinkedStack<>();
	private LinkedStack<T> s2 = new LinkedStack<>();

	
	// Time Complexity:  O(1)
	@Override
	public void enQueue(T data) {
		s1.push(data);

	}

	// while dequeuing, have to pop (n-1) elements from s1, to push to s2
	// and then pop 1 element from s1.
	// so, time complexity comes out as O(n)
	@Override
	public T deQueue() {
		int i = 0, size;
		if (s2.isEmpty()) {
			size = s1.size();
			while (i < size - 1) {
				s2.push(s1.pop());
				i++;
			}
			return s1.pop();
		} else
			return s2.pop();
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
					/*
						Recursive approach to print stack elements
			 		*/
				// if(s1.isEmpty()) {
				// return result;
				// }
				// int x = s1.pop();
				// toString();
				// System.out.print(x + " ");
				// s1.push(x);
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
		try {
			_1_b_QueueUsingTwoStacks<Integer> quts = new _1_b_QueueUsingTwoStacks<>();
			quts.enQueue(1);
			System.out.println(quts.toString());
			quts.enQueue(2);
			System.out.println(quts.toString());
			quts.enQueue(3);
			System.out.println(quts.toString());
			quts.enQueue(4);
			System.out.println(quts.toString());
			quts.enQueue(5);
			System.out.println(quts.toString());
			quts.deQueue();
			System.out.println(quts.toString());
			quts.enQueue(6);
			System.out.println(quts.toString());
			quts.deQueue();
			System.out.println(quts.toString());
			quts.enQueue(7);
			System.out.println(quts.toString());
			quts.enQueue(8);
			System.out.println(quts.toString());
			quts.deQueue();
			System.out.println(quts.toString());
			quts.deQueue();
			System.out.println(quts.toString());
			quts.deQueue();
			System.out.println(quts.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
