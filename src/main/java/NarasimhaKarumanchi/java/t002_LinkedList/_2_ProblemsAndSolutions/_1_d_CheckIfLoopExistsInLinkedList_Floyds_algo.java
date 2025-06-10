package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _1_d_CheckIfLoopExistsInLinkedList_Floyds_algo<T> {

	public boolean checkIfLoopExists(ListNode<T> head) {
		if(head == null) {
			return false;
		}
		
		// for checking loop, we use two pointers
		// one will travel twice as fast than other
		ListNode<T> fastPtr = head, slowPtr = head;
		
		// until fast pointer or its next becomes null, we proceed
		while(fastPtr != null && fastPtr.getNext() != null) {
			
			// advancing fast pointer twice
			fastPtr = fastPtr.getNext().getNext();
			// advancing slow pointer once
			slowPtr = slowPtr.getNext();
			
			// if at anytime two pointers meet
			// there is a loop in linked list
			if(slowPtr == fastPtr)
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		_1_d_CheckIfLoopExistsInLinkedList_Floyds_algo<Integer> mainClass = new _1_d_CheckIfLoopExistsInLinkedList_Floyds_algo<>();
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
		
		ListNode<Integer> head = new ListNode<>(11);
		ListNode<Integer> n1 = new ListNode<>(12);
		head.setNext(n1);
		ListNode<Integer> n2 = new ListNode<>(13);
		n1.setNext(n2);
		ListNode<Integer> n3 = new ListNode<>(12);
		n2.setNext(n3);		
		n3.setNext(n2);
		
		boolean isLoopExist = mainClass.checkIfLoopExists(ll.getHead());
		if(isLoopExist)
			System.out.println("Loop exists in given linked list");
		else
			System.out.println("Loop does not exist in given linked list");
	}

}
