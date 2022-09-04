package main.java.NarasimhaKarumanchi.java._4_Trees;

public interface StackService<T> {
	
	void push(T data);
	
	T pop();
	
	T peek();
	
	int size();
	
	boolean isEmpty();

}
