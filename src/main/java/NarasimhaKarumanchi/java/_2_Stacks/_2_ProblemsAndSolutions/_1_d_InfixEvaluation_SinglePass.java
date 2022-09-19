package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;

public class _1_d_InfixEvaluation_SinglePass {
	
	public int evaluatePostFix(String s) {
		LinkedStack<Integer> stk = new LinkedStack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(Character.isDigit(c)) {
				stk.push(c- '0');
			} else {
				int val1 = stk.pop();
				int val2 = stk.pop();
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
		
		return stk.pop();
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
		
		String exp = "252^+9-";
		System.out.println("Given postfix expression: " + exp);
        System.out.println("Result after evaluation: " + mainClass.evaluatePostFix(exp));

	}

}
