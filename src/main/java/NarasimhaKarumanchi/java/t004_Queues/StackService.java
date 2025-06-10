package main.java.NarasimhaKarumanchi.java.t004_Queues;

public interface StackService<T> {
	
	void push(T data);
	
	T pop();
	
	T peek();
	
	int size();
	
	boolean isEmpty();

}
