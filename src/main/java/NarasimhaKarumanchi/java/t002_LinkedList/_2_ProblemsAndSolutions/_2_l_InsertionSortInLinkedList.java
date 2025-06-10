package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _2_l_InsertionSortInLinkedList {
	
	public ListNode<Integer> doInsertionSort(ListNode<Integer> head) {
		
		ListNode<Integer> dummy = new ListNode<>(0);
		
		// curr will take each node one by one for sorting
		ListNode<Integer> curr = head;
		
		while(curr != null) { // until we reach the end of the list
			
			// temp will keep track of
			// next node to be considered for sorting, after curr
			ListNode<Integer> temp = curr.getNext();
			// prev used to hold the reference of node smaller than curr
			ListNode<Integer> prev = dummy;
			// nxt used to hold the reference of node greater than curr
			ListNode<Integer> nxt = dummy.getNext();
			
			while(nxt != null) {
				
				// if nxt's data greater than curr's data
				// come out of the loop
				// to simply update pointers for next curr
				if(nxt.getData() > curr.getData()) 
					break;
				
				// if not greater, keep on going
				// through nodes until greater element is found
				// or nxt reaches null
				prev = nxt;
				nxt = nxt.getNext();
			}
			
			// putting curr at appropriate position
			// (between smaller and greater element)
			curr.setNext(nxt);
			prev.setNext(curr);
			
			// advancing curr, to sort its next node now
			curr = temp;
			
		}
		
		return dummy.getNext();  // since actual list starts after dummy node
	}
		
	public static void main(String[] args) {
		_2_l_InsertionSortInLinkedList mainClass = new _2_l_InsertionSortInLinkedList();

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
		ll.insertAtEnd(2);
		System.out.println(ll.toString());
		ll.insertAtEnd(14);
		System.out.println(ll.toString());
		ll.insertAtEnd(13);
		System.out.println(ll.toString());
		ll.insertAtEnd(9);
		System.out.println(ll.toString());
		ll.insertAtEnd(18);
		System.out.println(ll.toString());
		ll.insertAtEnd(17);
		System.out.println(ll.toString());
		ll.insertAtEnd(19);
		System.out.println(ll.toString());
		ll.insertAtEnd(12);
		System.out.println(ll.toString());
	
		ListNode<Integer> newHead = mainClass.doInsertionSort(ll.getHead());
		System.out.println("Sorted List : " + ll.toString(newHead));
	}

}
