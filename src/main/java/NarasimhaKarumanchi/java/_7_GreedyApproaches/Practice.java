package main.java.NarasimhaKarumanchi.java._7_GreedyApproaches;

import java.util.ArrayList;
import java.util.Collections;


public class Practice {
	
	private int solution(int n, int maxWeight, int[] wt, int[] val) {
		
		int[][]dp = new int[n][maxWeight+1];
		
		for(int W = wt[0]; W <= maxWeight; W++) {
			dp[0][W] = val[0];
		}
		
		for(int ind = 1; ind < n; ind++) {
			for(int W = 0; W <= maxWeight; W++) {
				int notTake = 0 + dp[ind-1][W];
				
				int take = Integer.MIN_VALUE;
				
				if(wt[ind] <= W) {
					take = val[ind] + dp[ind-1][W - wt[ind]];
				}
				
				dp[ind][W] = Math.max(notTake, take);
			}
		}
		
		
		
		return dp[n-1][maxWeight];
	}
	
	
	public static void main(String[] args) {
		Practice p = new Practice();
		
		int[] val = new int[] {30, 40, 60};
		int[] wt = new int[] {3, 2, 4};
				
		int capacity = 6;	
		
		int maxProfit = p.solution(val.length, capacity, wt, val);
		
		System.out.println("Maximum profit: " + maxProfit);
		
	}

}
