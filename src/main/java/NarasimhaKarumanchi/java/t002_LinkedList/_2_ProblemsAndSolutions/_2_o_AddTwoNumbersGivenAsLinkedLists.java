package main.java.NarasimhaKarumanchi.java.t002_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class _2_o_AddTwoNumbersGivenAsLinkedLists {
	
	public ListNode<Integer> addTwoLinkedLists(ListNode<Integer> head1, ListNode<Integer> head2) {
		
		// create a dummy node as final list will be dummy's next
		ListNode<Integer> dummy = new ListNode<Integer>(-1);
		
		// this pointer is used to generate resulting sum list
		ListNode<Integer> temp = dummy;
		int carry = 0;
		
		// until first list not over  
		// or 2nd list not over
		// or when carry is not zero, we loop the lists
		while(head1 != null || head2 != null || carry != 0) {
			// for every iteration, we reset the sum variable
			int sum = 0;
			if(head1 != null) {
				// current node of list1's data added to sum
				// and head of list1 is advanced
				sum += head1.getData();
				head1 = head1.getNext();
			}
			
			if(head2 != null) {
				// current node of list2's data added to sum
				// and head of list2 is advanced
				sum += head2.getData();
				head2 = head2.getNext();
			}
			
			// whatever value carry holds
			// from previous iteration
			// added to sum
			sum += carry;
			
			// if sum generated is of 2 digits
			// 10's place digit is set as carry
			carry = sum / 10;
			
			// and 1's place digit is passed to sum linked list
			ListNode<Integer> sumNode = new ListNode<Integer>(sum % 10);
			
			// sum node is now after temp
			temp.setNext(sumNode);
			
			// temp pointer advanced to 
			// newly created node of sum linked list
			temp = temp.getNext();
			
		}
		
		return dummy.getNext();
	}
		
	public static void main(String[] args) {
		_2_o_AddTwoNumbersGivenAsLinkedLists mainClass = new _2_o_AddTwoNumbersGivenAsLinkedLists();

		LinkedList<Integer> ll1 = new LinkedList<>();
		ll1.insertAtBegin(3);
		ll1.insertAtEnd(8);
		System.out.println(ll1.toString());
		
		LinkedList<Integer> ll2 = new LinkedList<>();
		ll2.insertAtBegin(7);
		ll2.insertAtEnd(7);
		System.out.println(ll2.toString());
		
	
		ListNode<Integer> sumList = mainClass.addTwoLinkedLists(ll1.getHead(), ll2.getHead());
		System.out.println("Sum Linked List : " + ll1.toString(sumList));
	}

}
