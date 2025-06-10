package main.java.NarasimhaKarumanchi.java.t012_Graphs;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public interface LinkedListService<T> {
	
	void insert(T node);
		
	void insert(T node, int position);
	
	ListNode<T> deleteAtBegin();
	
	ListNode<T> deleteAtEnd();
	
	ListNode<T> delete(int position);
	
	int getLength();
	
	boolean isEmpty();

}
