package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_g_InsertInSortedLinkedList {

	public void insertInSortedLinkedList(ListNode<Integer> head, ListNode<Integer> newNode) {
		if(head == null) {
			head = newNode;
		}
		ListNode<Integer> current = head, temp = null;
		while(current != null && current.getData() < newNode.getData()) {
			temp = current;
			current = current.getNext();
		}
		
		newNode.setNext(current);
		temp.setNext(newNode);
		
	}

	public static void main(String[] args) {
		_1_g_InsertInSortedLinkedList mainClass = new _1_g_InsertInSortedLinkedList();
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
