package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;

import java.util.List;
import java.util.ArrayList;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNodeWithRandomPointer;

public class p033_CopyLinkedListWithRandomPointer_NoExtraSpace<T> {
	
	public List<ListNodeWithRandomPointer<T>> insertAtTail(ListNodeWithRandomPointer<T> head, ListNodeWithRandomPointer<T> tail, T data) {
		ListNodeWithRandomPointer<T> newNode = new ListNodeWithRandomPointer<>(data);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
			
		}
		
		List<ListNodeWithRandomPointer<T>> headTail = new ArrayList<>();
		headTail.add(head);
		headTail.add(tail);
		
		return headTail;
	}
	
	public ListNodeWithRandomPointer<T> copyListWithRandomPointer(ListNodeWithRandomPointer<T> head) {
		
		// step1: create a clone list
		ListNodeWithRandomPointer<T> cloneHead = null;
		
		ListNodeWithRandomPointer<T> cloneTail = null;
		
		ListNodeWithRandomPointer<T> temp = head;
		
		while(temp != null) {
			List<ListNodeWithRandomPointer<T>> headTail = insertAtTail(cloneHead, cloneTail, temp.getData());
			cloneHead = headTail.get(0);
			cloneTail = headTail.get(1);
			temp = temp.getNext();
		}
		
		// step2: clone nodes add in between original list
		ListNodeWithRandomPointer<T> origNode = head;
		ListNodeWithRandomPointer<T> cloneNode = cloneHead;
		
		while(origNode != null && cloneNode != null) {
			
			ListNodeWithRandomPointer<T> next = origNode.getNext();
			origNode.setNext(cloneNode);
			origNode = next;
			
			next = cloneNode.getNext();
			cloneNode.setNext(origNode);
			cloneNode = next;
			
		}
		
		// step3: random pointer copy
		temp = head;
		while(temp != null) {
			
			if(temp.getNext() != null) {
				temp.getNext().setRandom(temp.getRandom() != null ? temp.getRandom().getNext() : temp.getRandom());
			}
			
			
			// so that we reach to next node of original list, bypassing the middle clone nodes
			temp = temp.getNext().getNext();
		}
		
		// step4: revert changes done in step4
		origNode = head;
		cloneNode = cloneHead;
		
		while(origNode != null && cloneNode != null) {
			origNode.setNext(cloneNode.getNext());
			origNode = origNode.getNext();
			
			if(origNode != null) {
				cloneNode.setNext(origNode.getNext());
			}
			cloneNode = cloneNode.getNext();
		}
		
		// step5: return ans
		return cloneHead;
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
		p033_CopyLinkedListWithRandomPointer_NoExtraSpace<Integer> mainClass = new p033_CopyLinkedListWithRandomPointer_NoExtraSpace<>();
		
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
