package main.java.NarasimhaKarumanchi.java.t009_DynamicProgramming;

public class p003_PrintLongestCommonSubsequence_UsingTabulation {
	
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
		
		// Following code is used to print LCS
		
		int index = dp[m][n];
		
		int temp = index;
		
		// an extra length is to store null character
		char[] lcsString = new char[index+1];
		
		lcsString[index] = '\0';
		
		// Start from the right-most-bottom-most corner and
        // one by one store characters in dp[]
		int i = m;
		int j = n;
		
		while(i > 0 && j > 0) {
			
			// If current character in X and Y are same,
            // then current character is part of LCS
			if(X.charAt(i-1) == Y.charAt(j-1)) {
				
				// Put current character in result
				lcsString[index-1] = X.charAt(i-1);
				
				// reduce values of i, j and index
				i--;
				j--;
				index--;
			} else if(dp[i-1][j] > dp[i][j-1]){
				i--;
			} else {
				j--;
			}
		}
		
		// Printing the lcs
		
		System.out.print("LCS of " + X + " and " + Y + " is ");
		
		for(int k = 0; k < temp+1; k++) {
				System.out.print(lcsString[k]);
		}
		
		System.out.println();
		
		return dp[m][n];
	}
	
	
	
	public static void main(String[] args) {
		
		p003_PrintLongestCommonSubsequence_UsingTabulation mainClass = new p003_PrintLongestCommonSubsequence_UsingTabulation();
		
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		
		int m = X.length();
		int n = Y.length();
		
		
		int lcsLength = mainClass.lcs(X, Y, m, n);
		
		System.out.println("LCS Length: " + lcsLength);
		
				
		
	}
	

}