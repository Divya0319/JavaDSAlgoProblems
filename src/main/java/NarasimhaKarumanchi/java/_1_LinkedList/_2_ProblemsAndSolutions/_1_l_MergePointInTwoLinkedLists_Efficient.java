package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;


import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_l_MergePointInTwoLinkedLists_Efficient<T> {

	public ListNode<T> mergePointInTwoLinkedLists(ListNode<T> h1, ListNode<T> h2) {
		int len1 = 0, len2 = 0, diff = 0;
		ListNode<T> head1 = h1, head2 = h2;
		while(head1 != null) {
			len1++;
			head1 = head1.getNext();
		}
		while(head2 != null) {
			len2++;
			head2 = head2.getNext();
		}
		
		if(len1 < len2) {
			head1 = h2;
			head2 = h1;
			diff = len2 - len1;
		} else {
			head1 = h1;
			head2 = h2;
			diff = len1-len2;
		}
		
		for(int i = 0; i < diff; i++) {
			head1 = head1.getNext();
		}
		
		while(head1 != null && head2 != null) {
			if(head1 == head2) {
				return head1;
			}
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
		
		return null;
	}

	public static void main(String[] args) {
		
	}

}
