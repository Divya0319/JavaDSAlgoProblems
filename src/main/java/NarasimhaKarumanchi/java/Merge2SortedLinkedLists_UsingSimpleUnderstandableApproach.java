package main.java.NarasimhaKarumanchi.java;


import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class Merge2SortedLinkedLists_UsingSimpleUnderstandableApproach {
	
	
	public ListNode<Integer> merge2Lists(ListNode<Integer> l1, ListNode<Integer> l2) {
		
		if(l1 == null || l2 == null) return (l1 != null? l1 : l2);
		
		// dummy node is used here to avoid handling null pointer exceptions
		// while one of the list iterator reaches null
		ListNode<Integer> dummy = new ListNode<>(-1);
		ListNode<Integer> prev = dummy;
		ListNode<Integer> c1 = l1, c2 = l2;
		while(c1 != null && c2 != null) {
			if(c1.getData() <= c2.getData()) {
				prev.setNext(c1);
				c1 = c1.getNext();
			} else {
				prev.setNext(c2);
				c2 = c2.getNext();
			}
			prev = prev.getNext();
		}
		
		prev.setNext((c1 != null) ? c1 : c2);
		
		return dummy.getNext();
						
	}

	
	public static void main(String[] args) {
		
		LinkedList<Integer> l1 = new LinkedList<>();
		l1.insertAtBegin(5);
		l1.insertAtEnd(9);
		l1.insertAtEnd(14);
		l1.insertAtEnd(17);
		l1.insertAtEnd(21);
		l1.insertAtEnd(43);
		l1.insertAtEnd(51);
		l1.insertAtEnd(76);
		l1.insertAtEnd(89);
		
		LinkedList<Integer> l2 = new LinkedList<>();
		l2.insertAtBegin(1);
		l2.insertAtEnd(3);
		l2.insertAtEnd(7);
		l2.insertAtEnd(11);
		l2.insertAtEnd(15);
		l2.insertAtEnd(19);
		l2.insertAtEnd(34);
		l2.insertAtEnd(65);
		l2.insertAtEnd(77);
		
		
		System.out.println("Given list 1: " + l1.toString());
		System.out.println("Given list 2: " + l2.toString());

		
		Merge2SortedLinkedLists_UsingSimpleUnderstandableApproach mainClass = 
				new Merge2SortedLinkedLists_UsingSimpleUnderstandableApproach();
		ListNode<Integer> resultList = mainClass.merge2Lists(l1.getHead(), l2.getHead());
		
		System.out.println("Merged sorted list: " + l1.toString(resultList));

	}

}
