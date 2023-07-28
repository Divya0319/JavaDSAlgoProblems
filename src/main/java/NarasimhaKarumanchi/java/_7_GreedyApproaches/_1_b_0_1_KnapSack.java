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
 * So, we go with Dynamic Programming approach here
 */
public class _1_b_0_1_KnapSack {
	
	public static void main(String[] args) {
		
	}

}
