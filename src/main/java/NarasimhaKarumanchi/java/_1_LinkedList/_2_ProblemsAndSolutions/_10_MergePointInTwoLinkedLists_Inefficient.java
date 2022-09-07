package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _10_MergePointInTwoLinkedLists_Inefficient<T> {

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
		
	}

}
