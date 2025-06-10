package main.java.NarasimhaKarumanchi.java.t008_GreedyApproaches;


public class _1_f_LengthOfLongestCommonSubsequence_UsingRecursion {	
	
	public int lcs(String X, String Y, int m, int n) {
		if(m == 0 || n == 0) return 0;
		
		if(X.charAt(m-1) == Y.charAt(n-1)) {
			return 1 + lcs(X, Y, m-1, n-1);
		} else {
			return Math.max(
					lcs(X, Y, m-1, n),
					lcs(X, Y, m, n-1));
		}
	}
	
	
	
	public static void main(String[] args) {
		
		_1_f_LengthOfLongestCommonSubsequence_UsingRecursion mainClass = new _1_f_LengthOfLongestCommonSubsequence_UsingRecursion();
		
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		
		int lcsLength = mainClass.lcs(X, Y, X.length(), Y.length());
		
		System.out.println("LCS Length: " + lcsLength);
		
				
		
	}
	

}