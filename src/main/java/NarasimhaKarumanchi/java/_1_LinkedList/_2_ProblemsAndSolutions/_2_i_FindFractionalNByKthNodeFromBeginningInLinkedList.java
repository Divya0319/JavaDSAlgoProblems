package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_i_FindFractionalNByKthNodeFromBeginningInLinkedList<T> {
	
	public ListNode<T> findFractionalNode(ListNode<T> head, int k) {
		
		if(k <= 0) return null;
		if(head == null) return null;
		
		ListNode<T> fractionalNode = null;
		int i = 1;
		
		
		// we set fractional node for every k movements of a temp pointer
		// if fractional node is null, and we moved temp k times, we move 
		// fractional node to head.
		// and for every other k movements of temp, we move fractional node one step forward
		// If we reached end of list, current value of fractional node is (n/k)th) node from beginning
		
		ListNode<T> temp = head;
		while(temp != null) {
			if(i % k == 0) {
				if(fractionalNode == null) 
					fractionalNode = head;
				else 
					fractionalNode = fractionalNode.getNext();
			}
			
			// i used to keep track of how many times k movements of temp are done
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
		
		ListNode<Integer> modularNode = mainClass.findFractionalNode(ll.getHead(), 13);
		System.out.println("N/13th Node of Linked List : " + modularNode.getData());
	}

}
