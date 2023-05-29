package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_j_SortStackUsingStackOperations<T> {

	LinkedStack<T> stk = new LinkedStack<>();

	
	/*
	 *  this function will first pop a value from stack
	 	then recursively call reverse() again, until
	 	all the values from stack are stored
	 	in a variable in recursion stack.
	 	
	 * then a method insertAtBottom(x) is called,
	 * which inserts the passed value at the bottom of the stack only
	 */
	public void sortStack() {

		if(stk.size() > 0) {
			T x = stk.pop();
			sortStack();
			insertAtCorrectPosition(x);
		}
	}

	/*
	 * this function works as follows
	 * 
	 * 1. If stack is empty, it simply pushed the passed value to stack
	 * 2. otherwise, it pops one by one, every value from top of stack
	 * 	stores it in some variable, and when stack becomes empty
	 * 	it pushes the passed value at bottom of stack,
	 * 	and then pushes all the previously popped values one by one
	 * 	back to stack.
	 */
	public void insertAtCorrectPosition(T x) {
		if (stk.size() == 0 || (Integer)stk.peek() <= (Integer)x) {
			System.out.println("Inserting " + x + " at bottom now");
			stk.push((T)x);
			System.out.println(stk.toString());
		} else {
			T a = stk.pop();
			System.out.println("Popping " + a + " from top to push " + x);
			insertAtCorrectPosition(x);
			stk.push(a);
			System.out.println("Pushing back " + a + " now");
			System.out.println(stk.toString());
		}
		
		
	}

	public static void main(String[] args) {

		_1_j_SortStackUsingStackOperations<Integer> mainClass = new _1_j_SortStackUsingStackOperations<>();

		mainClass.stk.push(8);
		mainClass.stk.push(2);
		mainClass.stk.push(5);
		mainClass.stk.push(67);
		mainClass.stk.push(21);
		mainClass.stk.push(90);
		mainClass.stk.push(33);
		System.out.println("Given stack: \n" + mainClass.stk.toString());
		System.out.println();
		System.out.println("Sorted stack: \n");

		mainClass.sortStack();
		
	}

}
