package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import java.util.EmptyStackException;

import main.java.NarasimhaKarumanchi.java._2_Stacks.DynamicStackService;
import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_e_GetMinimumInOrder1TimeInStack<T> implements DynamicStackService<T>{
	
	// along with storing given input in a stack for finding minimum
	// we maintain another stack which keeps current minimum on top
	private LinkedStack<T> elementStack  = new LinkedStack<>();
	private LinkedStack<T> minStack  = new LinkedStack<>();
	
	@Override
	public void push(T data) {
		
		// we push input into default stack as usual
		elementStack.push(data);
		
		// but we push in minStack only if its empty,
		// or if its top data is greater than current input received
		if(minStack.isEmpty() || (Integer)minStack.peek() >= (Integer)data) {
			minStack.push(data);
		} 
		
		// else we simply push top of minStack back to minStack
		else {
			minStack.push(minStack.peek());
		}
		
	}

	@Override
	public T pop() throws EmptyStackException {
		
		if(elementStack.isEmpty()) throw new EmptyStackException();
		
		
		// we would pop from minStack
		// only if top of elementStack is same as minStack top
		// other wise not
		if((Integer)minStack.peek() == (Integer)elementStack.peek()) 
			minStack.pop();
		
		return elementStack.pop();
	}
	
	public int getMinimum() {
		return (Integer)minStack.peek();
	}

	@Override
	public T peek() throws EmptyStackException {
		
		if(elementStack.isEmpty()) throw new EmptyStackException();
		
		return elementStack.peek();
	}

	@Override
	public int size() {
		
		return elementStack.size();
	}

	@Override
	public boolean isEmpty() {
		
		return elementStack.isEmpty();
	}
	
	@Override
	public String toString() {
		return elementStack.toString();
	}

	public static void main(String[] args) {
		
		_1_e_GetMinimumInOrder1TimeInStack<Integer> mainClass = new _1_e_GetMinimumInOrder1TimeInStack<>();
		
		mainClass.push(7);
		System.out.println(mainClass.toString());
		mainClass.push(6);
		System.out.println(mainClass.toString());
		mainClass.push(5);
		System.out.println(mainClass.toString());
		mainClass.push(4);
		System.out.println(mainClass.toString());
		mainClass.push(3);
		System.out.println(mainClass.toString());
		mainClass.push(7);
		System.out.println(mainClass.toString());
		
		mainClass.pop();
		System.out.println(mainClass.toString());
		
		System.out.println("Minimum element: " + mainClass.getMinimum());
		
		
	}

}
