package main.java.NarasimhaKarumanchi.java;

import java.util.Stack;

public class CompressWord {
	
//		A student decides to perform some operations on 
//	big words to compress them, so they become easy 
//	to remember. An operation consists of choosing a 
//	group of Kconsecutive equal characters and 
//	removing them. The student keeps performing this 
//	operation as long as it is possible. Determine the 
//	final word after the operation is performed.
//
//	Example
//	word = "abbcccb" 
//	k = 3
//
//
//  Remove k = 3 characters 'c', now word = "abbb".
//  Remove 3 characters 'b' so the final word is "a".
//
//	It can be easily proven that the final word will be 
//	unique. Also, it is guaranteed that the final word 
//	consists of at least one character.
//
//	Function Description
//	Complete the function compress Word in the editor 
//	below.
//
//	compressWord has the following parameter(s): 
//  string word: a string of lowercase English letters 
//  int k: the number of consecutive equal
//	characters
//
//	Returns:
//  string : denotes the final word.
//
//	Constraints
//  1 < |word| <= 10^5
//  1 < k <= |word|
//
//
//  	Input Format For Custom Testing
//	The first line contains a string, word, that 
//	denotes the word that needs to be shortened.
//
//	The first line contains a string, "word", that 
//	denotes the word that needs to be shortened. 
//	The second line contains a single integer, k, that 
//	denotes the number of consecutive characters 
//	that can be removed in one operation.
//
//	-  Sample Case 0
//	Sample Input For Custom Testing 
//
// 	STDIN  Function
//	------- --------
// 	 aba  ->  word = "aba"
// 	  2   ->  k = 2
//	Sample Output 
//
//	 aba
//	Explanation
//
//	There are no consecutive equal characters to be 
//	removed. So, the final word stays intact "aba".
//
//	STDIN Function
//	----- --------
//	aba -> word = "aba"
//	 2  -> k = 2
//
//	Sample Output 
//
//	aba
//
//	Explanation
//	There are no consecutive equal characters to be 
//	removed. So, the final word stays intact "aba".
//
//	 Sample Case 1
//
//	Sample Input For Custom Testing 
//
//	STDIN   Function
//	-----   --------
// 	baac -> word = "baac" 
// 	2    -> k = 2
//
//	Sample Output 
//
// 	bc
//
//	Explanation
//	Remove k=2 characters 'a' and the final word = "bc"

	
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
