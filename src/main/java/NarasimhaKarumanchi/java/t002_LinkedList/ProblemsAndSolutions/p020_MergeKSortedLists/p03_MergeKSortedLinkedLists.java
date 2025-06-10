package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions.p020_MergeKSortedLists;


import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class p03_MergeKSortedLinkedLists<T> {

	public ListNode<Integer> mergeKSortedLinkedLists(ListNode<Integer>[] lists, int si, int ei) {
		if(si > ei) return null;
		if(si == ei) return lists[si];
		int mid = (si + ei) / 2;
		
		ListNode<Integer> l1 = mergeKSortedLinkedLists(lists, si, mid);
		ListNode<Integer> l2 = mergeKSortedLinkedLists(lists, mid + 1, ei);
				
		return merge2SortedLists(l1, l2);
		
	}
	
	public ListNode<Integer> mergeKSortedLinkedLists(ListNode<Integer>[] lists) {
		
		if(lists.length == 0) return null;
		
		return mergeKSortedLinkedLists(lists, 0, lists.length - 1);
	}
	
	public ListNode<Integer> merge2SortedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
		
		ListNode<Integer> dummy = new ListNode<>(-1);
		ListNode<Integer> prev = dummy, c1 = l1, c2 = l2;
		
		while(c1 != null && c2 != null) {
			if(c1.getData() <= c2.getData()) {
				prev.setNext(c1);
				c1 = c1.getNext();
			} else {
				prev.setNext(c2);
				c2 = c2.getNext();
			}
			
			prev = prev.getNext();
		}
		
		prev.setNext(c1 != null ? c1 : c2);
		
		return dummy.getNext();
	}

	public static void main(String[] args) {
		p03_MergeKSortedLinkedLists<Integer> mainClass = new p03_MergeKSortedLinkedLists<>();
		LinkedList<Integer> l1 = new LinkedList<>();
		l1.insertAtBegin(1);
		System.out.println(l1.toString());
		l1.insertAtEnd(2);
		System.out.println(l1.toString());
		l1.insertAtEnd(3);
		System.out.println(l1.toString());
		l1.insertAtEnd(4);
		System.out.println(l1.toString());
		l1.insertAtEnd(19);
		System.out.println(l1.toString());
		l1.insertAtEnd(22);
		System.out.println(l1.toString());
		l1.insertAtEnd(24);
		System.out.println(l1.toString());
		l1.insertAtEnd(56);
		System.out.println("First List:");
		System.out.println(l1.toString());
		
		LinkedList<Integer> l2 = new LinkedList<>();
		l2.insertAtBegin(5);
		System.out.println(l2.toString());
		l2.insertAtEnd(6);
		System.out.println(l2.toString());
		l2.insertAtEnd(7);
		System.out.println(l2.toString());
		l2.insertAtEnd(8);
		System.out.println(l2.toString());
		l2.insertAtEnd(20);
		System.out.println(l2.toString());
		l2.insertAtEnd(23);
		System.out.println(l2.toString());
		l2.insertAtEnd(25);
		System.out.println(l2.toString());
		l2.insertAtEnd(57);
		System.out.println("Second List:");
		System.out.println(l2.toString());
		
		LinkedList<Integer> l3 = new LinkedList<>();
		l3.insertAtBegin(9);
		System.out.println(l3.toString());
		l3.insertAtEnd(10);
		System.out.println(l3.toString());
		l3.insertAtEnd(11);
		System.out.println(l3.toString());
		l3.insertAtEnd(12);
		System.out.println(l3.toString());
		l3.insertAtEnd(21);
		System.out.println(l3.toString());
		l3.insertAtEnd(22);
		System.out.println(l3.toString());
		l3.insertAtEnd(26);
		System.out.println(l3.toString());
		l3.insertAtEnd(58);
		System.out.println("Third List:");
		System.out.println(l3.toString());
		ListNode<Integer>[] lists = new ListNode[] {l1.getHead(), l2.getHead(), l3.getHead()};
		
		ListNode<Integer> mergedList = mainClass.mergeKSortedLinkedLists(lists);
		System.out.println("Merged List: " + l1.toString(mergedList));
	}

}
