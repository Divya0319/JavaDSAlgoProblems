package main.java.NarasimhaKarumanchi.java.t006_Recursion;


public class p003_PalindromeCheckUsingRecursion {

	/*
	 * Takes O(n) worst case time(T(n) = T(n-2) + O(n)), 
	 * and O(n) auxiliary space for recursion stack(takes n/2 space actually)
	 */
	static boolean isPalindrome(String s, int start, int end) {
		
		if(start >= end) // handling both cases here, start=end happens when string becomes of length 0 for even length,
						// and start>end happened when string becomes of length 1 for odd length
		{ 
			return true; 
		}
		/*
		 * Checking first start and end characters are same, if they are, then only we make call for 
		 * check of shrunk string
		 */
		return (s.charAt(start) == s.charAt(end) && isPalindrome(s, start+1, end-1));
		
	}

	public static void main(String[] args) {
		String inp = "jabbaj";
		System.out.println("Is " + inp + " palindrome? " + isPalindrome(inp, 0, inp.length() - 1));

	}

}
