package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _2_p_PartitionLinkedListBasedOnK {
	
	public ListNode<Integer> partitionLinkedList(ListNode<Integer> head, int k) {
		
		/* dummy nodes created for 
		 * left and right partitions of list
		 */
		ListNode<Integer> left = new ListNode<>(0);
		ListNode<Integer> right = new ListNode<>(0);
		
		/* two more node pointers
		 * for traversing left and right partitions
		 * of list respectively
		 */
		ListNode<Integer> l = left, r = right;
		
		
		while(head != null) {
			
			// when current node's value less than k
			
			if(head.getData() < k) { 
				
				// adding this current node to left partition
				l.setNext(head);
				// advancing pointer of left partition
				l = l.getNext();
			} else {
				
				// else, adding this current node to left partition
				r.setNext(head);
				// advancing pointer of right partition
				r = r.getNext();
			}
			
			// going to next node of given list
			head = head.getNext();
		}
		
		
		// last node of left partition
		// to be linked to right's first node
		l.setNext(right.getNext());
		
		// right partition's last node should point to null
		r.setNext(null);
		
		// since left was pointing to dummy,
		// its next will be actual starting 
		// of left partition
		return left.getNext();
		
	}
		
	public static void main(String[] args) {
		_2_p_PartitionLinkedListBasedOnK mainClass = new _2_p_PartitionLinkedListBasedOnK();

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
		ll.insertAtEnd(16);
		System.out.println(ll.toString());
		ll.insertAtEnd(7);
		System.out.println(ll.toString());
		ll.insertAtEnd(8);		
		System.out.println(ll.toString());
	
		int k = 5;
		ListNode<Integer> newList = mainClass.partitionLinkedList(ll.getHead(), k);
		System.out.println("Partitioned Linked List based on " + k + " : " + ll.toString(newList));
	}

}
