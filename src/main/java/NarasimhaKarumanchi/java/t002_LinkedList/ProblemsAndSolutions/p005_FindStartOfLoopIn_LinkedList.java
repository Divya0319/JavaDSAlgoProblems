package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class p005_FindStartOfLoopIn_LinkedList<T> {

	public ListNode<T> findStartOfLoop(ListNode<T> head) {
		if(head == null) {
			return null;
		}
		ListNode<T> fastPtr = head, slowPtr = head;
		boolean loopExists = false;
		
		// first checking if loop exists of not
		while(fastPtr != null && fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if(slowPtr == fastPtr) {
				loopExists = true;
				break;
			}
		}
		
		// checking loop length only when loop exists
		if(loopExists) {
			
			// we set slowPtr to head initially
			// (can set any pointer to head,
			// but then, in the end, have to check other pointer for
			// starting of loop)
			slowPtr = head;
			while(slowPtr != fastPtr) {
				
				// now both pointers are going one step at a time
				// until both pointers meet
				slowPtr = slowPtr.getNext();
				fastPtr = fastPtr.getNext();
			}
			
			// now, both pointers point to start
			// of loop
			return fastPtr;
		} else {
			return null;
		}
		
		
	}

	public static void main(String[] args) {
		p005_FindStartOfLoopIn_LinkedList<Integer> mainClass = new p005_FindStartOfLoopIn_LinkedList<>();
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
		ll.insertAndCreateLoop(45, 5);
		
		ListNode<Integer> startOfLoopNode = mainClass.findStartOfLoop(ll.getHead());
		if(startOfLoopNode != null)
			System.out.println("Loop exists and it starts from : " + startOfLoopNode.getData());
		else
			System.out.println("Loop does not exist in given linked list");
	}

}
