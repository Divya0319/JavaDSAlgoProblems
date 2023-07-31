package main.java.NarasimhaKarumanchi.java._7_GreedyApproaches;

/*
 * 0-1 Knapsack problem solved using simple understandable approach of Dynamic Programming - Tabulation method
 * 
 * 
 */
public class _1_f_0_1_KnapSack_DP_Pepcoding_Approach {	
	
	
	public int _01_KnapsackSolution(int[] wt, int[] val, int n, int maxWeight) {
		
		int[][] dp = new int[n+1][maxWeight+1]; // bcz for 7 balls, we have 8 columns(0 to 7)
												// and for 5 players we have 6 rows(0 to 5)
		
		
		// we start from 1st row and 1st column and not 0th row and column, because they are all zeroes
		// means when there is no balls, or when there are no players, no runs scored
		for(int i = 1; i < dp.length; i++) {  //no. of rows - represent player
			for(int j = 1; j < dp[0].length; j++) { // no. of columns - represent balls
				
				// and our 2d array's i value coincides with our wt or val array's i-1 value(all zeroes in 1st column and row)
				
				if(j >= wt[i-1]) {     // when i has sufficient balls
					
					int rCap = j - wt[i-1]; // remaining number of balls from j after i has played his balls, given by wt[i-1]
					
					if(dp[i-1][rCap] + val[i-1] > dp[i-1][j]) { // if runs scored by previous players in no. of balls left after he plays + runs scored by i in his balls
																// is greater than runs when i doesn't play and allows its previous players to play
					dp[i][j] = dp[i-1][rCap] + val[i-1];
					
					} else {
						dp[i][j] = dp[i-1][j];  // when i doesn't bat because its previous players can score more runs in j balls
					}
					
				} else {
					dp[i][j] = dp[i-1][j]; // when i doesn't bat bcz there are insufficient balls, he gives chance for its previous players
											// to play
				}
				
				
			}
		}
		return dp[n][maxWeight];  // returning right-down most value from dp array
		
	}
	
	
	public static void main(String[] args) {
		
		_1_f_0_1_KnapSack_DP_Pepcoding_Approach mainClass = new _1_f_0_1_KnapSack_DP_Pepcoding_Approach();
		
		int[] wt = new int[]{2, 5, 1, 3, 4};
		int[] val = new int[]{15, 14, 10, 45, 30};
		
		int maxWeight = 7;
		
		int n = wt.length;
		
		int maxProfit = mainClass._01_KnapsackSolution(wt, val, n, maxWeight);
		
		System.out.println("Max profit: " + maxProfit);
		
		
	}
	

}
