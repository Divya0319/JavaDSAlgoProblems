package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_FindMiddleOfLinkedList<T> {

	public ListNode<T> findMiddle(ListNode<T> head) {
		ListNode<T> ptr1, ptr2;
		ptr1 = ptr2 = head;
		while (ptr1 != null && ptr1.getNext() != null) {
			ptr1 = ptr1.getNext().getNext();
			ptr2 = ptr2.getNext();
		}

		return ptr2;

	}

	public static void main(String[] args) {
		_1_FindMiddleOfLinkedList<Integer> mainClass = new _1_FindMiddleOfLinkedList<>();
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
