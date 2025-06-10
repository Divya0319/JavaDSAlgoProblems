package main.java.NarasimhaKarumanchi.java.t002_LinkedList;

public interface StackService<T> {
	
	void push(T data);
	
	T pop();
	
	T peek();
	
	int size();
	
	boolean isEmpty();

}
