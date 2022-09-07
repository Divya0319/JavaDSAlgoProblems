package main.java.NarasimhaKarumanchi.java._1_LinkedList;

import java.util.EmptyStackException;


public class StackUsingLinkedList<T> implements StackService<T> {
		
	private int length;
	private ListNode<T> top;
	
	public StackUsingLinkedList() {
		length = 0;
		top = null;
	}
	
	public void push(T data) {
		ListNode<T> temp = new ListNode<>(data);
		temp.setNext(top);
		top = temp;
		length++;
	}
	
	public T pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		
		T result = top.getData();
		top = top.getNext();
		length--;
		return result;
	}
	
	public T peek() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		
		return top.getData();
	}
	
	public ListNode<T> getTop() {
		return top;
	}
	
	public void setTop(ListNode<T> top) {
		this.top = top;
	}
	
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public int size() {
		return length;
	}
	
	public String toString() {
		String result = "";
		ListNode<T> current = top;
		while(current != null) {
			result = result + current.getData() + " ";
			current = current.getNext();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
		try {
			stack.push(6);
			System.out.println(stack.toString());
			stack.push(8);
			System.out.println(stack.toString());
			stack.push(4);
			System.out.println(stack.toString());
			stack.push(34);
			System.out.println(stack.toString());
			stack.push(6);
			System.out.println(stack.toString());
			stack.push(3);
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
