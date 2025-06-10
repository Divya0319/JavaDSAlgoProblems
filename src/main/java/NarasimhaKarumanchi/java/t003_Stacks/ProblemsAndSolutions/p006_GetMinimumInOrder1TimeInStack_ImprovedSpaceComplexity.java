package main.java.NarasimhaKarumanchi.java.t003_Stacks.ProblemsAndSolutions;

import java.util.EmptyStackException;

import main.java.NarasimhaKarumanchi.java.t003_Stacks.DynamicStackService;
import main.java.NarasimhaKarumanchi.java.t003_Stacks.LinkedStack;

public class p006_GetMinimumInOrder1TimeInStack_ImprovedSpaceComplexity<T> implements DynamicStackService<T>{
	
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
		
		// removed code which pushed duplicate
		// element into minStack
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
		
		p006_GetMinimumInOrder1TimeInStack_ImprovedSpaceComplexity<Integer> mainClass = new p006_GetMinimumInOrder1TimeInStack_ImprovedSpaceComplexity<>();
		
		mainClass.push(7);
		System.out.println(mainClass.toString());
		mainClass.push(9);
		System.out.println(mainClass.toString());
		mainClass.push(4);
		System.out.println(mainClass.toString());
		mainClass.push(34);
		System.out.println(mainClass.toString());
		mainClass.push(6);
		System.out.println(mainClass.toString());
		mainClass.push(3);
		System.out.println(mainClass.toString());
		mainClass.push(65);
		System.out.println(mainClass.toString());
		mainClass.push(23);
		System.out.println(mainClass.toString());
		mainClass.push(89);
		System.out.println(mainClass.toString());
		
		System.out.println("Minimum element: " + mainClass.getMinimum());
		
		
	}

}
