package main.java.NarasimhaKarumanchi.java.t003_Stacks;

import java.util.EmptyStackException;

public interface DynamicStackService<T> {
	
	void push(T data);
	
	T pop() throws EmptyStackException;
	
	T peek() throws EmptyStackException;
	
	int size();
	
	boolean isEmpty();

}
