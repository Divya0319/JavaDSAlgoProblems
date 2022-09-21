package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedList;
import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;
import main.java.NarasimhaKarumanchi.java._2_Stacks.ListNode;

public class _1_h_CheckStringGivenAsLinkedListIsPalindrome_UsingStack<T> {
	
	public boolean isPalindrome(ListNode<T> head) {
		
		ListNode<T> slow = head, fast = head.getNext();
		
		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		ListNode<T> middle = slow;
		ListNode<T> last = reverseListUsingStack(middle.getNext());
		
		ListNode<T> current = head;
		
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
