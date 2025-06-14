package main.java.NarasimhaKarumanchi.java.t008_GreedyApproaches.p003_LengthOfLongestCommonSubsequence_UsingRecursion;


public class p002_LengthOfLongestCommonSubsequence_UsingRecursion_Memoization {
	
	public int lcs(String X, String Y, int m, int n,int[][] dp) {
		if(m == 0 || n == 0) 
			return 0;
		
		if(dp[m][n] != -1) {
			return dp[m][n];
		}
		
		if(X.charAt(m-1) == Y.charAt(n-1)) {
			dp[m][n] = 1 + lcs(X, Y, m-1, n-1, dp);
		} else {
			dp[m][n] =  Math.max(
					lcs(X, Y, m-1, n, dp),
					lcs(X, Y, m, n-1, dp));
		}
		
		return dp[m][n];
	}
	
	
	
	public static void main(String[] args) {
		
		p002_LengthOfLongestCommonSubsequence_UsingRecursion_Memoization mainClass = new p002_LengthOfLongestCommonSubsequence_UsingRecursion_Memoization();
		
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		
		int m = X.length();
		int n = Y.length();
		
		int[][] dp = new int[m+1][n+1];		
		
		for(int i = 0; i < m+1; i++) {
			for(int j = 0; i < n+1; j++) {
				dp[i][j] = -1;
			}
		}
		int lcsLength = mainClass.lcs(X, Y, m, n, dp);
		
		System.out.println("LCS Length: " + lcsLength);
		
				
		
	}
	

}