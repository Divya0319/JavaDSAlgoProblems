package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _2_a_ReverseKNodesOfBlockInLinkedList_Iterative<T> {

	public ListNode<T> reverseKNodes(ListNode<T> head, int k) {
		
		 
		if(head == null || k == 1) return head;
				
		ListNode<T> dummy = new ListNode<>((T)new Integer(0));
		dummy.setNext(head);
		
		ListNode<T> curr = dummy, nex = dummy, pre = dummy;
		int count = 0;
		
		// counting number of nodes in list
		while(curr.getNext() != null) {
			curr = curr.getNext();
			count++;
		}
		
		while(count >= k) {
			
			// making sure that curr is standing
			// at first node of any group of size k
			// and nex is standing at second node of 
			// any group of size k
			curr = pre.getNext();
			nex = curr.getNext();
			
			// if k is given, there will be k-1 operations
			// we need to perform
			// because there will be k-1 links we need to reverse
			for(int i = 1; i < k; i++) {
				curr.setNext(nex.getNext());
				nex.setNext(pre.getNext());
				pre.setNext(nex);
				nex = curr.getNext();
			}
			
			// making sure that pre is moved to last node
			// of previous reversed group of size k
			pre = curr;
			
			// after every k nodes reversal
			// count gets decreased by k
			count -= k;
		}
		

		return dummy.getNext();
	}

	public static void main(String[] args) {
		_2_a_ReverseKNodesOfBlockInLinkedList_Iterative<Integer> mainClass = new _2_a_ReverseKNodesOfBlockInLinkedList_Iterative<>();
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
		 
		int k = 5;
		ListNode<Integer> exchangedList = mainClass.reverseKNodes(ll.getHead(), k);
		System.out.println("Linked list after reversing " + k + " blocks of nodes: " + ll.toString(exchangedList));

	}

}
