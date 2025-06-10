package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _1_j_MergePointInTwoLinkedLists_BruteForce<T> {

	public ListNode<T> mergePointInTwoLinkedLists(ListNode<T> h1, ListNode<T> h2) {
		while(h2 != null) {
			ListNode<T> temp = h1;
			while(temp != null) {
				if(temp == h2) {
					return h2;
				}
				temp = temp.getNext();
			}
			h2 = h2.getNext();
		}
		return null;
	}

	public static void main(String[] args) {
		_1_k_MergePointInTwoLinkedLists_UsingHashing<Integer> mainClass = new _1_k_MergePointInTwoLinkedLists_UsingHashing<>();
		LinkedList<Integer> listRef = new LinkedList<>();
		
		ListNode<Integer> h1 = new ListNode<Integer>(2);
		ListNode<Integer> n2 = new ListNode<Integer>(3);
		ListNode<Integer> n3 = new ListNode<Integer>(4);
		ListNode<Integer> n4 = new ListNode<Integer>(5);
		ListNode<Integer> n5 = new ListNode<Integer>(6);
		ListNode<Integer> n6 = new ListNode<Integer>(7);
		
		h1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(null);
		
		ListNode<Integer> h2 = new ListNode<Integer>(8);
		ListNode<Integer> nn2 = new ListNode<Integer>(9);
		ListNode<Integer> nn3 = new ListNode<Integer>(10);
		
		h2.setNext(nn2);
		nn2.setNext(nn3);
		nn3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(null);
		
		System.out.println("List 1 :" + listRef.toString(h1));
		System.out.println("List 2 :" + listRef.toString(h2));
		
		System.out.println("Merge point: " + mainClass.mergePointInTwoLinkedLists(h1, h2).getData());
	}

}
