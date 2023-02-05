package main.java.NarasimhaKarumanchi.java._1_DoublyLinkedList;

public class DLLNode<T> {
	private T data;
	private DLLNode<T> prev;
	private DLLNode<T> next;


	public DLLNode(T data) {
		this.data = data;
	}
	
	


	public DLLNode(T data, DLLNode<T> prev, DLLNode<T> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}




	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public DLLNode<T> getPrev() {
		return prev;
	}


	public void setPrev(DLLNode<T> prev) {
		this.prev = prev;
	}


	public DLLNode<T> getNext() {
		return next;
	}


	public void setNext(DLLNode<T> next) {
		this.next = next;
	}

}
