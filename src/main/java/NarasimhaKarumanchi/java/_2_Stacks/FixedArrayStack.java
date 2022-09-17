package main.java.NarasimhaKarumanchi.java._2_Stacks;

public class FixedArrayStack<T> implements FixedStackService<T> {
	
	protected int capacity;
	
	public static final int CAPACITY = 10;
	
	protected T[] stackRep;
	
	protected int top = -1;
	
	public FixedArrayStack() {
		this(CAPACITY);
	}
	
	public FixedArrayStack(int cap) {
		capacity = cap;
		stackRep = (T[])new Object[capacity];
	}
	
	public int size() {
		return (top+1);
	}
	
	public boolean isEmpty() {
		return (top < 1);
	}
	
	public T peek() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		
		return stackRep[top];
	}
	
	public void push(T data) throws Exception {
		if(size() == capacity) {
			throw new Exception("Stack is full");
		}
		stackRep[++top] = data;
		System.out.println(toString());
	}
	
	public T pop() throws Exception {
		T data;
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		data = stackRep[top];
		stackRep[top--] = null;
		System.out.println(toString());
		return data;
	}
	
	public String toString() {
		String s;
		s = "[";
		if(size() > 0) {
			s += stackRep[0];
		}
		
		if(size() > 1) {
			for(int i = 1; i <= size() - 1; i++) {
				s += ", " + stackRep[i];
			}
			
		 
		}
		
		return s + "]";
	}
	
	public static void main(String[] args) {
		FixedArrayStack<Integer> stack = new FixedArrayStack<>();
		try {
			stack.push(7);
			stack.push(9);
			stack.push(4);
			stack.push(34);
			stack.pop();
			stack.pop();
			System.out.println("Top:" + stack.peek());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
