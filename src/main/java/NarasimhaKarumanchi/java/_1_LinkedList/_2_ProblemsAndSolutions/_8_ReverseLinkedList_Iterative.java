package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _8_ReverseLinkedList_Iterative<T> {

	public ListNode<T> reverseSinglyLinkedList(ListNode<T> head) {
		if(head == null) {
			return null;
		}
		
		//Initially, current is head
		ListNode<T> current = head;
		//Initially previous is null
		ListNode<T> prev = null;
		while(current != null) {
			ListNode<T> next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
		
	}

	public static void main(String[] args) {
		_8_ReverseLinkedList_Iterative<Integer> mainClass = new _8_ReverseLinkedList_Iterative<>();
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
		ll.insertAtEnd(22);
		System.out.println(ll.toString());
		
		ListNode<Integer> newList = mainClass.reverseSinglyLinkedList(ll.getHead());
		
		System.out.println(ll.toString(newList));
	}

}
