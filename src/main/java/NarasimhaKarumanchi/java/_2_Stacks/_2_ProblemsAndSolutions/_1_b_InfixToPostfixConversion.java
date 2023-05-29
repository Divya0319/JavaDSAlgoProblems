package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_b_InfixToPostfixConversion {
	
	
	/*	Precedence order
	 *    '^'   >   '/'  >  '*'  >  '+/-'
	 */
	public int Prec(char c) {
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
		LinkedStack<Character> stk = new LinkedStack<>();
		
		for(int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			
			
			// if input character is an operand
			// add it to result
			if(Character.isLetterOrDigit(c)) {
				result += c;
			}
			
			// if character is opening parenthesis,
			// push to stack
			else if(c == '(') {
				stk.push(c);
			} else if(c == ')') {
				
				// and when character is closing parenthesis
				// check if stack is not empty 
				// pop from stack until opening parenthesis
				// is encountered
				while(!stk.isEmpty() && stk.peek() != '(') { 
					result += stk.pop();
				}	
				
				// pop the opening parenthesis as well
				stk.pop();
					
				// since '^' precedence is highest 
				// among all operators
				// push it to stack
			} else if(c == '^') {
				stk.push(c);
			} else {
				
				// if current operator precedence is less than
				// precedence of operator on stack's top
				// pop operators from stack and put to result
				// until an operator with higher precedence is
				// encountered in input
				while(!stk.isEmpty() && Prec(c) <= Prec(stk.peek())) {
					result += stk.pop();
				}
				
				// push the current operator(higher precedence) into stack
				stk.push(c);
			}
		}
		
		while(!stk.isEmpty()) {
			
			// if '(' left on top of stack
			// expression is not balanced 
			if(stk.peek() == '(') {
				return "Invalid expression";
			}
			
			// else
			// pop remaining operators from stack
			// and put into result
			result += stk.pop();
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		
		_1_b_InfixToPostfixConversion mainClass = new _1_b_InfixToPostfixConversion();
		
		String s = "(A+B)-(E+G^Y^H)";
		System.out.println("Given infix expression: " + s);
        System.out.println("Postfix: " + mainClass.infixToPostFix(s));

	}

}
