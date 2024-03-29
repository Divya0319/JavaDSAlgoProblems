package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_i_ReverseLinkedList_Recursive<T> {

	public ListNode<T> reverseSinglyLinkedList(ListNode<T> head) {
		if(head == null)
			return head;
		
		if(head.getNext() == null) { // condition to check for last node
			return head;
		}
		
		ListNode<T> newHeadNode = reverseSinglyLinkedList(head.getNext());
		
		// this line actually reverses 
		// the link direction of next node, to current node
		head.getNext().setNext(head);
		
		// and head will be last node,
		// so its next will be null
		head.setNext(null);
		
		return newHeadNode;
	}

	public static void main(String[] args) {
		_1_i_ReverseLinkedList_Recursive<Integer> mainClass = new _1_i_ReverseLinkedList_Recursive<>();
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
