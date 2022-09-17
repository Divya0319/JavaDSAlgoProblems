package main.java.NarasimhaKarumanchi.java._2_Stacks;

import java.util.EmptyStackException;

public interface DynamicStackService<T> {
	
	void push(T data);
	
	T pop() throws EmptyStackException;
	
	T peek() throws EmptyStackException;
	
	int size();
	
	boolean isEmpty();

}
