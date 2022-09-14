package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import java.util.HashMap;
import java.util.Map;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNodeWithRandomPointer;

public class _2_f_CopyLinkedListWithRandomPointer_UsingHashMap<T> {
	
	public ListNodeWithRandomPointer<T> copyListWithRandomPointer(ListNodeWithRandomPointer<T> head) {
		HashMap<ListNodeWithRandomPointer<T>, ListNodeWithRandomPointer<T>> map = new HashMap<>();
		ListNodeWithRandomPointer<T> temp = head, copy;
		
		while(temp != null) {
			copy = new ListNodeWithRandomPointer<>(temp.getData());
			map.put(temp, copy);
			temp = temp.getNext();
		}
		
		temp = head;
		
		while(temp != null) {
			copy = map.get(temp);
			copy.setNext(map.get(temp.getNext()));
			copy.setRandom(map.get(temp.getRandom()));
			temp = temp.getNext();
		}
		
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
		_2_f_CopyLinkedListWithRandomPointer_UsingHashMap<Integer> mainClass = new _2_f_CopyLinkedListWithRandomPointer_UsingHashMap<>();
		
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
