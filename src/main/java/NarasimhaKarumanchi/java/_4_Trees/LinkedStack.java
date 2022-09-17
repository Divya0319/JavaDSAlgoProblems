package main.java.NarasimhaKarumanchi.java._4_Trees;

import java.util.EmptyStackException;
import java.util.Stack;


public class LinkedStack<T> implements StackService<T> {
	
	static Stack<Integer> stk = new Stack<>();
	
	private int length;
	private ListNode<T> top;
	
	public LinkedStack() {
		length = 0;
		top = null;
	}
	
	public void push(T data) {
		ListNode<T> temp = new ListNode<>(data);
		temp.setNext(top);
		top = temp;
		length++;
	}
	
	public T pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		
		T result = top.getData();
		top = top.getNext();
		length--;
		return result;
	}
	
	public T peek() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		
		return top.getData();
	}
	
	public ListNode<T> getTop() {
		return top;
	}
	
	public void setTop(ListNode<T> top) {
		this.top = top;
	}
	
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public int size() {
		return length;
	}
	
	public String toString() {
		String result = "";
		ListNode<T> current = top;
		while(current != null) {
			result = result + current.getData() + " ";
			current = current.getNext();
		}
		
		return result;
	}
	
	public boolean isValidSymbolPattern(String s) {
    	Stack<Character> stk = new Stack<>();
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
		Stack<Character> stk = new Stack<>();
		
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
	
	public int evaluatePostFix(String s) {
		Stack<Integer> stk = new Stack<>();
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
	
	public int infixEvaluationIn1Pass(String expr) {
		Stack<Integer> opnds = new Stack<>();
        Stack<Character> optors = new Stack<>();
        
        for(int i = 0; i < expr.length(); i++) {
        	char ch = expr.charAt(i);
        	
        	if(ch == '(') {
        		optors.push(ch);
        		
        	} else if(Character.isDigit(ch)) {
        		opnds.push(ch - '0'); //char to int
        		
        	} else if(ch == ')') {
        		while(optors.peek() == '(') {
        			char optor = optors.pop();
        			int v2 = opnds.pop();
        			int v1 = opnds.pop();
        			
        			opnds.push(operation(v1, v2, optor));
        		}
        		
        		optors.pop();
        		
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
        
        while(optors.size() != 0) {
			char optor = optors.pop();
			int v2 = opnds.pop();
			int v1 = opnds.pop();
			
			opnds.push(operation(v1, v2, optor));
		}
        
        return opnds.peek();
	}
	
	public static void reverse() {
		if(stk.size() > 0) {
		int x = stk.pop();
		reverse();
		insertAtBottom(x);
		}
		
	}
	
	public static void insertAtBottom(int ele) {
		
		if(stk.size() == 0) {
			stk.push(ele);
		} else {
			int a = stk.pop();
			insertAtBottom(ele);
			stk.push(a);
		}
		
	}
	
	
	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<>();
		try {
			stack.push(6);
			System.out.println(stack.toString());
			stack.push(8);
			System.out.println(stack.toString());
			stack.push(4);
			System.out.println(stack.toString());
			stack.push(34);
			System.out.println(stack.toString());
			stack.push(6);
			System.out.println(stack.toString());
			stack.push(3);
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());

			System.out.println("Top: " + stack.peek());
			
			String s = "(A+B)-(E+G^Y^H)";
	        System.out.println(Boolean.toString(stack.isValidSymbolPattern(s)));
	        System.out.println(stack.infixToPostFix(s));
	        String exp = "252^+9-";
	        System.out.println(stack.evaluatePostFix(exp));
	        
	        String expr = "2-3*6";
	        System.out.println(stack.infixEvaluationIn1Pass(expr));
	        
	        stk.push(2);
	        stk.push(6);
	        stk.push(4);
	        stk.push(9);
	        stk.push(5);
	        stk.push(1);
	        
	        System.out.println("Stack printing begins");
	        
	        Stack<Integer> newStack = new Stack<>();
	        while(!stk.isEmpty()) {
	        	newStack.push(stk.peek());
	        	
	        	System.out.println(newStack.peek());
	        	stk.pop();
	        }
	        
	        reverse();
	        System.out.println("Reversing");
	        
	        stk = newStack;
	        
	        Stack<Integer> bnewStack = new Stack<>();
	        while(!stk.isEmpty()) {
	        	bnewStack.push(stk.peek());
	        	
	        	System.out.println(bnewStack.peek());
	        	stk.pop();
	        }
	        

	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class QueueUsingTwoStacks<T> {
	private LinkedStack<T> s1 = new LinkedStack<>();
	private LinkedStack<T> s2 = new LinkedStack<>();
	
	public void enQueue(T data) {
		s1.push(data);
	}
	
	public T deQueue() throws Exception {
		int i = 0, size;
		if(s2.isEmpty()) {
			size = s1.size();
			while(i < size - 1) {
				s2.push(s1.pop());
				i++;
			}
			return s1.pop();
		} else 
			return s2.pop();
	}
	
	public String toString() {
		String result = "";
			try {
				if(s2.isEmpty()) {
//					if(s1.isEmpty()) {
//						return result;
//					}
//					int x = s1.pop();
//					toString();
//					System.out.print(x + " ");
//					s1.push(x);
					LinkedStack<T> tempStack = new LinkedStack<>();
					ListNode<T> top = s1.getTop();
					while(top != null) {
						tempStack.push(top.getData());
						top = top.getNext();
					}
					while(!tempStack.isEmpty()) {
						result += tempStack.pop() + " ";
					}

					
				} else {
					ListNode<T> top1 = s1.getTop();
					LinkedStack<T> tempStack = new LinkedStack<>();
					ListNode<T> top2 = s2.getTop();
					while(top2 != null) {
						result += top2.getData() + " ";
						top2 = top2.getNext();
					}
					while(top1 != null) {
						tempStack.push(top1.getData());
						top1 = top1.getNext();
					}
					while(!tempStack.isEmpty()) {
						result += tempStack.pop() + " ";
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		return result;
	}
	
	public static void main(String[] args) {
		try {
		QueueUsingTwoStacks<Integer> quts = new QueueUsingTwoStacks<>();
		quts.enQueue(1);
		System.out.println(quts.toString());
		quts.enQueue(2);
		System.out.println(quts.toString());
		quts.enQueue(3);
		System.out.println(quts.toString());
		quts.enQueue(4);
		System.out.println(quts.toString());
		quts.enQueue(5);
		System.out.println(quts.toString());
		quts.deQueue();
		System.out.println(quts.toString());
		quts.enQueue(6);
		System.out.println(quts.toString());
		quts.deQueue();
		System.out.println(quts.toString());
		quts.enQueue(7);
		System.out.println(quts.toString());
		quts.enQueue(8);
		System.out.println(quts.toString());
		quts.deQueue();
		System.out.println(quts.toString());
		quts.deQueue();
		System.out.println(quts.toString());
		quts.deQueue();
		System.out.println(quts.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
