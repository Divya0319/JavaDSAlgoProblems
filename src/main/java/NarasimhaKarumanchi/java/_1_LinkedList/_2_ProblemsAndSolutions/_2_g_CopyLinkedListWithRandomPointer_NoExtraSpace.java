package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNodeWithRandomPointer;

public class _2_g_CopyLinkedListWithRandomPointer_NoExtraSpace<T> {
	
	public ListNodeWithRandomPointer<T> copyListWithRandomPointer(ListNodeWithRandomPointer<T> head) {
		ListNodeWithRandomPointer<T> iter = head;
		ListNodeWithRandomPointer<T> front = head;
		
		// First round : make a copy of each node
		// and link them together side by side in a single list
		while(iter != null) {
			
			// storing second node after current node
			front = iter.getNext();
			
			// creating copy node with original node data
			ListNodeWithRandomPointer<T> copy = new ListNodeWithRandomPointer<T>(iter.getData());
			// linking copy node after original node
			iter.setNext(copy);
			// setting copy node's next to node after original node
			copy.setNext(front);
			
			// advancing iter pointer to next original node
			iter = front;
		}
		
		// Second round: assign random pointers for each copy node
		iter = head;
		while(iter != null) {
			if(iter.getRandom() != null) {
				
				// since all copy nodes are placed in original list
				// copy node's random is set as original node's random's next
				// which is original node's random's copy
				iter.getNext().setRandom(iter.getRandom().getNext());
			}
			
			// going to next original node, skipping copy nodes
			iter = iter.getNext().getNext();
		}
		
		// Third round: restore the original list and extract the copy list
		iter = head;
		
		// keeping a pseudoHead of copy linked list, used during creation of 
		// separated copy linked list
		ListNodeWithRandomPointer<T> pseudoHead = new ListNodeWithRandomPointer<T>((T)new Integer(0));
		ListNodeWithRandomPointer<T> copy = pseudoHead;
		
		while(iter != null) {
			
			// front will hold next original node
			front = iter.getNext().getNext();
			
			
			// extract the copy
			copy.setNext(iter.getNext()); // dummy node's next will point to iter's next(which is 1st copy node)
			copy = copy.getNext();  // copy pointer will now move to 1st copy node
			// This keeps on going for 2nd copy node, 3rd, 4th and so on.
			
			// restore the original list
			
			// next links from original list is again restored, by skipping copy list nodes
			iter.setNext(front);
			
			
			// iter moved to next original node
			iter = front;
		}
		return pseudoHead.getNext();
	}
	
	public String printList(ListNodeWithRandomPointer<T> head) {
		String s = "";
		ListNodeWithRandomPointer<T> temp = head;
		
		while(temp != null) {
			if(temp.getRandom() != null) {
				s = s + temp.getData() + " has random pointing to " + temp.getRandom().getData() + "\n";
			}
			else {
				s = s + temp.getData() + " has random pointing to null\n";
			}
			temp = temp.getNext();
		}
		
		return s;
	}

	public static void main(String[] args) {
		_2_g_CopyLinkedListWithRandomPointer_NoExtraSpace<Integer> mainClass = new _2_g_CopyLinkedListWithRandomPointer_NoExtraSpace<>();
		
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
