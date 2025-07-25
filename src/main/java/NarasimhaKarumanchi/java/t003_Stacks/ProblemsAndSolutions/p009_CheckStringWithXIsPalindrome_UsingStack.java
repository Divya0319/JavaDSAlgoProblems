package main.java.NarasimhaKarumanchi.java.t003_Stacks.ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t003_Stacks.FixedArrayStack;

public class p009_CheckStringWithXIsPalindrome_UsingStack<T> {
	
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
						
		p009_CheckStringWithXIsPalindrome_UsingStack<Character> mainClass = new p009_CheckStringWithXIsPalindrome_UsingStack<>();
		
		String inp = "aabccdXdccbaa";
		
		System.out.println("Given string: " + inp);
				
		boolean isPalindrome = mainClass.isPalindrome(inp.toCharArray());
		
		System.out.println("Is given string palindrome? : " + isPalindrome);
				
		
	}

}
