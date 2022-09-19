package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedStack;

public class _2_j_ReorderingLinkedList_UsingStack<T> {
	
	public ListNode<T> reorderListUsingStack(ListNode<T> head) {
		
		if(head == null) return null;
		
		ListNode<T> slowPtr = head, fastPtr = head.getNext();
		while(fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		ListNode<T> newHead = slowPtr.getNext();
		slowPtr.setNext(null);
		LinkedStack<ListNode<T>> stk = new LinkedStack<>();
		while(newHead != null) {
			ListNode<T> temp = newHead;
			newHead = newHead.getNext();
			temp.setNext(null);
			stk.push(temp);
		}
		
		while(!stk.isEmpty()) {
			ListNode<T> temp = stk.pop();
			temp.setNext(head.getNext());
			head.setNext(temp);
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
