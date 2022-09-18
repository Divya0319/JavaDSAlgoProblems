package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import java.util.HashMap;
import java.util.Map;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_r_RemoveDuplicatesFromUnorderedLinkedList_UsingHashing {
	
	public ListNode<Integer> removeDupUsingHashmap(ListNode<Integer> head) {
		if(head == null)
			return null;
		
		// Creating a hashmap which will hold
		// Integer value of linked list node data
		Map<Integer, Integer> map = new HashMap<>();
		
		// curr will supply value for comparison
		// with hashmap
		ListNode<Integer> curr = head;
		
		// prev will hold any time
		// node previous to current node
		ListNode<Integer> prev = head;
		
		// Initially, head's data is stored in map
		map.put(curr.getData(), 1);
		
		// and curr advanced to second node
		curr = curr.getNext();
		while(curr != null) {
			
			// if hashmap already contains data of node
			// then we update reference of previous node
			// to next of current node
			if(map.containsKey(curr.getData())) {
				prev.setNext(curr.getNext());
			} else {
				
				// else, we put that node's data to map
				// and update previous node pointer to current node
				map.put(curr.getData(), 1);
				prev = curr;
			}
			
			curr = prev.getNext();
		}
		
		return head;
	}
		
	public static void main(String[] args) {
		_2_r_RemoveDuplicatesFromUnorderedLinkedList_UsingHashing mainClass = new _2_r_RemoveDuplicatesFromUnorderedLinkedList_UsingHashing();

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
	
		mainClass.removeDupUsingHashmap(ll.getHead());
		System.out.println("Linked List with no duplicates: " + ll.toString());
	}

}
