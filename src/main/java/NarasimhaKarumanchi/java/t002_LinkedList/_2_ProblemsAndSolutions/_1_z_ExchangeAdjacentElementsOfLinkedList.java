package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _1_z_ExchangeAdjacentElementsOfLinkedList<T> {

	public ListNode<T> exchangeAdjacentElements(ListNode<T> head) {
		
		ListNode<T> p, newHead;
		p = head;
		newHead = p.getNext();
		while(true) {
			ListNode<T> q = p.getNext();
			//temp node should always be
			// node present next to the second node
			// of current pair being considered
			ListNode<T> temp = q.getNext();
			
			//Reversing starts from here
			q.setNext(p);
			if(temp == null || temp.getNext() == null) {
				p.setNext(temp);
				break;
			}
			
			p.setNext(temp.getNext());
			p = temp;
			
		}
		
		return newHead;

	}

	public static void main(String[] args) {
		_1_z_ExchangeAdjacentElementsOfLinkedList<Integer> mainClass = new _1_z_ExchangeAdjacentElementsOfLinkedList<>();
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
		 
		ListNode<Integer> exchangedList = mainClass.exchangeAdjacentElements(ll.getHead());
		System.out.println("Linked list after exchanging adjacent elements: " + ll.toString(exchangedList));

	}

}
