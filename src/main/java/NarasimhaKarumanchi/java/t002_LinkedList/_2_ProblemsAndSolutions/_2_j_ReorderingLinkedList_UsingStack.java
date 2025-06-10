package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedStack;

public class _2_j_ReorderingLinkedList_UsingStack<T> {
	
	public ListNode<T> reorderListUsingStack(ListNode<T> head) {
		
		if(head == null) return null;
		
		
		// finding middle node here
		// slowPtr will point to middle node
		
		// middle node:  ceil(n+1/2), when n is even
		//               ceil(n/2), when n is odd
		ListNode<T> slowPtr = head, fastPtr = head;
		while(fastPtr != null && fastPtr.getNext() != null) { // when we want middle element to be first of the two nodes
//		while(fast.getNext() != null && fast.getNext().getNext() != null) // when we want middle element to be second of the two nodes
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		ListNode<T> newHead = slowPtr.getNext();
		
		// middle node will be last node in final result
		// so setting its next to null
		slowPtr.setNext(null);
		LinkedStack<ListNode<T>> stk = new LinkedStack<>();
		
		// storing all nodes after middle node
		// into stack, in order to operate them in reverse
		// when popped next time
		// (Note: all node's next are set to null before storing to stack)
		while(newHead != null) {
			ListNode<T> temp = newHead;
			newHead = newHead.getNext();
			temp.setNext(null);
			stk.push(temp);
		}
		
		// taking out all nodes after middle node
		// in reverse
		// and attaching them in spiral manner
		// as required
		while(!stk.isEmpty()) {
			ListNode<T> temp = stk.pop();
			// last node's next pointed to 2nd node of list
			temp.setNext(head.getNext());
			// 1st node's next pointed to last node
			head.setNext(temp);
			// head advanced to 2nd node of list now
			head = temp.getNext();
		}
		
		return head;
	}
		
	public static void main(String[] args) {
		_2_j_ReorderingLinkedList_UsingStack<Character> mainClass = new _2_j_ReorderingLinkedList_UsingStack<>();

		LinkedList<Character> ll = new LinkedList<>();
		ll.insertAtBegin('a');
		System.out.println(ll.toString());
		ll.insertAtEnd('b');
		System.out.println(ll.toString());
		ll.insertAtEnd('c');
		System.out.println(ll.toString());
		ll.insertAtEnd('d');
		System.out.println(ll.toString());
		ll.insertAtEnd('e');
		System.out.println(ll.toString());
		ll.insertAtEnd('f');
		System.out.println(ll.toString());
		ll.insertAtEnd('g');
		System.out.println(ll.toString());
		ll.insertAtEnd('h');
		System.out.println(ll.toString());
		ll.insertAtEnd('i');
		System.out.println(ll.toString());
		ll.insertAtEnd('j');
		System.out.println(ll.toString());
		ll.insertAtEnd('k');
		System.out.println(ll.toString());
		ll.insertAtEnd('l');
		System.out.println(ll.toString());
		ll.insertAtEnd('m');
		System.out.println(ll.toString());
		ll.insertAtEnd('n');
		System.out.println(ll.toString());
		ll.insertAtEnd('o');
		System.out.println(ll.toString());
		ll.insertAtEnd('p');
		System.out.println(ll.toString());
		ll.insertAtEnd('q');
		System.out.println(ll.toString());
		ll.insertAtEnd('r');
		System.out.println(ll.toString());
		ll.insertAtEnd('s');
		System.out.println(ll.toString());
		
		mainClass.reorderListUsingStack(ll.getHead());
		System.out.println("Reordered List : " + ll.toString());
		
	}

}
