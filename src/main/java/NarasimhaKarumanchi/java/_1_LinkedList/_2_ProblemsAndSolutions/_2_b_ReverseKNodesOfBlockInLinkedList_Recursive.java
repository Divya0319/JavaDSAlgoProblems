package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_b_ReverseKNodesOfBlockInLinkedList_Recursive<T> {

	public ListNode<T> reverseKNodes(ListNode<T> head, int k) {
		
		if(head == null || k == 1) return head;
				
		ListNode<T> curr = head, next = null, prev = null;
		int count = 0;
		
		while(count < k && curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next != null) {
			head.setNext(reverseKNodes(next, k));
		}
		
		return prev;

	}

	public static void main(String[] args) {
		_2_b_ReverseKNodesOfBlockInLinkedList_Recursive<Integer> mainClass = new _2_b_ReverseKNodesOfBlockInLinkedList_Recursive<>();
		LinkedList<Integer> ll = new LinkedList<>();
		ll.insertAtBegin(1);
		System.out.println(ll.toString());
		ll.insertAtEnd(2);
		System.out.println(ll.toString());
		ll.insertAtEnd(3);
		System.out.println(ll.toString());
		ll.insertAtEnd(4);
		System.out.println(ll.toString());
		ll.insertAtEnd(5);
		System.out.println(ll.toString());
		ll.insertAtEnd(6);
		System.out.println(ll.toString());
		ll.insertAtEnd(7);
		System.out.println(ll.toString());
		ll.insertAtEnd(8);
		System.out.println(ll.toString());
		ll.insertAtEnd(9);
		System.out.println(ll.toString());
		int k = 3;
		ListNode<Integer> exchangedList = mainClass.reverseKNodes(ll.getHead(), k);
		System.out.println("Linked list after reversing " + k + " blocks of nodes: " + ll.toString(exchangedList));

	}

}
