package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_h_FindModularNodeFromBeginningInLinkedList<T> {
	
	public ListNode<T> findModularNode(ListNode<T> head, int k) {
		ListNode<T> modularNode = null;
		if(k <= 0) return null;
		
		int i = 1;
		for(; head != null; head = head.getNext()) {
			if(i % k == 0) 
				{
					modularNode = head;
				}
				
				i++;
		}
			
		return modularNode;
	}
		
	public static void main(String[] args) {
		_2_h_FindModularNodeFromBeginningInLinkedList<Integer> mainClass = new _2_h_FindModularNodeFromBeginningInLinkedList<>();

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
		
		ListNode<Integer> modularNode = mainClass.findModularNode(ll.getHead(), 4);
		System.out.println("Modular Node of Linked List : " + modularNode.getData());
	}

}
