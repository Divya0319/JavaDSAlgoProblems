package main.java.NarasimhaKarumanchi.java.t005_Trees;

public interface StackService<T> {
	
	void push(T data);
	
	T pop();
	
	T peek();
	
	int size();
	
	boolean isEmpty();

}
