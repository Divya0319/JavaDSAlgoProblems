package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import java.util.HashSet;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_k_MergePointInTwoLinkedLists_UsingHashing<T> {

	public ListNode<T> mergePointInTwoLinkedLists(ListNode<T> h1, ListNode<T> h2) {
		HashSet<ListNode<T>> hs = new HashSet<>();
		while(h1 != null) {
			hs.add(h1);
			h1 = h1.getNext();
		}
		
		while(h2 != null) {
			if(hs.contains(h2)) {
				return h2;
			}
			h2 = h2.getNext();
		}
		
		return null;
	}

	public static void main(String[] args) {
		
	}

}
