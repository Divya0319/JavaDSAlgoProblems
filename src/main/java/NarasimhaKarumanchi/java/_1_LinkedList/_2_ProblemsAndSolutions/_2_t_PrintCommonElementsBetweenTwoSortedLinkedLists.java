package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_t_PrintCommonElementsBetweenTwoSortedLinkedLists {
	
	public ListNode<Integer> printCommonElements(ListNode<Integer> l1, ListNode<Integer> l2) {
		
		// Given lists are sorted
		// we maintain a dummy node, and
		// return common linked list as its next
		ListNode<Integer> dummy = new ListNode<>(0);
		ListNode<Integer> head = dummy;
		while(l1 != null && l2 != null) {
			if(l1.getData() == l2.getData()) {
				
				// common element found, so add it to resulting linked list
				head.setNext(new ListNode<Integer>(l1.getData()));
				
				// advance both lists pointers
				l1 = l1.getNext();
				l2 = l2.getNext();
				head = head.getNext();
				
				// if l2 list has smaller element than l1
				// we advance pointer of l2 only bcz lists are sorted
			} else if(l1.getData() > l2.getData()) {
				l2 = l2.getNext();
			} else {
				
				// else, we advance pointer l2, as l2 has smaller element
				l1 = l1.getNext();
			}
		}
		
		
		// returning actual generated common linked list
		return dummy.getNext();
	}
		
	public static void main(String[] args) {
		_2_t_PrintCommonElementsBetweenTwoSortedLinkedLists mainClass = new _2_t_PrintCommonElementsBetweenTwoSortedLinkedLists();

		LinkedList<Integer> ll1 = new LinkedList<>();
		ll1.insertAtBegin(2);
		ll1.insertAtEnd(6);
		ll1.insertAtEnd(7);
		ll1.insertAtEnd(9);
		ll1.insertAtEnd(11);
		ll1.insertAtEnd(16);

		System.out.println(ll1.toString());
		
		LinkedList<Integer> ll2 = new LinkedList<>();
		ll2.insertAtBegin(2);
		ll2.insertAtEnd(8);
		ll2.insertAtEnd(9);
		ll2.insertAtEnd(12);
		ll2.insertAtEnd(15);
		ll2.insertAtEnd(54);
		
		System.out.println(ll2.toString());

		ListNode<Integer> commonElementList = mainClass.printCommonElements(ll1.getHead(), ll2.getHead());
		System.out.println("Common elements in given linked lists: " + ll1.toString(commonElementList));
	}

}
