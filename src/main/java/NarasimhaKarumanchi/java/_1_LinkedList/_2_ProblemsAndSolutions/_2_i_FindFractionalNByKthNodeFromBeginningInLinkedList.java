package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_i_FindFractionalNByKthNodeFromBeginningInLinkedList<T> {
	
	public ListNode<T> findFractionalNode(ListNode<T> head, int k) {
		
		if(k <= 0) return null;
		if(head == null) return null;
		
		ListNode<T> fractionalNode = null;
		int i = 1;
		
		ListNode<T> temp = head;
		while(temp != null) {
			if(i % k == 0) {
				if(fractionalNode == null) 
					fractionalNode = head;
				else 
					fractionalNode = fractionalNode.getNext();
			}
			i++;
			temp = temp.getNext();
		}
		
		return fractionalNode;
	}
		
	public static void main(String[] args) {
		_2_i_FindFractionalNByKthNodeFromBeginningInLinkedList<Integer> mainClass = new _2_i_FindFractionalNByKthNodeFromBeginningInLinkedList<>();

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
		
		ListNode<Integer> modularNode = mainClass.findFractionalNode(ll.getHead(), 3);
		System.out.println("N/kth Node of Linked List : " + modularNode.getData());
	}

}
