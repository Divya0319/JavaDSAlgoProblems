package main.java.NarasimhaKarumanchi.java._1_LinkedList;

public interface StackService<T> {
	
	void push(T data);
	
	T pop();
	
	T peek();
	
	int size();
	
	boolean isEmpty();

}
