package main.java.NarasimhaKarumanchi.java.t002_LinkedList;

public interface LinkedListService_Practice<T> {
	
	void insertAtBegin(T data);
	
	void insertAtEnd(T data);
	
	void insert(T data, int position);
	
	ListNode_Practice<T> deleteAtBegin();
	
	ListNode_Practice<T> deleteAtEnd();
	
	ListNode_Practice<T> delete(int position);
	
	int getLength();
	
	boolean isEmpty();

}
