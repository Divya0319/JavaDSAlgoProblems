package main.java.NarasimhaKarumanchi.java._7_GreedyApproaches;

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
 * So, we will try out all combinations, and among those combinations, we will take the best total value giving combination, 
 * using Recursion.
 * 
 */
public class _1_b_0_1_KnapSack {	
	
	
	public int _01_KnapsackSolution(int ind, int W, int[] wt, int[] val, int[][] dp) {
		
		if(ind == 0) {
			if(wt[0] <= W) {
				return val[0];
			} else {
				return 0;
			}
		}
		
		int notTake = 0 + _01_KnapsackSolution(ind - 1, W, wt, val, dp);
		
		int take = Integer.MIN_VALUE;
		
		if(wt[ind] <= W) {
			take = val[ind] + _01_KnapsackSolution(ind - 1, W - wt[ind], wt, val, dp);
		}
		
		
		
		return dp[ind][W] = Math.max(notTake, take);
		
	}
	
	
	public static void main(String[] args) {
		
		_1_b_0_1_KnapSack mainClass = new _1_b_0_1_KnapSack();
		
		int[] wt = new int[] {3, 4, 6, 5};
		int[] val = new int[] {2, 3, 1, 4};
		
		int maxWeight = 8;
		
		int n = wt.length;
		
		int[][] dp = new int[n][maxWeight+1];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= maxWeight; j++) {
				dp[i][j] = -1;
			}
		}
		
		int maxProfit = mainClass._01_KnapsackSolution(n - 1, maxWeight, wt, val, dp);
		
		System.out.println("Max profit: " + maxProfit);
		
		
	}
	

}
