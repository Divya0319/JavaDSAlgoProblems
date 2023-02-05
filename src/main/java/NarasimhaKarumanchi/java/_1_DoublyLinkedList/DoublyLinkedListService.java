package main.java.NarasimhaKarumanchi.java._1_DoublyLinkedList;

public interface DoublyLinkedListService<T> {

	void insertAtBegin(T data);
	
	void insertAtEnd(T data);
	
	void insert(T data, int position);
	
	DLLNode<T> deleteAtBegin();
	
	DLLNode<T> deleteAtEnd();
	
	DLLNode<T> delete(int position);
	
	int getLength();
	
	boolean isEmpty();
	
}
