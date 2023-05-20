package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_m_RotateLinkedListRightByKPlaces<T> {
	
	public ListNode<T> rotateListRight(ListNode<T> head, int k) {
		
		// invalid value of k
		if(k < 1 || head == null) {
			return head;
		}
		
		ListNode<T> temp = head;
		int n = 0;
		
		// this loop runs just to get to last element of list
		// and calculate list length while doing so
		while(temp.getNext() != null) {
			temp = temp.getNext();
			n++;
		}
		
		
		// make last node connect to head
		temp.setNext(head);
		
		// n reaches 1 less than size of linked list, so n+1
		// when k is greater than size of linked list
		// then taking modulo with list length
		// prevents unnecessary rotation
		k = k % (n+1);
		
		temp = head;
		
		// jumps needed to go to resulting last node of the list
		int jumps = n - k;
		
		while(jumps > 0) {
			temp = temp.getNext();
			
			// at the end, jump will become zero
			// and loop break,
			// but before that, temp has moved to last node of resulting list
			// before breaking loop condition
			jumps--;
		}
		
		// New head is actually next to last node
		ListNode<T> newHead = temp.getNext();
		
		// Next of last node is made null now
		temp.setNext(null);
		
		return newHead;
	}
		
	public static void main(String[] args) {
		_2_m_RotateLinkedListRightByKPlaces<Integer> mainClass = new _2_m_RotateLinkedListRightByKPlaces<>();

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
	
		int k = 5;
		ListNode<Integer> newHead = mainClass.rotateListRight(ll.getHead(), k);
		System.out.println("Rotated List right by " + k + " places : " + ll.toString(newHead));
	}

}
