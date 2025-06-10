package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class p028_ReverseKNodesOfBlockInLinkedList_Recursive<T> {
	
	/*
	 * We are solving reverse problem for 1st group of size k(using iterative reverse algo)
	 * until count < k ---> it reverses first k nodes
	 * and calling recursion for rest of the groups
	 * 
	 * For next part, we do
	 * head.next = recursion output
	 * 
	 * return head of reversed linked list ---> prev
	 */

	public ListNode<T> reverseKNodes(ListNode<T> head, int k) {
		
		if(head == null || k == 1) return head;
				
		ListNode<T> curr = head, next = null, prev = null;
		int count = 0;
		
		// reversing only starting k nodes
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
		p028_ReverseKNodesOfBlockInLinkedList_Recursive<Integer> mainClass = new p028_ReverseKNodesOfBlockInLinkedList_Recursive<>();
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
		ll.insertAtEnd(10);
		System.out.println(ll.toString());
		int k = 4;
		ListNode<Integer> exchangedList = mainClass.reverseKNodes(ll.getHead(), k);
		System.out.println("Linked list after reversing " + k + " blocks of nodes: " + ll.toString(exchangedList));

	}

}
