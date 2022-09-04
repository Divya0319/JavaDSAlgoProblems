package main.java.NarasimhaKarumanchi.java._2_Stacks;

public interface StackService<T> {
	
	void push(T data);
	
	T pop();
	
	T peek();
	
	int size();
	
	boolean isEmpty();

}
