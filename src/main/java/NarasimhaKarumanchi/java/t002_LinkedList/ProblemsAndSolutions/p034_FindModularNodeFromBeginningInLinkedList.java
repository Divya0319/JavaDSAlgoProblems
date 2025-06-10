package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class p034_FindModularNodeFromBeginningInLinkedList<T> {
	
	public ListNode<T> findModularNode(ListNode<T> head, int k) {
		ListNode<T> modularNode = null;
		if(k <= 0) return null;
		
		int i = 1;
		
		ListNode<T> temp = head;
		
		
		// we are setting modular node
		// every time we find a node whose position
		// is divisible by k
		// This is done until end of list.
		// The last modular node set is the answer.
		while(temp != null) {
			if(i % k == 0) 
				modularNode = temp;

			i++;
			temp = temp.getNext();

		}
			
		return modularNode;
	}
		
	public static void main(String[] args) {
		p034_FindModularNodeFromBeginningInLinkedList<Integer> mainClass = new p034_FindModularNodeFromBeginningInLinkedList<>();

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
		ll.insertAtEnd(9);
		System.out.println(ll.toString());
		ll.insertAtEnd(10);
		System.out.println(ll.toString());
		ll.insertAtEnd(11);
		System.out.println(ll.toString());
		ll.insertAtEnd(12);
		System.out.println(ll.toString());
		ll.insertAtEnd(13);
		System.out.println(ll.toString());
		ll.insertAtEnd(14);
		System.out.println(ll.toString());
		ll.insertAtEnd(15);
		System.out.println(ll.toString());
		ll.insertAtEnd(16);
		System.out.println(ll.toString());
		ll.insertAtEnd(17);
		System.out.println(ll.toString());
		ll.insertAtEnd(18);
		System.out.println(ll.toString());
		ll.insertAtEnd(19);
		System.out.println(ll.toString());
		
		ListNode<Integer> modularNode = mainClass.findModularNode(ll.getHead(), 3);
		System.out.println("Modular Node of Linked List : " + modularNode.getData());
	}

}
