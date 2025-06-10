package main.java.NarasimhaKarumanchi.java.t003_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t003_Stacks.LinkedStack;

public class _1_c_PostfixEvaluation {
	
	public int evaluatePostFix(String s) {
		LinkedStack<Integer> stk = new LinkedStack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// if input character is digit(operand)
			// push it into stack
			// after converting character to number
			if(Character.isDigit(c)) {
				stk.push(c - '0');
			}
			
			// else when input character is operator
			else {
				
				// pop two operands from stack one by one
				int val1 = stk.pop();
				int val2 = stk.pop();
				
				// operate onto operands by placing 
				// 2nd popped operand at first position
				// in calculation
				
				// and push the result back to stack
				switch(c) {
				case '-' : stk.push(val2-val1);
				break;
				case '+' : stk.push(val2+val1);
				break;
				case '*' : stk.push(val2*val1);
				break;
				case '/' : stk.push(val2/val1);
				break;
				case '^' : stk.push(pow(val2, val1));
				break;
				}
			}
		}
		
		
		// finally, pop the calculated result
		// and put in output
		return stk.pop();
	}
	
	
	// custom power function
	// to calculate power of integer constants
	// given as input
	public int pow(int val1, int n) {
		int result = 1;
		for(int i = 0; i < n; i++) {
			
			// multiplying the previously calculated result 
			// with 'val1' again and again, 'n' times. 
			result = result * val1;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		_1_c_PostfixEvaluation mainClass = new _1_c_PostfixEvaluation();
		
		String exp = "252^+9-";
		System.out.println("Given postfix expression: " + exp);
        System.out.println("Result after evaluation: " + mainClass.evaluatePostFix(exp));

	}

}
