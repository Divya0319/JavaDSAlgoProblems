package main.java.NarasimhaKarumanchi.java.t003_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t003_Stacks.LinkedStack;

public class _1_j_ReverseStackUsingStackOperations<T> {

	LinkedStack<T> stk = new LinkedStack<>();

	
	/*
	 *  this function will first pop a value from stack
	 	then recursively call reverse() again, until
	 	all the values from stack are stored
	 	in a variable in recursion stack.
	 	
	 * then a method insertAtBottom(x) is called,
	 * which inserts the passed value at the bottom of the stack only
	 */
	public void reverseStack() {

		if(stk.size() > 0) {
			T x = stk.pop();
			reverseStack();
			insertAtBottom(x);
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
	public void insertAtBottom(T x) {
		if (stk.size() == 0) {
			System.out.println("Inserting " + x + " at bottom now");
			stk.push(x);
		} else {
			T a = stk.pop();
			System.out.println("Popping " + a + " from top to push " + x);
			insertAtBottom(x);
			stk.push(a);
			System.out.println("Pushing back " + a + " now");
			System.out.println(stk.toString());
		}
		
		
	}

	public static void main(String[] args) {

		_1_j_ReverseStackUsingStackOperations<Integer> mainClass = new _1_j_ReverseStackUsingStackOperations<>();

		mainClass.stk.push(7);
		mainClass.stk.push(6);
		mainClass.stk.push(5);
		mainClass.stk.push(4);
		mainClass.stk.push(3);
		mainClass.stk.push(2);
		mainClass.stk.push(1);
		System.out.println("Given stack: \n" + mainClass.stk.toString());
		System.out.println();
		System.out.println("Reversing stack: \n");

		mainClass.reverseStack();
		
	}

}
