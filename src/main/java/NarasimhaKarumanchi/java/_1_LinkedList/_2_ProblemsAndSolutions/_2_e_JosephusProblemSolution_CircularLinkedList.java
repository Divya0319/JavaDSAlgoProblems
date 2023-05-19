package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_e_JosephusProblemSolution_CircularLinkedList<T> {

	T survivor(ListNode<T> head, int k) {
		ListNode<T> p, q;
		int i;
		
		q = p = head;
		
		// while only one node is left in linked list
		while(p.getNext() != p) {
			
			// going to kth node
			// incrementing (k-1) times
			// as p is already at head
			for(i = 0; i < k - 1; i++) {
				q = p;
				p = p.getNext();
			}
			
			// pointing node before kth node
			// to node after kth node
			// (q is node before kth node p)
			q.setNext(p.getNext());
			System.out.println(p.getData() + " has been killed");
			
			// setting p to next of q, to be used in next iteration
			p = q.getNext();
		}
		
		// at this point, p is the only node left in linked list, so it is returned
		return p.getData();
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
	
	public void convertToCircular(ListNode<T> head) {
        ListNode<T> temp = head;
        
        while(temp.getNext() != null) {
        	temp = temp.getNext();
        }
        
        temp.setNext(head);
    }

	public static void main(String[] args) {
		_2_e_JosephusProblemSolution_CircularLinkedList<Integer> mainClass = new _2_e_JosephusProblemSolution_CircularLinkedList<>();
		
		Integer survived;
		Integer skip;
				
		LinkedList<Integer> ll = new LinkedList<>();
		ll.insertAtBegin(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(6);
		ll.insertAtEnd(7);
		ll.insertAtEnd(8);
		ll.insertAtEnd(9);
		mainClass.convertToCircular(ll.getHead());
				
		System.out.println("The persons in circular linked list are : "); 
		System.out.println(mainClass.printList(ll.getHead()));
		
		skip = 2;
		System.out.println("Enter the number of persons to be skipped: " + skip);
		survived = mainClass.survivor(ll.getHead(), skip);
		
		System.out.println("The person to survive is : " + survived);
		
	}

}
