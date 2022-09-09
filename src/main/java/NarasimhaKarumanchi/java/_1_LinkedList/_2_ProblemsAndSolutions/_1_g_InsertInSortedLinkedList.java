package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_g_InsertInSortedLinkedList<T> {

	public void insertInSortedLinkedList(ListNode<T> head, ListNode<T> newNode) {
		if(head == null) {
			head = newNode;
		}
		ListNode<T> current = head, temp = null;
		while(current != null && (Integer)current.getData() < (Integer)newNode.getData()) {
			temp = current;
			current = current.getNext();
		}
		
		newNode.setNext(current);
		temp.setNext(newNode);
		
	}

	public static void main(String[] args) {
		_1_g_InsertInSortedLinkedList<Integer> mainClass = new _1_g_InsertInSortedLinkedList<>();
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
		
		ListNode<Integer> newNode = new ListNode<>(11);
		
		mainClass.insertInSortedLinkedList(ll.getHead(), newNode);
		
		System.out.println(ll.toString());
	}

}
