package main.java.NarasimhaKarumanchi.java.t003_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t003_Stacks.LinkedList;
import main.java.NarasimhaKarumanchi.java.t003_Stacks.LinkedStack;
import main.java.NarasimhaKarumanchi.java.t003_Stacks.ListNode;

public class _1_h_CheckStringGivenAsLinkedListIsPalindrome_UsingStack<T> {
	
	public boolean isPalindrome(ListNode<T> head) {
		
		// starting fast from next of head bcz
		// when checking palindrome, we have to split the list
		// so that both in case of even and odd number of nodes
		// we can compare equal number of times.
		// ** In odd no. of nodes, middle element is not compared
		// ** and in even no. of nodes, middle element is part of first half,
		// ** so, it is included in comparison.
		ListNode<T> slow = head, fast = head.getNext();
		
		
		// here, we find the middle node of list
		// slow will point to middle node
		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		ListNode<T> middle = slow;
		
		// here we are reversing the list after middle node
		// and, last will actually point to the first node
		// of reversed second half of list
		ListNode<T> last = reverseListUsingStack(middle.getNext());
		
		ListNode<T> current = head;
		
		
		// here, we are comparing node by node
		// element of first half and second half
		// If not found equal at any point, we
		// return false
		while(last != null) {
			if(last.getData() != current.getData())
				return false;
			
			last = last.getNext();
			current = current.getNext();
		}
		
		return true;
		
	}
	
	public ListNode<T> reverseListUsingStack(ListNode<T> head) {
		LinkedStack<T> stk = new LinkedStack<>();
		
		ListNode<T> temp = head;
		while(temp != null) {
			stk.push(temp.getData());
			temp = temp.getNext();
		}
		
		return stk.getTop();
	}
	
	public static void main(String[] args) {
						
		_1_h_CheckStringGivenAsLinkedListIsPalindrome_UsingStack<Character> mainClass = new _1_h_CheckStringGivenAsLinkedListIsPalindrome_UsingStack<>();
		
		LinkedList<Character> ll = new LinkedList<>();
		ll.insertAtBegin('a');
		ll.insertAtEnd('b');
		ll.insertAtEnd('c');
		ll.insertAtEnd('d');
		ll.insertAtEnd('c');
		ll.insertAtEnd('b');
		ll.insertAtEnd('a');
		System.out.println(ll.toString());
		
		boolean isPalindrome = mainClass.isPalindrome(ll.getHead());
		
		System.out.println("Is given string palindrome? : " + isPalindrome);
				
		
	}

}
