package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;

import java.util.HashMap;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNodeWithRandomPointer;

public class p032_CopyLinkedListWithRandomPointer_UsingHashMap<T> {
	
	public ListNodeWithRandomPointer<T> copyListWithRandomPointer(ListNodeWithRandomPointer<T> head) {
		HashMap<ListNodeWithRandomPointer<T>, ListNodeWithRandomPointer<T>> map = new HashMap<>();
		ListNodeWithRandomPointer<T> orig = head, copy;
		
		// creating, and storing copy nodes
		// into hashmap
		// using original node as key, and copy node as value
		// Copy nodes are created using data of original nodes
		// next and random of all copy nodes are null initially
		while(orig != null) {
			copy = new ListNodeWithRandomPointer<>(orig.getData());
			map.put(orig, copy);
			orig = orig.getNext();
		}
		
		orig = head;
		
		// retrieving stored copy nodes
		// and setting their next and random pointers
		while(orig != null) {
			
			// retrieving copy node using original node as key
			copy = map.get(orig);
			
			// setting next of copy node using using stored original's next's data as key from hashmap
			copy.setNext(map.get(orig.getNext()));
			
			// setting random of copy node using using stored original's random's data as key from hashmap
			copy.setRandom(map.get(orig.getRandom()));
			
			//advancing original reference to next original node
			orig = orig.getNext();
		}
		
		// returning reference to first copy node
		return map.get(head);
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
		p032_CopyLinkedListWithRandomPointer_UsingHashMap<Integer> mainClass = new p032_CopyLinkedListWithRandomPointer_UsingHashMap<>();
		
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
