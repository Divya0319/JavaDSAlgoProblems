package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _2_e_JosephusProblemSolution_CircularLinkedList<T> {

	T survivor(ListNode<T> head, int k) {
		ListNode<T> p, q;
		int i;
		
		q = p = head;
		while(p.getNext() != p) {
			for(i = 0; i < k - 1; i++) {
				q = p;
				p = p.getNext();
			}
			
			q.setNext(p.getNext());
			System.out.println(p.getData() + " has been killed");
			p = q.getNext();
		}
		
		head = p;
		
		return p.getData();
	}
	
	public String printList(ListNode<T> head) {
		ListNode<T> temp = head;
		String s = "";
		if(head != null) {
			do {
				s = s + temp.getData() + " ";
				temp = temp.getNext();
			} while(temp != head);
		}
		
		return s;
	}

	public static void main(String[] args) {
		_2_e_JosephusProblemSolution_CircularLinkedList<Integer> mainClass = new _2_e_JosephusProblemSolution_CircularLinkedList<>();
		
		Integer survived, skip;
				
		ListNode<Integer> head = new ListNode<>(4);
		head.setNext(new ListNode<>(2));
		head.getNext().setNext(new ListNode<>(7));
		head.getNext().getNext().setNext(new ListNode<>(9));
		head.getNext().getNext().getNext().setNext(new ListNode<>(3));
		head.getNext().getNext().getNext().getNext().setNext(new ListNode<>(5));
		head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode<>(1));
		head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(head);
		
		System.out.println("The persons in circular linked list are : "); 
		System.out.println(mainClass.printList(head));
		
		skip = 3;
		System.out.println("Enter the number of persons to be skipped: " + skip);
		survived = mainClass.survivor(head, skip);
		
		System.out.println("The person to survive is : " + survived);
		
	}

}
