package com.dsalgoproblems.javaproblems;

import java.util.Stack;

public class CompressWord {
	
	public static String compressWord(String word, int k) {
		
		// 1. first, insert the first element of word, into wordStack
		// 2. then check if top of counterStack is equal to k's value
		// 3. if it is not,  
		// 4. check if top of wordStack equals next element of word
		// 5. if it is, then store top of counterStack in a variable, and pop top of counterStack,
		// 6. and then, increment stored top by 1, then store it back in counterStack
		// 7. and push the current word element into word stack
		// 8. if top of wordStack not equals next element of word, push it into wordStack, and push "1" into 
		// counterStack.
		// 9. if top of counterStack equals k' value, then pop the top of wordStack k times, and repeat 
		// for remaining elements of word
		// 10. After all elements of string are over, check once again if top of counterStack is k,
		// if it is, pop wordStack k times, else, simply print the compressed string.
		
		
		Stack<Character> wordStack = new Stack<>();
		Stack<Integer> counterStack = new Stack<>();
		
		
		char[] wordArray = word.toCharArray();
		
		int i = 0;
		while(i < wordArray.length) {
			
		if(wordStack.isEmpty()) {
			
			wordStack.push(wordArray[i]);
			counterStack.push(1);
			i++;
			
		}
		else if(counterStack.peek() != k) {
			
			char item = wordArray[i];
			
				if(wordStack.peek() == item) {
					
					int top = counterStack.pop();
					
					top++;
					
					counterStack.push(top);
					wordStack.push(item);
				
				
				} else {
					
					wordStack.push(item);
					counterStack.push(1);
				}
				i++;
				
			} else {
				
				for ( int j = 0; j < k; j++) {
					
					char popped = wordStack.pop();
					System.out.println("Popped element: " + popped);
				}
				
				counterStack.pop();
			}
		
		
		}
		
		if(counterStack.peek() == k) {
			
			for ( int j = 0; j < k; j++) {
				
				char popped = wordStack.pop();
				System.out.println("Popped element: " + popped);
			}
			
			
		}
		

						
			
		String finalWord = wordStack.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(", ", "");
		System.out.println("Counter stack: " + counterStack.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(", ", ""));
		

		return finalWord;
		
	}
	
	public static void main(String[] args) {
		
		String inputWord = "aba";
		int consec = 2;
		System.out.println("Input word: " + inputWord  + "\n");
		System.out.println("Compressed word: " + compressWord(inputWord, consec) + "\n");
		
	}

}
