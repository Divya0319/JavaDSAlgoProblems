package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_n_RotateLinkedListLeftByKPlaces<T> {
	
	public ListNode<T> rotateListLeft(ListNode<T> head, int k) {
		
		// invalid value of k
		if(k < 1 || head == null) {
			return head;
		}
		
		ListNode<T> curr = head;
		int n = 0;
		
		// this loop calculates list length
		while(curr != null) {
			curr = curr.getNext();
			n++;
		}
		
		// when k is greater than n
		// then taking modulo with list length
		// prevents unnecessary rotation
		k = k % n;
		
		curr = head;
		
		int count = 1;
		
		// this loop finds kth node from start
		while(count < k && curr != null) {
			curr = curr.getNext();
			count++;
		}
		
		// storing kth node for later use
		ListNode<T> kthNode = curr;
		
		// going to last node of list
		while(curr.getNext() != null) {
			curr = curr.getNext();
		}
		
		// pointing last node to head
		curr.setNext(head);
		
		// making (k+1)th node from start as head
		head = kthNode.getNext();
		
		// breaking link from kth to (k+1)th node
		kthNode.setNext(null);
		
		return head;
	}
		
	public static void main(String[] args) {
		_2_n_RotateLinkedListLeftByKPlaces<Integer> mainClass = new _2_n_RotateLinkedListLeftByKPlaces<>();

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
		ListNode<Integer> newHead = mainClass.rotateListLeft(ll.getHead(), k);
		System.out.println("Rotated List left by " + k + " places : " + ll.toString(newHead));
	}

}
