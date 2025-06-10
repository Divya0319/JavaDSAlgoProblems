package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;


import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _1_m_FindMiddleOfLinkedList_BruteForce<T> {

	public ListNode<T> findMiddleOfLinkedList(ListNode<T> head) {
		int len = 0;
		ListNode<T> temp = head;
		while(temp != null) {
			temp = temp.getNext();
			len++;
		}
		
		temp = head;
		
		for(int i = 0; i < len/2; i++) {
			temp = temp.getNext();
		}
		
		return temp;
		
	}

	public static void main(String[] args) {
		_1_m_FindMiddleOfLinkedList_BruteForce<Integer> mainClass = new _1_m_FindMiddleOfLinkedList_BruteForce<>();
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
