package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;


import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class p021_ReverseInPairInLinkedList_Recursive<T> {

	public ListNode<T> reverseInPair(ListNode<T> head) {
		ListNode<T> temp;
		if(head == null || head.getNext() == null) {
			return head;    // base case for empty or 1 element list
		}
		else {
			// Reverse first pair
			temp = head.getNext();
			head.setNext(temp.getNext());
			temp.setNext(head);
			head = temp;
			
			// Call the method recursively for rest of the list
			head.getNext().setNext(reverseInPair(head.getNext().getNext()));
			return head;
		}
	}

	public static void main(String[] args) {
		p021_ReverseInPairInLinkedList_Recursive<Integer> mainClass = new p021_ReverseInPairInLinkedList_Recursive<>();
		LinkedList<Integer> ll = new LinkedList<>();
		ll.insertAtBegin(1);
		System.out.println(ll.toString());
		ll.insertAtEnd(2);
		System.out.println(ll.toString());
		ll.insertAtEnd(3);
		System.out.println(ll.toString());
		ll.insertAtEnd(4);
		System.out.println(ll.toString());
		ll.insertAtEnd(19);
		System.out.println(ll.toString());
		ll.insertAtEnd(22);
		System.out.println(ll.toString());
		ll.insertAtEnd(24);
		System.out.println(ll.toString());
		ll.insertAtEnd(56);
		System.out.println(ll.toString());
		
		ListNode<Integer> reversedList = mainClass.reverseInPair(ll.getHead());
		System.out.println("Reversed List: " + ll.toString(reversedList));
	}

}
