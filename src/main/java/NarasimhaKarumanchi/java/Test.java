package main.java.NarasimhaKarumanchi.java;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNodeWithRandomPointer;

public class Test<T> {
	
	
	public ListNodeWithRandomPointer<T> copyListWithRandomPointer_NoExtraSpace(ListNodeWithRandomPointer<T> head) {
		
		ListNodeWithRandomPointer<T> iter = head, front = head;
		
		while(iter != null) {
			
			ListNodeWithRandomPointer<T> copy = new ListNodeWithRandomPointer<T>((T) new Integer(-1));
			iter.setNext(copy);
			copy.setNext(front);
			
			iter = front;
		}
		
		iter = head;
		
		while(iter != null) {
			if(iter.getRandom() != null) {
				
				iter.getNext().setRandom(iter.getRandom().getNext());
			}
		}
		
		iter = head;
		
		ListNodeWithRandomPointer<T> ph = new ListNodeWithRandomPointer<T>((T) new Integer(-1));
		ListNodeWithRandomPointer<T> copy = ph;
		
		while(iter != null) {
			
			front = iter.getNext().getNext();
			
			copy.setNext(iter.getNext());
			
			copy = copy.getNext();
			
			iter.setNext(front);
			
			iter = front;
		}
		
		
		return ph.getNext(); // returning 1st copy node
		
	}
	
	
	
	

	public static void main(String[] args) {
		Test<Integer> mainClass = new Test<>();
		

	}

}
