package main.java.NarasimhaKarumanchi.java;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class Test<T> {
	
	
	public ListNode<T> rotateListByKPlaces(ListNode<T> head, int k) {
		
		int n = 0;
		
		ListNode<T> temp = head;
		
		while(temp.getNext() != null) {
			temp = temp.getNext();
			n++;
		}
		
		temp.setNext(head);
		
		k = k % (n+1);
		
		temp = head;
		
		int jumps = n - k;
		
		while(jumps > 0) {
			temp = temp.getNext();
			jumps--;
		}
		
		ListNode<T> newHead = temp.getNext();
		temp.setNext(null);
		
		return newHead;
		
	}
	
	

	public static void main(String[] args) {
		Test<Integer> mainClass = new Test<>();
				
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
	
		ListNode<Integer> newHead = mainClass.rotateListByKPlaces(ll.getHead(), 5);
		System.out.println("Rotated List by 5 places : " + ll.toString(newHead));
		

	}

}
