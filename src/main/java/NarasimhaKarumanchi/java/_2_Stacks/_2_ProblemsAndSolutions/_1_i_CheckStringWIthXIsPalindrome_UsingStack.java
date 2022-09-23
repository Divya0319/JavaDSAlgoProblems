package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._2_Stacks.FixedArrayStack;

public class _1_i_CheckStringWithXIsPalindrome_UsingStack<T> {
	
	public boolean isPalindrome(char[] inp) {
		
		FixedArrayStack<Character> stk = new FixedArrayStack<>(inp.length);
		
		int i = 0;
		
		try {
			while(inp[i] != 'X') {
				stk.push(inp[i]);
				
				i++;
			}
			
			i++;
			
			while(i < inp.length) {
				if(stk.isEmpty()) return false;
				
				if(inp[i] != stk.pop()) return false;
				
				i++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return true;
		
	}
	
	
	
	public static void main(String[] args) {
						
		_1_i_CheckStringWithXIsPalindrome_UsingStack<Character> mainClass = new _1_i_CheckStringWithXIsPalindrome_UsingStack<>();
		
		String inp = "aabccdXdccbaa";
		
		System.out.println("Given string: " + inp);
				
		boolean isPalindrome = mainClass.isPalindrome(inp.toCharArray());
		
		System.out.println("Is given string palindrome? : " + isPalindrome);
				
		
	}

}
