package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_x_CheckPairWiseConsecutiveInStack {
	
	public boolean checkPairwiseConsecutive(LinkedStack<Integer> inpStack) {
		
		LinkedStack<Integer> aux = new LinkedStack<>();
		
		// stack is reversed and kept in aux stack here
		while(!inpStack.isEmpty()) {
			aux.push(inpStack.pop());
		}
		
		// Initializing result as true
		boolean result = true;
		
		while(aux.size() > 1) {
			
			// popping first two elements
			// from aux stack, for difference calculation
			int x = aux.pop();
			int y = aux.pop();
			
			if(Math.abs(x-y) != 1) {
				result = false;
			}
			
			// after comparison, put both element 
			// back to original stack(this effectively brings back original stack)
			inpStack.push(x);
			inpStack.push(y);
			
			// case when stack has odd no. of elements
			// pushing last remaining element from aux stack
			// back to original stack
			if(aux.size() == 1) {
				inpStack.push(aux.peek());
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
				
		_1_x_CheckPairWiseConsecutiveInStack mainClass = new _1_x_CheckPairWiseConsecutiveInStack();
		
		LinkedStack<Integer> iStk = new LinkedStack<>();
		
		iStk.push(7);
		iStk.push(6);
		iStk.push(2);
		iStk.push(3);
		iStk.push(34);
		iStk.push(33);
		iStk.push(98);
		System.out.println("Input stack: " + iStk.toString());
		
		boolean isPairwiseConsecutive = mainClass.checkPairwiseConsecutive(iStk);
		
		System.out.println("Is stack pairwise consecutive?: " + isPairwiseConsecutive);
		
		
			
	}

}
