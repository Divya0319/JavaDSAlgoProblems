package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;


import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _1_w_ReverseInPairInLinkedList_Iterative_No_data_swapping<T> {

	public ListNode<T> reverseInPair(ListNode<T> head) {
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
		_1_w_ReverseInPairInLinkedList_Iterative_No_data_swapping<Integer> mainClass = new _1_w_ReverseInPairInLinkedList_Iterative_No_data_swapping<>();
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
		System.out.println("Pairwise Reversed List: " + ll.toString(reversedList));
	}

}
