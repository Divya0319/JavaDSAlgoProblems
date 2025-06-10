package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _1_y_CheckLinkedListIsPalindrome<T> {
	
	public ListNode<T> findMiddle(ListNode<T> head) {
		ListNode<T> fast = head, slow = head;
		
		while(fast.getNext() != null && fast.getNext().getNext() != null) { // in even list, if middle has to be first of the two nodes
		// while(fast != null && fast.getNext() != null) {	// in even list, if middle has to be second of the two nodes
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		
		return slow;
	}
	
	public ListNode<T> reverse(ListNode<T> head) {
		if(head == null) {
			return null;
		}
		
		//Initially, current is head
		ListNode<T> current = head;
		//Initially previous is null
		ListNode<T> prev = null;
		while(current != null) {
			ListNode<T> next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
		
	}

	public boolean isLinkedListPalindrome(ListNode<T> head) {
		
		// case when linked list is empty, or has 1 node only
		if(head == null || head.getNext() == null) 
			return true;
		
		// case when linked list has only 2 nodes
		if(head.getNext().getNext() == null) {
			if(head.getData() != head.getNext().getData()) {
				return false;
			} else {
				return true;
			}
		}
		
		ListNode<T> middle = findMiddle(head);
		ListNode<T> last = reverse(middle.getNext());
		
		ListNode<T> current = head;
		
		/* After reversing second half above, last node of original list 
		 * is returned, so, we increment pointer of first half,
		 * and decrement pointer of second half from end
		 * and check data of each node, as soon as we find that
		 * both data as not equal, we return false
		 */
		while(last != null) {
			if(last.getData() != current.getData()) 
				return false;
			
			last = last.getNext();
			current = current.getNext();
		}
		
		return true;

	}

	public static void main(String[] args) {
		_1_y_CheckLinkedListIsPalindrome<Integer> mainClass = new _1_y_CheckLinkedListIsPalindrome<>();
		LinkedList<Integer> ll = new LinkedList<>();
		ll.insertAtBegin(1);
		System.out.println(ll.toString());
		ll.insertAtEnd(2);
		System.out.println(ll.toString());
		ll.insertAtEnd(3);
		System.out.println(ll.toString());
		ll.insertAtEnd(4);
		System.out.println(ll.toString());
		ll.insertAtEnd(3);
		System.out.println(ll.toString());
		ll.insertAtEnd(2);
		System.out.println(ll.toString());
		ll.insertAtEnd(1);
		System.out.println(ll.toString());
		 
		System.out.println("Is Linked list palindrome?: " + mainClass.isLinkedListPalindrome(ll.getHead()));

	}

}
