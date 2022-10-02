package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_g_InsertInSortedLinkedList {

	public void insertInSortedLinkedList(ListNode<Integer> head, ListNode<Integer> newNode) {
		if(head == null) {
			head = newNode;
		}
		ListNode<Integer> current = head, prev = null;
		
		// traversing through list until
		// a bigger element than inserting element
		// is not found
		while(current != null && current.getData() < newNode.getData()) {
			
			// prev is always pointing to one node
			// previous to current node of list
			prev = current;
			current = current.getNext();
		}
		
		// making next of new node point to its bigger element
		newNode.setNext(current);
		// making next of smaller node than new node point to new node
		prev.setNext(newNode);
		
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
		
		System.out.println("Element to insert: 11" );
		
		mainClass.insertInSortedLinkedList(ll.getHead(), newNode);
		
		System.out.println("List after insertion: "  + ll.toString());
	}

}
