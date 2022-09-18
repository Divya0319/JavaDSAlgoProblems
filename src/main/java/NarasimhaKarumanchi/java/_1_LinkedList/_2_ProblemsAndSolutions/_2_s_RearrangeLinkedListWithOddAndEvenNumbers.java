package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_s_RearrangeLinkedListWithOddAndEvenNumbers {
	
	public ListNode<Integer> reArrangeEvenOddInList(ListNode<Integer> head) {
		
		// even pointer will point to starting of even nodes
		// and odd pointer will point to starting of odd nodes
		ListNode<Integer> even = null, odd = null;
		
		// e and o are used as a handle to generate segregated even and odd nodes
		// in resulting linked list
		ListNode<Integer> e = null, o = null;
		
		while(head != null) {
			if(head.getData() % 2 == 0) {
				
				// if data is even
				// and this is first even node
				if(even == null) {
					
					// updating even pointer
					even = head;
					// updating e pointer to start after head  
					// next time
					e = head;
				} else {
					
					// even nodes are already present, then
					// add current even node after previously
					// present last even node
					e.setNext(head);
					
					// updating e pointer to this
					// newly added even node
					e = e.getNext();
				}
			} 
			
			// if data is odd
			// and this is first odd node
			else {
				if(odd == null) {
					// updating odd pointer
					odd = head;
					// updating o pointer to start after head  
					// next time
					o = head;
				} else {
					
					// odd nodes are already present, then
					// add current odd node after previously
					// present last odd node
					o.setNext(head);
					
					// updating o pointer to this
					// newly added odd node
					o = o.getNext();
				}
			}
			
			// advancing head
			// to go to next node of
			// given linked list
			head = head.getNext();
		}
		
		
		// if there is at least
		// one even node in given list
		if(e != null) {
			
			// join odd node head
			// after last even node
			e.setNext(odd);
		}
		
		// if there is at least
		// one odd node in given list
		if(o != null) {
			
			// set last even node's next as null
			o.setNext(null);
		}
		
		
		// if at least one even node is there in result
		// return starting node of even nodes
		if(even != null) 
			return even;
		
		// else return starting node of odd nodes
		return odd;
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
