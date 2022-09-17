package main.java.NarasimhaKarumanchi.java._2_Stacks;

public interface FixedStackService<T> {
	
	void push(T data) throws Exception;
	
	T pop() throws Exception;
	
	T peek() throws Exception;
	
	int size();
	
	boolean isEmpty();

}
