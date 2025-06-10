package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class p002_FindNthNodeFromEndOfLinkedList_SinglePass<T> {

	public T findNthNodeFromEnd(ListNode<T> head, int n) {
		if(head == null) {
			return null;
		}
		
		// created two pointers,
		// first will travel till nth node from start initially
		// second pointer will actually find nth node from end
		ListNode<T> ptr1 = head, ptr2 = head;
		int count = 0;
		
		// ptr1 going till nth node from start
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
			
			// then both pointers travel one step
			// until ptr1 reaches the end.
			// At this stage, ptr2 will point to
			// nth node from end
			while(ptr1 != null) {
				ptr2 = ptr2.getNext();
				ptr1 = ptr1.getNext();
			}
			return ptr2.getData();
		}
	}

	public static void main(String[] args) {
		p002_FindNthNodeFromEndOfLinkedList_SinglePass<Integer> mainClass = new p002_FindNthNodeFromEndOfLinkedList_SinglePass<>();
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
		
		int n = 6;

		Integer nthNodeFromEnd = mainClass.findNthNodeFromEnd(ll.getHead(), n);
		System.out.println(n + "th node from end is : " + nthNodeFromEnd);
	}

}
