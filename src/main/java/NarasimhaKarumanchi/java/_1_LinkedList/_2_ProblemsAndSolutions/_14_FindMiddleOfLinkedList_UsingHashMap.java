package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;


import java.util.HashMap;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _14_FindMiddleOfLinkedList_UsingHashMap<T> {

	public ListNode<T> findMiddleOfLinkedList(ListNode<T> head) {
		int len = 0;
		HashMap<Integer, ListNode<T>> hm = new HashMap<>();
		
		ListNode<T> temp = head;
		while(temp != null) {
			hm.put(len++, temp);
			temp = temp.getNext();
		}
		
		ListNode<T> middleNode = hm.get(len/2);
		return middleNode;
		
	}

	public static void main(String[] args) {
		_14_FindMiddleOfLinkedList_UsingHashMap<Integer> mainClass = new _14_FindMiddleOfLinkedList_UsingHashMap<>();
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
		
		ListNode<Integer> middleNode = mainClass.findMiddleOfLinkedList(ll.getHead());
		
		System.out.println("Middle node is : "+ middleNode.getData());
	}

}
