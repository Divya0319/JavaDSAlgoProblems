package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

public class _1_g_CheckStringIsPalindromeWithXInMiddle_WithoutStack{
	
	public boolean isPalindrome(String inp) {
		
		int i = 0, j = inp.length() - 1;
		
		
		// making i point to start
		// and j point to end
		// keep on increasing i, and decreasing j
		// and checking if i and j values have same character
		while(i < j && inp.charAt(i) == inp.charAt(j)) {
			i++;
			j--;
		}
		
		// This condition comes true only when 
		// previous while loop breaks when
		// i and j index positions 
		// don't have same characters
		// and this will make i<j true
		if(i < j) 
			return false;
		
		
		// otherwise i becomes equal to j, 
		// and this happens only when string
		// is palindrome
		return true;
	}
	
	
	
	public static void main(String[] args) {
		
		String inp = "abcdtrXrodcba";
		
		_1_g_CheckStringIsPalindromeWithXInMiddle_WithoutStack mainClass = new _1_g_CheckStringIsPalindromeWithXInMiddle_WithoutStack();
		
		boolean isPalindrome = mainClass.isPalindrome(inp);
		
		System.out.println("Is given string palindrome? : " + isPalindrome);
				
		
	}

}
