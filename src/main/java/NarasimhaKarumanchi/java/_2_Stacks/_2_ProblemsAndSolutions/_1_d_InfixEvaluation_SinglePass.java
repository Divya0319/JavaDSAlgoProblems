package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_d_InfixEvaluation_SinglePass {
	
	public int infixEvaluationIn1Pass(String expr) {
		
		// Created two stacks
		// one for storing operands, other for storing operators
		LinkedStack<Integer> opnds = new LinkedStack<>();
		LinkedStack<Character> optors = new LinkedStack<>();
		for(int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);
			
			// if i/p character is '(',
			// push into operator stack
			if(ch == '(') {
				optors.push(ch);
				
			// but if i/p character is digit
			// push into operand stack, after converting to number
			} else if(Character.isDigit(ch)) {
				opnds.push(ch - '0');
				
			// when i/p character is ')',
			// until on top of stack '(' is seen,
			// pop two operands from operand stack, v1 & v2
			// and one operator from operator stack
			// perform operation as v2 op v1,
			// and put result into operand stack
			} else if(ch == ')') {
				while(optors.peek() != '(') {
					char optor = optors.pop();
					int v2 = opnds.pop();
					int v1 = opnds.pop();
					
					opnds.push(operation(v1, v2, optor));
				}
				
				// pop '(' from operator stack as well
				optors.pop();
				
			// if i/p character is any of +, -, *, / or ^
			} else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
				
				// ch is wanting higher priority operator to solve first
				while(optors.size() > 0 && optors.peek() != '(' && Prec(ch) <= Prec(optors.peek())) {
					char optor = optors.pop();
					int v2 = opnds.pop();
					int v1 = opnds.pop();
					
					opnds.push(operation(v1, v2, optor));
				}
				
				// ch is pushing itself now
				
				optors.push(ch);
			}
		}
		
		
		// if any operators left in stack
		while(optors.size() != 0) {
			
			// pop operands and operators
			char optor = optors.pop();
			int v2 = opnds.pop();
			int v1 = opnds.pop();
			
			
			// perform operation and push into operand stack
			opnds.push(operation(v1, v2, optor));
		}
		
		
		// after operator stack is empty,
		// return the result 
		return opnds.peek();
			
	}
	
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
	
	public int operation(int val1, int val2, char op) {
		switch(op) {
		case '-' : return val1-val2;

		case '+' : return val1+val2;

		case '*' : return val1*val2;

		case '/' : return val1/val2;

		case '^' : return pow(val1, val2);

		default:
			return -1;
		}
	}
	
	public int pow(int val1, int val2) {
		int result = 1;
		for(int i = 0; i < val2; i++) {
			result = result * val1;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		_1_d_InfixEvaluation_SinglePass mainClass = new _1_d_InfixEvaluation_SinglePass();
		
		String exp = "2^3*5";
		System.out.println("Given infix expression: " + exp);
        System.out.println("Result after evaluation: " + mainClass.infixEvaluationIn1Pass(exp));

	}

}
