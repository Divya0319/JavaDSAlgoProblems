package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_f_FindLengthOfLoopIn_LinkedList<T> {

	public int findLengthOfLoop(ListNode<T> head) {
		if(head == null) {
			return -1;
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
		} 
		
		int length = 0;
		do {
			slowPtr = slowPtr.getNext();
			length++;
		} while(slowPtr != fastPtr);
		
		if(loopExists) 
			return length;
		else 
			return -1;
	}

	public static void main(String[] args) {
		_1_f_FindLengthOfLoopIn_LinkedList<Integer> mainClass = new _1_f_FindLengthOfLoopIn_LinkedList<>();
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
		
		int loopLength = mainClass.findLengthOfLoop(ll.getHead());
		if(loopLength != -1)
			System.out.println("Loop exists and its length is : " + loopLength);
		else
			System.out.println("Loop does not exist in given linked list");
	}

}
