package main.java.NarasimhaKarumanchi.java._1_LinkedList;


public class ListNodeWithRandomPointer<T> {
	T data;
	ListNodeWithRandomPointer<T> next;
	ListNodeWithRandomPointer<T> random;
	
	public ListNodeWithRandomPointer(T data) {
		this.data = data;
		this.next = null;
		this.random = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ListNodeWithRandomPointer<T> getNext() {
		return next;
	}

	public void setNext(ListNodeWithRandomPointer<T> next) {
		this.next = next;
	}

	public ListNodeWithRandomPointer<T> getRandom() {
		return random;
	}

	public void setRandom(ListNodeWithRandomPointer<T> random) {
		this.random = random;
	}
	
	
}
