package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNodeWithRandomPointer;

public class _2_f_CopyLinkedListWithRandomPointer<T> {
	
	public ListNodeWithRandomPointer<T> copyListWithRandomPointer(ListNodeWithRandomPointer<T> head) {
		ListNodeWithRandomPointer<T> iter = head;
		ListNodeWithRandomPointer<T> front = head;
		
		// First round : make a copy of each node
		// and link them together side by side in a single list
		while(iter != null) {
			front = iter.getNext();
			
			ListNodeWithRandomPointer<T> copy = new ListNodeWithRandomPointer<T>(iter.getData());
			iter.setNext(copy);
			copy.setNext(front);
			
			iter = front;
		}
		
		// Second round: assign random pointers for each copy node
		iter = head;
		while(iter != null) {
			if(iter.getRandom() != null) {
				iter.getNext().setRandom(iter.getRandom().getNext());
			}
			
			iter = iter.getNext().getNext();
		}
		
		// Third round: restore the original list and extract the copy list
		iter = head;
		ListNodeWithRandomPointer<T> pseudoHead = new ListNodeWithRandomPointer<T>((T)new Integer(0));
		ListNodeWithRandomPointer<T> copy = pseudoHead;
		
		while(iter != null) {
			front = iter.getNext().getNext();
			
			
			// extract the copy
			copy.setNext(iter.getNext());
			copy = copy.getNext();
			
			// restore the original list
			iter.setNext(front);
			
			iter = front;
		}
		return pseudoHead.getNext();
	}
	
	public String printList(ListNodeWithRandomPointer<T> head) {
		String s = "";
		ListNodeWithRandomPointer<T> temp = head;
		
		while(temp != null) {
			if(temp.getRandom() != null) {
				s = s + temp.getData() + " has random pointing to " + temp.getRandom().getData();
				s = s + "\n";
			}
			else {
				s = s + temp.getData() + " has random pointing to null";
				s = s + "\n";
			}
			temp = temp.getNext();
		}
		
		return s;
	}

	public static void main(String[] args) {
		_2_f_CopyLinkedListWithRandomPointer<Integer> mainClass = new _2_f_CopyLinkedListWithRandomPointer<>();
		
		ListNodeWithRandomPointer<Integer> head = new ListNodeWithRandomPointer<Integer>(1);
		ListNodeWithRandomPointer<Integer> n1 = new ListNodeWithRandomPointer<Integer>(2);
		ListNodeWithRandomPointer<Integer> n2 = new ListNodeWithRandomPointer<Integer>(3);
		ListNodeWithRandomPointer<Integer> n3 = new ListNodeWithRandomPointer<Integer>(4);
		ListNodeWithRandomPointer<Integer> n4 = new ListNodeWithRandomPointer<Integer>(5);
		ListNodeWithRandomPointer<Integer> n5 = new ListNodeWithRandomPointer<Integer>(6);
		ListNodeWithRandomPointer<Integer> n6 = new ListNodeWithRandomPointer<Integer>(7);

		head.setNext(n1);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(null);

		head.setRandom(n5);
		n1.setRandom(n3);
		n2.setRandom(n1);
		n3.setRandom(head);
		n4.setRandom(n6);
		n5.setRandom(n2);
		n6.setRandom(n4);
		
		System.out.println("Original list :");
		System.out.println(mainClass.printList(head));
		
		System.out.println("Copied List :");
		System.out.println(mainClass.printList(mainClass.copyListWithRandomPointer(head)));

	}

}
