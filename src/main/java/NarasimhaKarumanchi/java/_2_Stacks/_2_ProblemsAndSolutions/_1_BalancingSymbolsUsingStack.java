package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;


import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_BalancingSymbolsUsingStack {
	
	public boolean isValidSymbolPattern(String s) {
    	LinkedStack<Character> stk = new LinkedStack<>();
    	if(s == null || s.length() == 0) {
    		return true;
    	}
    	
    	for(int i = 0; i < s.length(); i++) {
    	   char c = s.charAt(i);
    	   if(c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
    		if(c == ')') {
    			if(!stk.isEmpty() && stk.peek() == '(') {
    				stk.pop();
    			}
    			else {
    				return false;
    			}
    		} else if(c == ']') {
    			if(!stk.isEmpty() && stk.peek() == '[') {
    				stk.pop();
    			}
    			else {
    				return false;
    			}
    		} else if(c == '}') {
    			if(!stk.isEmpty() && stk.peek() == '{') {
    				stk.pop();
    			}
    			else {
    				return false;
    			}
    		} else {
    			stk.push(s.charAt(i));
    		}
    	  }
    	}
    	
    	if(stk.isEmpty()) {
    		return true;
    	} else {
    		return false;
    	}
    }

	public static void main(String[] args) {
		
		_1_BalancingSymbolsUsingStack mainClass = new _1_BalancingSymbolsUsingStack();
		
		String s = "(A+B)-(E+G^Y^H)";
		System.out.println("Given expression: " + s);
		boolean isTrue = mainClass.isValidSymbolPattern(s);
		if(isTrue) 
			System.out.println("It has valid symbol pattern");
		 else 
			System.out.println("It does not have valid symbol pattern");

	}

}
