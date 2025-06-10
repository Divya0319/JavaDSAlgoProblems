package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _2_o_MultiplyTwoNumbersRepresentedAsLinkedLists {
	
	public ListNode<Long> multiplyTwoLinkedLists(ListNode<Long> head1, ListNode<Long> head2) {
		
		long num1 = 0;
		long num2 = 0;
		long N = 1000000007;
		
		ListNode<Long> dummy = new ListNode<>(-1L);
		ListNode<Long> temp = dummy;
		
		// extracting digit by digit from first list
		while(head1 != null) {
			num1 = ((num1 * 10) % N) + head1.getData();
			head1 = head1.getNext();
		}
		
		// extracting digit by digit from second list
		while(head2 != null) {
			num2 = ((num2 * 10) % N) + head2.getData();
			head2 = head2.getNext();
		}
		
		// doing multiplication
		long res = (num1 * num2) % N;
		
		// generating linked list from res value
		while(res != 0) {
			long digit = res % 10;
			ListNode<Long> mulNode = new ListNode<>(digit);
			temp.setNext(mulNode);
			temp = mulNode;
			res = res / 10;
		}
		
		// reversing the result to get actual multiplication
		ListNode<Long> resultHead = reverse(dummy.getNext());
		
		
		return resultHead;
		
	}
	
	private ListNode<Long> reverse(ListNode<Long> head) {
		ListNode<Long> curr = head, prev = null;
		
		while(curr != null) {
			ListNode<Long> next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
		
	public static void main(String[] args) {
		_2_o_MultiplyTwoNumbersRepresentedAsLinkedLists mainClass = new _2_o_MultiplyTwoNumbersRepresentedAsLinkedLists();

		LinkedList<Long> ll1 = new LinkedList<>();
		ll1.insertAtBegin(3L);
		ll1.insertAtEnd(7L);
		System.out.println(ll1.toString());
		
		LinkedList<Long> ll2 = new LinkedList<>();
		ll2.insertAtBegin(1L);
		ll2.insertAtEnd(3L);
		System.out.println(ll2.toString());
		
	
		ListNode<Long> resultNode = mainClass.multiplyTwoLinkedLists(ll1.getHead(), ll2.getHead());
		System.out.println("Result list after multiplication is : " + ll1.toString(resultNode));
	}

}
