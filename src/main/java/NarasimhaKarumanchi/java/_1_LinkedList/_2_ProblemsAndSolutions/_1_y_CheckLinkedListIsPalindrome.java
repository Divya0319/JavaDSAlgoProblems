package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_y_CheckLinkedListIsPalindrome {
	
	public ListNode<Integer> findMiddle(ListNode<Integer> head) {
		ListNode<Integer> fast = head, slow = head;
		
		while(fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		
		return slow;
	}
	
	public ListNode<Integer> reverse(ListNode<Integer> head) {
		if(head == null) {
			return null;
		}
		
		//Initially, current is head
		ListNode<Integer> current = head;
		//Initially previous is null
		ListNode<Integer> prev = null;
		while(current != null) {
			ListNode<Integer> next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
		
	}

	public boolean isLinkedListPalindrome(ListNode<Integer> head) {
		
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
		
		ListNode<Integer> middle = findMiddle(head);
		ListNode<Integer> last = reverse(middle.getNext());
		
		ListNode<Integer> current = head;
		
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
		_1_y_CheckLinkedListIsPalindrome mainClass = new _1_y_CheckLinkedListIsPalindrome();
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
