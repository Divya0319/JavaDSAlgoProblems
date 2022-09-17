package main.java.NarasimhaKarumanchi.java._2_Stacks;

import java.util.EmptyStackException;

public class DynamicArrayStack<T> implements DynamicStackService<T> {
	
	protected int capacity;
	
	public static final int CAPACITY = 2;
	
	protected T[] stackRep;
	
	protected int top = -1;
	
	public DynamicArrayStack() {
		this(CAPACITY);
	}
	
	public DynamicArrayStack(int cap) {
		capacity = cap;
		stackRep = (T[])new Object[capacity];
	}
	
	public int size() {
		return (top+1);
	}
	
	public boolean isEmpty() {
		return (top < 0);
	}
	
	public T peek() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return stackRep[top];
	}
	
	public void push(T data) {
		if(size() == capacity) {
			expand();
		}
		stackRep[++top] = data;
//		System.out.println(toString());
	}
	
	public T pop() throws EmptyStackException {
		T data;
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		data = stackRep[top];
		stackRep[top--] = null;
		shrink();
//		System.out.println(toString());
		return data;
	}
	
	private void expand() {
		int length = size();
		T[] newStack = (T[])new Object[length << 1];
		System.arraycopy(stackRep, 0, newStack, 0, length);
		stackRep = newStack;
		capacity = capacity << 1;
		System.out.println("Stack expanded : New capacity -> " + capacity);
	}
	
	private void shrink() {
		int length = size();
		if(length<=(capacity >> 2)) {
			capacity = capacity >> 1;
			T[] newStack  = (T[])new Object[capacity];
			System.arraycopy(stackRep, 0, newStack, 0, length);
			stackRep = newStack;
			System.out.println("Stack shrinked : New capacity -> " + capacity);
		}
	}
	
	public String toString() {
		String s;
		s = "[";
		if(size() > 0) {
			for(T n : stackRep) {
				s += n + " ";  
			}
		}
		
		return s + "]";
	}
	
	public static void main(String[] args) {
		DynamicArrayStack<Integer> stack = new DynamicArrayStack<>();
		try {
			stack.push(7);
			System.out.println(stack.toString());
			stack.push(9);
			System.out.println(stack.toString());
			stack.push(4);
			System.out.println(stack.toString());
			stack.push(34);
			System.out.println(stack.toString());
			stack.push(6);
			System.out.println(stack.toString());
			stack.push(3);
			System.out.println(stack.toString());
			stack.push(65);
			System.out.println(stack.toString());
			stack.push(23);
			System.out.println(stack.toString());
			stack.push(89);
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());

			System.out.println("Top: " + stack.peek());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
