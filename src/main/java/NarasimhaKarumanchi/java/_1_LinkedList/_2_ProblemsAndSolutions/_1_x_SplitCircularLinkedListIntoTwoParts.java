package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;


import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;


/* In this problem, we split a circular linked list into two halves
 * which are both circular linked lists in themselves
 */
public class _1_x_SplitCircularLinkedListIntoTwoParts<T> {
	ListNode<T> head1, head2;

	public void splitListIntoEqualParts(ListNode<T> head) {
		if(head == null) 
			return;
		
		ListNode<T> slow = head, fast = head;
		
		// this loop is used to find 
		// middle of the list
		// by using two pointers,
		// out of which one travels twice as fast as other
		while(fast.getNext() != head && fast.getNext().getNext() != head) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();  // at the end, slow is present at middle of linked list
		}
		
		
		// this condition is checked to make sure that 
		// even if list has even no. of nodes
		// and fast reached second last node
		// while advancing twice every time,
		// at last, fast must be present at
		// last node, to make second list circular
		if(fast.getNext().getNext() == head) {
			fast = fast.getNext();
		}
		
		// updating head of first splitted list
		head1 = head;
		// updating head of second splitted list
		head2 = slow.getNext();
		
		// making second list circular here
		fast.setNext(slow.getNext());
		// making first list circular here
		slow.setNext(head);
		
		
	}
	
	public ListNode<T> getHead1() {
		return head1;
	}
	
	public ListNode<T> getHead2() {
		return head2;
	}
	
	public void convertToCircular(ListNode<T> head) {
        ListNode<T> temp = head;
        
        while(temp.getNext() != null) {
        	temp = temp.getNext();
        }
        
        temp.setNext(head);
    }
	
	public String printList(ListNode<T> head) {
		ListNode<T> temp = head;
		String s = "[";
		if(head != null) {
			do {
				if(temp.getNext() == head) {
					s = s + temp.getData();
					temp = temp.getNext();
				} else {
				s = s + temp.getData() + ", ";
				temp = temp.getNext();
				}
				
			} while(temp != head);
		}
		
		return s + "]";
	}

	public static void main(String[] args) {
		_1_x_SplitCircularLinkedListIntoTwoParts<Integer> mainClass = new _1_x_SplitCircularLinkedListIntoTwoParts<>();
		LinkedList<Integer> ll = new LinkedList<>();
		ll.insertAtBegin(1);
		System.out.println(ll.toString());
		ll.insertAtEnd(2);
		System.out.println(ll.toString());
		ll.insertAtEnd(3);
		System.out.println(ll.toString());
		ll.insertAtEnd(4);
		System.out.println(ll.toString());
		ll.insertAtEnd(5);
		System.out.println(ll.toString());
		ll.insertAtEnd(6);
		System.out.println(ll.toString());
		ll.insertAtEnd(7);
		System.out.println(ll.toString());
		mainClass.convertToCircular(ll.getHead());
		System.out.println("Original List: " + mainClass.printList(ll.getHead()));
		
		mainClass.splitListIntoEqualParts(ll.getHead());
		System.out.println("First List: " + mainClass.printList(mainClass.getHead1()));
		System.out.println("Second List: " + mainClass.printList(mainClass.getHead2()));

	}

}
