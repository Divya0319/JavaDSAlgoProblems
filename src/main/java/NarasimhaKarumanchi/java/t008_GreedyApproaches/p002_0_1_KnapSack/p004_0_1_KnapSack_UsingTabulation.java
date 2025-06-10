package main.java.NarasimhaKarumanchi.java.t008_GreedyApproaches.p002_0_1_KnapSack;

/*
 * 0-1 Knapsack problem solved using Recursion
 * 
 * Greedy approach will not work here because, if we pick item having maximum profit first, considering only maximum profit,
 * then we might end up with only choosing 1 item from the given items, as it might take most of the space in bag, and
 * there might be other options for maximizing profit, but also not nearly or fully filling the bag with only 1 item.
 * 
 * As there might be no uniformity, that summing up profit of two other items might have more profit, 
 * than summing up single item having max profit.
 * 
 * Here we are converting Recursion + Dynamic Programming i.e. Memorization approach to Tabulation
 * which doesn't require recursion stack. And every calculation is performed and used from inside dp array itself.
 * 
 */
public class p004_0_1_KnapSack_UsingTabulation {
	
	
	public int _01_KnapsackSolution(int[] wt, int[] val, int n, int maxWeight) {
		
		int[][] dp = new int[n][maxWeight+1];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= maxWeight; j++) {
				dp[i][j] = 0;
			}
		}
		
		for(int W = wt[0]; W <= maxWeight; W++) {
			dp[0][W] = val[0];
		}
		
		for(int ind = 1; ind < n; ind++) {
			for(int W = 0; W <= maxWeight; W++) {
				int notTake = 0 + dp[ind - 1][W];
				
				int take = Integer.MIN_VALUE;
				
				if(wt[ind] <= W) {
					take = val[ind] + dp[ind - 1][W - wt[ind]];
				}
				
				
				
				dp[ind][W] = Math.max(notTake, take);
			}
		}
		
		 return dp[n-1][maxWeight];
		
	}
	
	
	public static void main(String[] args) {
		
		p004_0_1_KnapSack_UsingTabulation mainClass = new p004_0_1_KnapSack_UsingTabulation();
		
		int[] wt = new int[] {3, 4, 6, 5};
		int[] val = new int[] {2, 3, 1, 4};
		
		int maxWeight = 8;
		
		int n = wt.length;
		
		int maxProfit = mainClass._01_KnapsackSolution(wt, val, n, maxWeight);
		
		System.out.println("Max profit: " + maxProfit);
		
		
	}
	

}