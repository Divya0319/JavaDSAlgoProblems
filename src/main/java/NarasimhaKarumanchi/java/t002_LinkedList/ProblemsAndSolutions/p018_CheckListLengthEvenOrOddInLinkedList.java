package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;


import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class p018_CheckListLengthEvenOrOddInLinkedList<T> {

	public boolean checkListLengthEven(ListNode<T> head) {
		
		// Traversing the list two steps at a time
		while(head != null && head.getNext() != null) 
			head = head.getNext().getNext();
		
		// if we reached end of list
		// list length is even
		if(head == null) return true;
		
		
		// else, length is odd
		return false;

	}

	public static void main(String[] args) {
		p018_CheckListLengthEvenOrOddInLinkedList<Integer> mainClass = new p018_CheckListLengthEvenOrOddInLinkedList<>();
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
		ll.insertAtEnd(8);
		System.out.println(ll.toString());
		
		ListNode<Integer> head = new ListNode<>(11);
		ListNode<Integer> n1 = new ListNode<>(12);
		head.setNext(n1);
		ListNode<Integer> n2 = new ListNode<>(13);
		n1.setNext(n2);
		n2.setNext(null);
//		ListNode<Integer> n3 = new ListNode<>(14);
//		n2.setNext(n3);		
//		n3.setNext(null);
		
		boolean isEven = mainClass.checkListLengthEven(head);
		System.out.println("Linked List length even? " + isEven);
	}

}
