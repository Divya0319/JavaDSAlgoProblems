package com.dsalgoproblems.javaproblems;

public class DynamicArrayStack {
	
	protected int capacity;
	
	public static final int CAPACITY = 2;
	
	protected int[] stackRep;
	
	protected int top = -1;
	
	public DynamicArrayStack() {
		this(CAPACITY);
	}
	
	public DynamicArrayStack(int cap) {
		capacity = cap;
		stackRep = new int[capacity];
	}
	
	public int size() {
		return (top+1);
	}
	
	public boolean isEmpty() {
		return (top < 0);
	}
	
	public int top() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		
		return stackRep[top];
	}
	
	public void push(int data) {
		if(size() == capacity) {
			expand();
		}
		stackRep[++top] = data;
//		System.out.println(toString());
	}
	
	public int pop() throws Exception {
		int data;
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		data = stackRep[top];
		stackRep[top--] = 0;
		shrink();
//		System.out.println(toString());
		return data;
	}
	
	private void expand() {
		int length = size();
		int newStack[] = new int[length << 1];
		System.arraycopy(stackRep, 0, newStack, 0, length);
		stackRep = newStack;
		capacity = capacity << 1;
		
	}
	
	private void shrink() {
		int length = size();
		if(length<=(capacity >> 2)) {
			capacity = capacity >> 1;
			int newStack[]  = new int[capacity];
			System.arraycopy(stackRep, 0, newStack, 0, length);
			stackRep = newStack;
		}
	}
	
	public String toString() {
		String s;
		s = "[";
		if(size() > 0) {
			for(int n : stackRep) {
				s += n + " ";  
			}
		}
		
		return s + "]";
	}
	
	public static void main(String[] args) {
		DynamicArrayStack stack = new DynamicArrayStack();
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

			System.out.println("Top: " + stack.top());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
