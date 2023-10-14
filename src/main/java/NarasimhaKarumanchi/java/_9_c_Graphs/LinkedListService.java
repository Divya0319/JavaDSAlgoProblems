package main.java.NarasimhaKarumanchi.java._9_c_Graphs;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;

public interface LinkedListService<T> {
	
	void insert(T node);
		
	void insert(T node, int position);
	
	ListNode<T> deleteAtBegin();
	
	ListNode<T> deleteAtEnd();
	
	ListNode<T> delete(int position);
	
	int getLength();
	
	boolean isEmpty();

}
