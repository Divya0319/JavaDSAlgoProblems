package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _4_CheckIfLoopExistsInLinkedList_Floyds_algo<T> {

	public boolean checkIfLoopExists(ListNode<T> head) {
		if(head == null) {
			return false;
		}
		ListNode<T> fastPtr = head, slowPtr = head;
		while(fastPtr != null && fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if(slowPtr == fastPtr)
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		_4_CheckIfLoopExistsInLinkedList_Floyds_algo<Integer> mainClass = new _4_CheckIfLoopExistsInLinkedList_Floyds_algo<>();
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
		ll.insertAndCreateLoop(45, 3);
		
		boolean isLoopExist = mainClass.checkIfLoopExists(ll.getHead());
		if(isLoopExist)
			System.out.println("Loop exists in given linked list");
		else
			System.out.println("Loop does not exist in given linked list");
	}

}
