package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import java.util.ArrayList;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;
import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedStack;

public class _1_q_PrintLinkedListFromEnd_Iterative<T> {

	public ArrayList<T> printListFromEnd(ListNode<T> head) {
		ArrayList<T> result = new ArrayList<>();
		
		if(head == null) {
			return null;
		}

		// case for single node list
		if(head.getNext() == null) {
			result.add(head.getData());
			return result;
		}
		
		// replicating recursion using a stack
		LinkedStack<T> stk = new LinkedStack<>();
		ListNode<T> temp = head;
		
		// until we reach end of list
		// we push node data one by one to stack
		while(temp != null) {
			stk.push(temp.getData());
			temp = temp.getNext();
		}
		
		// when list is over
		// we pop from stack
		// and add it to result array
		while(!stk.isEmpty()) {
			result.add(stk.pop());
		}
		return result;
		
	}

	public static void main(String[] args) {
		_1_q_PrintLinkedListFromEnd_Iterative<Integer> mainClass = new _1_q_PrintLinkedListFromEnd_Iterative<>();
		LinkedList<Integer> ll = new LinkedList<>();
		ll.insertAtBegin(1);
		System.out.println(ll.toString());
		ll.insertAtEnd(2);
		System.out.println(ll.toString());
		ll.insertAtEnd(3);
		System.out.println(ll.toString());
		ll.insertAtEnd(4);
		System.out.println(ll.toString());
		ll.insertAtEnd(5);
		System.out.println(ll.toString());
		ll.insertAtEnd(6);
		System.out.println(ll.toString());
		ll.insertAtEnd(7);
		System.out.println(ll.toString());
		
		ArrayList<Integer> result = mainClass.printListFromEnd(ll.getHead());
		System.out.println("Linked List from end: " + result);
	}

}
