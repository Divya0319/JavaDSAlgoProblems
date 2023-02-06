package main.java.NarasimhaKarumanchi.java._1_LinkedList;

public interface CircularLinkedListService<T> {
	
	void insertAtBegin(T data);
	
	void insertAtEnd(T data);
	
	ListNode<T> deleteFromBegin();
	
	ListNode<T> deleteFromEnd();
	
	int length();
	
	boolean isEmpty();

}
