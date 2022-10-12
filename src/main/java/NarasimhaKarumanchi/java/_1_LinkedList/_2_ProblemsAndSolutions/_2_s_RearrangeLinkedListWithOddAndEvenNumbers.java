package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_s_RearrangeLinkedListWithOddAndEvenNumbers {
	
	public ListNode<Integer> reArrangeEvenOddInList(ListNode<Integer> head) {
		
		// even pointer will point to starting of even nodes
		// and odd pointer will point to starting of odd nodes
		ListNode<Integer> even = new ListNode<>(-1);
		ListNode<Integer> odd = new ListNode<>(-1);
		
		// e and o are used as a handle to generate segregated even and odd nodes
		// in resulting linked list
		ListNode<Integer> e = even, o = odd;
		
		while(head != null) {
			if(head.getData() % 2 == 0) {
				
					// add current even node after previously
					// present last even node
					e.setNext(head);
					
					// updating e pointer to this
					// newly added even node
					e = e.getNext();
				
			} else {
				 
					// add current odd node after previously
					// present last odd node
					o.setNext(head);
					
					// updating o pointer to this
					// newly added odd node
					o = o.getNext();
				
			}
			
			// advancing head
			// to go to next node of
			// given linked list
			head = head.getNext();
		}
		
		
		// if there is at least
		// one even node in given list
		if(even.getNext() != null) {
			
			// join odd node head
			// after last even node
			e.setNext(odd.getNext());
		}
		
		// if there is at least
		// one odd node in given list
		if(odd.getNext() != null) {
			
			// set last even node's next as null
			o.setNext(null);
		}
		
		
		// if at least one even node is there in result
		// return starting node of even nodes
		if(even.getNext() != null) 
			return even.getNext();
		
		// else return starting node of odd nodes
		return odd.getNext();
	}
		
	public static void main(String[] args) {
		_2_s_RearrangeLinkedListWithOddAndEvenNumbers mainClass = new _2_s_RearrangeLinkedListWithOddAndEvenNumbers();

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
	
		ListNode<Integer> rearrangedList = mainClass.reArrangeEvenOddInList(ll.getHead());
		System.out.println("Linked List with no duplicates: " + ll.toString(rearrangedList));
	}

}
