package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;


import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_s_MergeTwoSortedLinkedLists_Recursive<T> {

	public ListNode<Integer> mergeTwoSortedLinkedLists(ListNode<Integer> head1, ListNode<Integer> head2) {
		if(head1 == null)
			return head2;
		if(head2 == null) 
			return head1;
		ListNode<Integer> head = new ListNode<>(0);
		if(head1.getData() <= head2.getData()) {
			head = head1;
			head.setNext(mergeTwoSortedLinkedLists(head1.getNext(), head2));
		}
		else {
			head = head2;
			head.setNext(mergeTwoSortedLinkedLists(head2.getNext(), head1));
		}

		return head;
	}

	public static void main(String[] args) {
		_1_s_MergeTwoSortedLinkedLists_Recursive<Integer> mainClass = new _1_s_MergeTwoSortedLinkedLists_Recursive<>();
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
		System.out.println("First List:");
		System.out.println(ll.toString());
		
		ListNode<Integer> headL2 = new ListNode<>(11);
		ListNode<Integer> n1 = new ListNode<>(12);
		headL2.setNext(n1);
		ListNode<Integer> n2 = new ListNode<>(23);
		n1.setNext(n2);
		n2.setNext(null);
		
		System.out.println("Second List: ");
		System.out.println(ll.toString(headL2));
		
		ListNode<Integer> mergedList = mainClass.mergeTwoSortedLinkedLists(ll.getHead(), headL2);
		System.out.println("Merged List: " + ll.toString(mergedList));
	}

}
