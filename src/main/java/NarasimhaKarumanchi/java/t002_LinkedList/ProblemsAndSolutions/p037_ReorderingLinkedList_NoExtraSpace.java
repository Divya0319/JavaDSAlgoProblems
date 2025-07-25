package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class p037_ReorderingLinkedList_NoExtraSpace<T> {
	
	public ListNode<T> reorderList(ListNode<T> head) {
		
		if(head == null) return null;
		
		ListNode<T> slow = head, fast = head;
		ListNode<T> origHead = head;
		
		// finding middle of list here.
		// slow holds middle
		while(fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		
		// reversing second part of list, after middle
		ListNode<T> prev = null, curr = slow, temp;
		while(curr != null) {
			temp = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = temp;
			
			// At the end of this loop,
			// prev will hold head of reversed part
		}
		
		
		ListNode<T> n1 = head, n2 = prev;
		
		// doing merging of both halves one by one
		while(n2.getNext() != null) {
			
			// 1st node from 1st half, 
			// to 1st node of reversed half
			temp = n1.getNext();  // storing next to be considered node of first half
			n1.setNext(n2);      // joining first node of 1st half to last node of second half
			n1 = temp;          // advancing pointer of first half
			
			// then 1st node of reversed half
			// to 2nd node of first half,
			// and so on
			temp = n2.getNext(); // storing next to be considered node of reversed second half
			n2.setNext(n1);     // joining last node of second half to second node of first half 
			n2 = temp;         // advancing pointer of first half
		}
		
		
		// original head is returned at the end
		return head;
	}
		
	public static void main(String[] args) {
		p037_ReorderingLinkedList_NoExtraSpace<Character> mainClass = new p037_ReorderingLinkedList_NoExtraSpace<>();

		LinkedList<Character> ll = new LinkedList<>();
		ll.insertAtBegin('a');
		System.out.println(ll.toString());
		ll.insertAtEnd('b');
		System.out.println(ll.toString());
		ll.insertAtEnd('c');
		System.out.println(ll.toString());
		ll.insertAtEnd('d');
		System.out.println(ll.toString());
		ll.insertAtEnd('e');
		System.out.println(ll.toString());
		ll.insertAtEnd('f');
		System.out.println(ll.toString());
		ll.insertAtEnd('g');
		System.out.println(ll.toString());
		ll.insertAtEnd('h');
		System.out.println(ll.toString());
		ll.insertAtEnd('i');
		System.out.println(ll.toString());
		ll.insertAtEnd('j');
		System.out.println(ll.toString());
		ll.insertAtEnd('k');
		System.out.println(ll.toString());
		ll.insertAtEnd('l');
		System.out.println(ll.toString());
		ll.insertAtEnd('m');
		System.out.println(ll.toString());
		ll.insertAtEnd('n');
		System.out.println(ll.toString());
		ll.insertAtEnd('o');
		System.out.println(ll.toString());
		ll.insertAtEnd('p');
		System.out.println(ll.toString());
		ll.insertAtEnd('q');
		System.out.println(ll.toString());
		ll.insertAtEnd('r');
		System.out.println(ll.toString());
		
		
		mainClass.reorderList(ll.getHead());
		System.out.println("Reordered List : " + ll.toString());
	}

}
