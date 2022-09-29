package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_w_SortStackUsingTempStack {
	
	public LinkedStack<Integer> sortStack(LinkedStack<Integer> inpStack) {
		
		LinkedStack<Integer> tempStack = new LinkedStack<>();
		while(!inpStack.isEmpty()) {
			int tmp = inpStack.pop();
			System.out.println("Popped from input stack: " + tmp);
			while(!tempStack.isEmpty() && tempStack.peek() < tmp) {
				inpStack.push(tempStack.peek());
				System.out.println("Pushed back to input stack: " + tempStack.pop());
			}
			
			tempStack.push(tmp);
			System.out.println("Pushed to result stack: " + tmp);
			System.out.println(tempStack.toString());

		}
		
		return tempStack;
	}
	
	public static void main(String[] args) {
				
		_1_w_SortStackUsingTempStack mainClass = new _1_w_SortStackUsingTempStack();
		
		LinkedStack<Integer> iStk = new LinkedStack<>();
		
		iStk.push(-5);
		iStk.push(2);
		iStk.push(9);
		iStk.push(1);
		iStk.push(74);
		iStk.push(-3);
		System.out.println("Input stack: " + iStk.toString());
		
		LinkedStack<Integer> sortedStack = mainClass.sortStack(iStk);
		
		System.out.println("Sorted Stack: " + sortedStack);
		
			
	}

}
