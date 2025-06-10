package main.java.NarasimhaKarumanchi.java.t009_DynamicProgramming;

public class _1_b_LengthOfLongestCommonSubsequence_UsingTabulation {	
	
	public int lcs(String X, String Y, int m, int n) {
		
		int dp[][] = new int[m+1][n+1];
		
		
		for(int i = 1; i < m+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(X.charAt(i-1) == Y.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[m][n];
	}
	
	
	
	public static void main(String[] args) {
		
		_1_b_LengthOfLongestCommonSubsequence_UsingTabulation mainClass = new _1_b_LengthOfLongestCommonSubsequence_UsingTabulation();
		
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		
		int m = X.length();
		int n = Y.length();
		
		
		int lcsLength = mainClass.lcs(X, Y, m, n);
		
		System.out.println("LCS Length: " + lcsLength);
		
				
		
	}
	

}