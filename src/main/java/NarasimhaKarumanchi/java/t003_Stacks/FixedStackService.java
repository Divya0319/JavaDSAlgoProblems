package main.java.NarasimhaKarumanchi.java.t003_Stacks;

public interface FixedStackService<T> {
	
	void push(T data) throws Exception;
	
	T pop() throws Exception;
	
	T peek() throws Exception;
	
	int size();
	
	boolean isEmpty();

}
