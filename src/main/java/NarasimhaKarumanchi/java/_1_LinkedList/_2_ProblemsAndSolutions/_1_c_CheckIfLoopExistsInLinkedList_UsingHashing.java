package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;

import java.util.HashSet;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public class _1_c_CheckIfLoopExistsInLinkedList_UsingHashing<T> {

	public boolean checkIfLoopExists(ListNode<T> head) {
		if(head == null) {
			return false;
		}
		HashSet<ListNode<T>> map = new HashSet<>();
		
		ListNode<T> temp = head;
		
		while(temp != null) {
			
			// checking if current node of list 
			// is already present in hashmap
			if(map.contains(temp)) 
				return true;
			
			// if not present, we put it in hashmap
			 else 
				map.add(temp);
			
			// going to next node of list
			temp = temp.getNext();
		}
		
		return false;
	}

	public static void main(String[] args) {
		_1_c_CheckIfLoopExistsInLinkedList_UsingHashing<Integer> mainClass = new _1_c_CheckIfLoopExistsInLinkedList_UsingHashing<>();
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
		ll.insertAndCreateLoop(45, 3);
		
		boolean isLoopExists = mainClass.checkIfLoopExists(ll.getHead());
		if(isLoopExists) 
			System.out.println("Loop exists");
		 else
			 System.out.println("Loop does not exist");
	}

}
