package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class p015_FindMiddleOfLinkedList_UsingTwoPointers<T> {

	public ListNode<T> findMiddle(ListNode<T> head) {
		
		// declaring two pointers, out of which
		// one will travel twice as fast as other
		ListNode<T> ptr1, ptr2;
		ptr1 = ptr2 = head;
		
		// when fast pointer or its next becomes null
		// slow pointer will be at middle of list
		while (ptr1 != null && ptr1.getNext() != null) {
			ptr1 = ptr1.getNext().getNext();
			ptr2 = ptr2.getNext();
		}

		return ptr2;

	}

	public static void main(String[] args) {
		p015_FindMiddleOfLinkedList_UsingTwoPointers<Integer> mainClass = new p015_FindMiddleOfLinkedList_UsingTwoPointers<>();
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

		ListNode<Integer> middle = mainClass.findMiddle(ll.getHead());
		System.out.println(middle.getData());
	}

}
