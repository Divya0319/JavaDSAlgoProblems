package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_a_FindNthNodeFromEndOfLinkedList_TwoPassSolution<T> {

	public T findNthNodeFromEnd(ListNode<T> head, int n) {
		int length = 0;
		ListNode<T> temp = head;
		while(temp != null) {
			temp = temp.getNext();
			length++;
		}
		
		if(length < n) {
			return null;
		}
		
		temp = head;
		
		for(int i = 1; i < length - n + 1; i++) {
			temp = temp.getNext();
		}
		
		return temp.getData();

	}

	public static void main(String[] args) {
		_1_a_FindNthNodeFromEndOfLinkedList_TwoPassSolution<Integer> mainClass = new _1_a_FindNthNodeFromEndOfLinkedList_TwoPassSolution<>();
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
		
		int n = 4;

		Integer nthNodeFromEnd = mainClass.findNthNodeFromEnd(ll.getHead(), n);
		System.out.println(n + "th node from end is : " + nthNodeFromEnd);
	}

}
