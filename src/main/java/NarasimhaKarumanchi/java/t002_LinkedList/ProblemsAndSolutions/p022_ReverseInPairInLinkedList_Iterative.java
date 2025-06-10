package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;


import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class p022_ReverseInPairInLinkedList_Iterative<T> {

	public ListNode<T> reverseInPair(ListNode<T> head) {
		ListNode<T> temp = head;
		
		/* next of temp or temp itself shouldn't be null 
		 * otherwise data can't be fetched
		 */
		while(temp != null && temp.getNext() != null) {
			
			// store data of temp temporarily
			T k = temp.getData();
			
			// swap temp's data with its next data
			temp.setData(temp.getNext().getData());
			temp.getNext().setData(k);
			
			// advance temp two pointers forward
			temp = temp.getNext().getNext();
		}
		
		return head;
	}

	public static void main(String[] args) {
		p022_ReverseInPairInLinkedList_Iterative<Integer> mainClass = new p022_ReverseInPairInLinkedList_Iterative<>();
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
