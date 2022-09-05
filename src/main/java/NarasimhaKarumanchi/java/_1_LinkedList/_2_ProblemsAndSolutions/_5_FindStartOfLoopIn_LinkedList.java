package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _5_FindStartOfLoopIn_LinkedList<T> {

	public ListNode<T> findStartOfLoop(ListNode<T> head) {
		if(head == null) {
			return null;
		}
		ListNode<T> fastPtr = head, slowPtr = head;
		boolean loopExists = false;
		while(fastPtr != null && fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if(slowPtr == fastPtr) {
				loopExists = true;
				break;
			}
		}
			
		if(loopExists) {
			slowPtr = head;
			while(slowPtr != fastPtr) {
				slowPtr = slowPtr.getNext();
				fastPtr = fastPtr.getNext();
			}
			return fastPtr;
		} else {
			return null;
		}
		
		
	}

	public static void main(String[] args) {
		_5_FindStartOfLoopIn_LinkedList<Integer> mainClass = new _5_FindStartOfLoopIn_LinkedList<>();
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
