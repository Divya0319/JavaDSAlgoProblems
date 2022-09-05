package main.java.NarasimhaKarumanchi.java._2_Stacks;

public interface LinkedListService<T> {
	
	void insertAtBegin(T node);
	
	void insertAtEnd(T node);
	
	void insert(T node, int position);
	
	ListNode<T> deleteAtBegin();
	
	ListNode<T> deleteAtEnd();
	
	ListNode<T> delete(int position);
	
	int getLength();
	
	boolean isEmpty();

}
