package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_p_PrintLinkedListFromEnd_Recursive<T> {

	public void printLinkedListRecursive(ListNode<T> head) {
		
		// when reached end of list
		// returning from recursion
		if(head == null) {
			return;
		}
		
		// first going recursively till end of list
		printLinkedListRecursive(head.getNext());
		
		// while returning, printing the list
		// from end
		System.out.print(head.getData() + " ");;
	}

	public static void main(String[] args) {
		_1_p_PrintLinkedListFromEnd_Recursive<Integer> mainClass = new _1_p_PrintLinkedListFromEnd_Recursive<>();
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
		
		mainClass.printLinkedListRecursive(ll.getHead());
	}

}
