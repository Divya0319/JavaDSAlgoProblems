package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;


import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_a_BalancingSymbolsUsingStack {
	
	public boolean isValidSymbolPattern(String s) {
    	LinkedStack<Character> stk = new LinkedStack<>();
    	
    	// if string given is null or empty,
    	// it is by default valid symbol pattern
    	if(s == null || s.length() == 0) {
    		return true;
    	}
    	
    	for(int i = 0; i < s.length(); i++) {
    		
    		// checking characters from string
    		// one by one
    	   char c = s.charAt(i);
    	   
    	   // if character is any of 
    	   // opening or closing brackets
    	   if(c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
    		   
    		   // if character is ')', check if top of stack has a '('
    		   // if yes, pop this '(' from stack
    		if(c == ')') {
    			if(!stk.isEmpty() && stk.peek() == '(') {
    				stk.pop();
    			}
    			//else top of stack has a different symbol than ')'
    			else {
    				return false;
    			}
    			// if character is ']', check if top of stack has a '['
     		   // if yes, pop this '[' from stack
    		} else if(c == ']') {
    			if(!stk.isEmpty() && stk.peek() == '[') {
    				stk.pop();
    			}
    			else {
    				return false;
    			}
    			// if character is '}', check if top of stack has a '{'
     		   // if yes, pop this '{' from stack
    		} else if(c == '}') {
    			if(!stk.isEmpty() && stk.peek() == '{') {
    				stk.pop();
    			}
    			else {
    				return false;
    			}
    		} else {
    			
    			// if bracket is any of opening brackets,
    			// push it into stack
    			stk.push(s.charAt(i));
    		}
    	  }
    	}
    	
    	
    	// at the end of expression,
    	// check if any brackets left in stack,
    	// if yes, then expression is not valid
    	// else it is valid
    	if(stk.isEmpty()) {
    		return true;
    	} else {
    		return false;
    	}
    }

	public static void main(String[] args) {
		
		_1_a_BalancingSymbolsUsingStack mainClass = new _1_a_BalancingSymbolsUsingStack();
		
		String s = "(A+B)-(E+G^Y^H)";
		System.out.println("Given expression: " + s);
		boolean isTrue = mainClass.isValidSymbolPattern(s);
		if(isTrue) 
			System.out.println("It has valid symbol pattern");
		 else 
			System.out.println("It does not have valid symbol pattern");

	}

}
