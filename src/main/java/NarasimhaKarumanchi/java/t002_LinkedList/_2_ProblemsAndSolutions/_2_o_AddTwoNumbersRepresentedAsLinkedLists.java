package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _2_o_AddTwoNumbersRepresentedAsLinkedLists {
	
	public ListNode<Integer> addTwoLinkedLists(ListNode<Integer> head1, ListNode<Integer> head2) {
		
		head1 = reverse(head1);
		head2 = reverse(head2);
		
		ListNode<Integer> ans = add(head1, head2);
		
		ans = reverse(ans);
		
		return ans;
	}
	
	private ListNode<Integer> add(ListNode<Integer> head1, ListNode<Integer> head2) {
		
		int carry = 0;
		
		ListNode<Integer> dummy = new ListNode<>(-1);
		
		ListNode<Integer> temp = dummy;
		
		while(head1 != null || head2 != null || carry != 0) {
			int val1 = 0;
			
			if(head1 != null) {
				val1 = head1.getData();
			}
			
			int val2 = 0;
			
			if(head2 != null) {
				val2 = head2.getData();
			}
			
			int sum = val1 + val2 + carry;
			
			int digit = sum % 10;
			
			ListNode<Integer> sumNode = new ListNode<>(digit);
			
			temp.setNext(sumNode);
			
			temp = sumNode;
			
			carry = sum / 10;
			
			if(head1 != null)
				head1 = head1.getNext();
			if(head2 != null)
				head2 = head2.getNext();
			
		}
		
		return dummy.getNext();
	}
	
	private ListNode<Integer> reverse(ListNode<Integer> head) {
		ListNode<Integer> curr = head, prev = null;
		
		while(curr != null) {
			ListNode<Integer> next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	
		
	public static void main(String[] args) {
		_2_o_AddTwoNumbersRepresentedAsLinkedLists mainClass = new _2_o_AddTwoNumbersRepresentedAsLinkedLists();

		LinkedList<Integer> ll1 = new LinkedList<>();
		ll1.insertAtBegin(3);
		ll1.insertAtEnd(7);
		ll1.insertAtEnd(8);
		System.out.println(ll1.toString());
		
		LinkedList<Integer> ll2 = new LinkedList<>();
		ll2.insertAtBegin(7);
		ll2.insertAtEnd(1);
		ll2.insertAtEnd(6);
		System.out.println(ll2.toString());
		
	
		ListNode<Integer> sumList = mainClass.addTwoLinkedLists(ll1.getHead(), ll2.getHead());
		System.out.println("Sum Linked List : " + ll1.toString(sumList));
	}

}
