package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_k_ReorderingLinkedList_NoExtraSpace<T> {
	
	public ListNode<T> reorderList(ListNode<T> head) {
		
		if(head == null) return null;
		
		ListNode<T> slow = head, fast = head;
		ListNode<T> origHead = head;
		while(fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		ListNode<T> prev = null, curr = slow, temp;
		while(curr != null) {
			temp = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = temp;
		}
		
		ListNode<T> n1 = head, n2 = prev;
		while(n2.getNext() != null) {
			temp = n1.getNext();
			n1.setNext(n2);
			n1 = temp;
			temp = n2.getNext();
			n2.setNext(n1);
			n2 = temp;
		}
		
		return origHead;
	}
		
	public static void main(String[] args) {
		_2_k_ReorderingLinkedList_NoExtraSpace<Character> mainClass = new _2_k_ReorderingLinkedList_NoExtraSpace<>();

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
