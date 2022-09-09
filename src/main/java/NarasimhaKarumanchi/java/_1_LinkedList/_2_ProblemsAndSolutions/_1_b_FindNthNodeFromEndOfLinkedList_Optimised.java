package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_b_FindNthNodeFromEndOfLinkedList_Optimised<T> {

	public T findNthNodeFromEnd(ListNode<T> head, int n) {
		if(head == null) {
			return null;
		}
		ListNode<T> ptr1 = head, ptr2 = head;
		int count = 0;
		while(count < n) {
			if(ptr1 == null) {
				return null;
			}
			ptr1 = ptr1.getNext();
			count++;
		}
		
		if(ptr1 == null) {
			return head.getData();
		} else {
			while(ptr1 != null) {
				ptr2 = ptr2.getNext();
				ptr1 = ptr1.getNext();
			}
			return ptr2.getData();
		}
	}

	public static void main(String[] args) {
		_1_b_FindNthNodeFromEndOfLinkedList_Optimised<Integer> mainClass = new _1_b_FindNthNodeFromEndOfLinkedList_Optimised<>();
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
		
		int n = 5;

		Integer nthNodeFromEnd = mainClass.findNthNodeFromEnd(ll.getHead(), n);
		System.out.println(n + "th node from end is : " + nthNodeFromEnd);
	}

}
