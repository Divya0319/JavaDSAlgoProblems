package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_q_RemoveDuplicatesFromUnorderedLinkedList_BruteForce {
	
	public ListNode<Integer> removeDup(ListNode<Integer> head) {
		
		// this curr pointer will pass original node
		// and this node's value is checked
		// if there are any duplicates 
		// of same node are present or not
		ListNode<Integer> curr = head;
		if(curr == null || curr.getNext() == null) {
			return curr;
		}
		
		// next pointer will be passing all later nodes after 
		// current node for comparison
		// and prev node will always hold 
		// node previous to current node
		// and it is used to update the links of
		// previous pointer before
		// duplicate node
		ListNode<Integer> next, prev;
		while(curr != null) {
			next = curr.getNext();
			prev = curr;
			while(next != null) {
				if(curr.getData() == next.getData()) {
					prev.setNext(next.getNext());
				}
				
				prev = next;
				next = next.getNext();
			}
			
			
			// curr is updated every time 
			// one cycle of inner loop
			// is over
			curr = curr.getNext();
		}
		
		return head;
	}
		
	public static void main(String[] args) {
		_2_q_RemoveDuplicatesFromUnorderedLinkedList_BruteForce mainClass = new _2_q_RemoveDuplicatesFromUnorderedLinkedList_BruteForce();

		LinkedList<Integer> ll = new LinkedList<>();
		ll.insertAtBegin(1);
		System.out.println(ll.toString());
		ll.insertAtEnd(11);
		System.out.println(ll.toString());
		ll.insertAtEnd(3);
		System.out.println(ll.toString());
		ll.insertAtEnd(4);
		System.out.println(ll.toString());
		ll.insertAtEnd(10);
		System.out.println(ll.toString());
		ll.insertAtEnd(5);
		System.out.println(ll.toString());
		ll.insertAtEnd(15);
		System.out.println(ll.toString());
		ll.insertAtEnd(6);
		System.out.println(ll.toString());
		ll.insertAtEnd(3);
		System.out.println(ll.toString());
		ll.insertAtEnd(16);
		System.out.println(ll.toString());
		ll.insertAtEnd(7);
		System.out.println(ll.toString());
		ll.insertAtEnd(3);
		System.out.println(ll.toString());
		ll.insertAtEnd(8);		
		System.out.println(ll.toString());
		ll.insertAtEnd(15);
		System.out.println(ll.toString());
	
		mainClass.removeDup(ll.getHead());
		System.out.println("Linked List with no duplicates: " + ll.toString());
	}

}
