package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import java.util.ArrayList;
import java.util.List;

public class _1_z_StackForStackSets<T> implements _1_z_CreateNewStackWhenOldStackOverflows<T> {

	private int top = -1;
	private T[] arr;

	private int capacity;

	public _1_z_StackForStackSets(int capacity) {
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}

	@Override
	public void push(T data) {
		arr[++top] = data;
	}

	@Override
	public T pop() {
		return arr[top--];
	}

	@Override
	public boolean isAtCapacity() {
		return capacity == top + 1;
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public String toString() {
		String s = "";
		int index = top;
		while (index >= 0) {
			s += "[" + arr[index--] + "]" + "-->";
		}

		return s;
	}
	
	public static void main(String[] args) {
		
	}

}

class StackSets<T> {

	private int threshold;

	private List<_1_z_StackForStackSets<T>> listOfStacks;

	public StackSets(int threshold) {
		this.threshold = threshold;
		this.listOfStacks = new ArrayList<>();
	}

	// get the last stack
	public _1_z_StackForStackSets<T> getLastStack() {
		int size = listOfStacks.size();
		if (size <= 0) {
			return null;
		}
		return listOfStacks.get(size - 1);
	}

	// get the nth stack
	public _1_z_StackForStackSets<T> getNthStack(int n) {
		int size = listOfStacks.size();
		if (size <= 0) {
			return null;
		}
		return listOfStacks.get(n - 1);
	}

	// push to stack
	public void push(T data) {
		_1_z_StackForStackSets<T> lastStack = this.getLastStack();
		if (lastStack == null) {
			lastStack = new _1_z_StackForStackSets<>(threshold);
			lastStack.push(data);
			listOfStacks.add(lastStack);
		} else {
			if(!lastStack.isAtCapacity()) {
				lastStack.push(data);
			}
			else {
				_1_z_StackForStackSets<T> newLastStack = new _1_z_StackForStackSets<>(threshold);
			newLastStack.push(data);
			listOfStacks.add(newLastStack);
			}
		}
	}

	// pop from stack
	public T pop() {
		_1_z_StackForStackSets<T> lastStack = this.getLastStack();
		T data = lastStack.pop();
		if (lastStack.size() == 0) {
			listOfStacks.remove(listOfStacks.size() - 1);
		}

		return data;
	}

	// pop from nth stack
	public T pop(int n) {
		_1_z_StackForStackSets<T> nthStack = this.getNthStack(n);
		T data = nthStack.pop();
		if (nthStack.size() == 0) {
			listOfStacks.remove(n - 1);
		}

		return data;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < listOfStacks.size(); i++) {
			_1_z_StackForStackSets<T> stack = listOfStacks.get(i);
			int j = i;
			s = "\nStack " + ++j + ":" + stack.toString() + s;
		}

		return s;
	}

	public static void main(String[] args) {

		StackSets<Integer> stacks = new StackSets<>(5);
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		stacks.push(6);
		stacks.push(7);
		stacks.push(8);
		stacks.push(9);
		stacks.push(10);
		stacks.push(11);
		stacks.push(12);
		stacks.push(13);
		stacks.push(14);
		stacks.push(15);
		stacks.push(16);
		stacks.push(17);
		stacks.push(18);
		stacks.push(19);
		stacks.push(20);
		stacks.push(21);
		stacks.push(22);
		stacks.push(23);
		stacks.push(24);
		stacks.push(25);
		stacks.push(26);
		System.out.println("The stack is : " + stacks);
		System.out.println("Popping from last stack: " + stacks.pop());
		System.out.println("The stack is : " + stacks);

	}
}
