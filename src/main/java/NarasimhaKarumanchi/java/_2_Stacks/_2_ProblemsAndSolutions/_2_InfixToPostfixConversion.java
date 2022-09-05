package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._2_Stacks.StackUsingLinkedList;

public class _2_InfixToPostfixConversion {
	
	public static int Prec(char c) {
		switch(c) 
		{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':	
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}
	
	public String infixToPostFix(String exp) {
		String result = new String("");
		StackUsingLinkedList<Character> stk = new StackUsingLinkedList<>();
		
		for(int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			
			if(Character.isLetterOrDigit(c)) {
				result += c;
			}
			else if(c == '(') {
				stk.push(c);
			} else if(c == ')') {
				while(!stk.isEmpty() && stk.peek() != '(') 
					result += stk.pop();
				
					stk.pop();
			} else if(c == '^') {
				stk.push(c);
			} else {
				while(!stk.isEmpty() && Prec(c) <= Prec(stk.peek())) {
					result += stk.pop();
				}
				
				stk.push(c);
			}
		}
		
		while(!stk.isEmpty()) {
			if(stk.peek() == '(') {
				return "Invalid expression";
			}
			
			result += stk.pop();
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		
		_2_InfixToPostfixConversion mainClass = new _2_InfixToPostfixConversion();
		
		String s = "(A+B)-(E+G^Y^H)";
		System.out.println("Given infix expression: " + s);
        System.out.println("Postfix: " + mainClass.infixToPostFix(s));

	}

}
