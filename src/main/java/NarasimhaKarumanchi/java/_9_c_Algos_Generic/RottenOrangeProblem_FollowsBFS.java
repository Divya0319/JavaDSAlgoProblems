package main.java.NarasimhaKarumanchi.java._9_c_Algos_Generic;

import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedQueue;


public class RottenOrangeProblem_FollowsBFS {
	
	Pair<Integer, Integer> p;
	
	public int orangesRotting(int[][] grid) throws Exception {
		int m = grid.length;
		int n = grid[0].length;
		
		LinkedQueue<Pair<Integer, Integer>> q = new LinkedQueue<>();
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 2) {
					p = new Pair<>(i,j);
					q.enQueue(p);
				}
			}
		}
		
		// stores final result, how many minutes it took to rot all oranges
		int count = 0;
		
		// we need a partition after every cycle of rotting, so
		p = new Pair<>(-1, -1);
		q.enQueue(p);
		
		while(!q.isEmpty()) {
			// taking out ith and jth indices of all rotten oranges indices stored
			int i = q.getFront().getData().getLeft();
			int j = q.getFront().getData().getRight();
			
			if(i == -1 && j == -1 && q.size() == 1) {
				q.deQueue();
				break;
			} else if(i == -1 && j == -1 && q.size() > 1) {
				count++;
				q.deQueue();
				p = new Pair<>(-1, -1);
				q.enQueue(p);
			} else {
				if((i-1) >= 0 && grid[i-1][j] == 1) {
					grid[i-1][j] = 2;
					p = new Pair<>(i-1, j);
					q.enQueue(p);
				}
				
				if((j-1) >= 0 && grid[i][j-1] == 1) {
					grid[i][j-1] = 2;
					p = new Pair<>(i, j-1);
					q.enQueue(p);
				}
				
				if((i+1) < m && grid[i+1][j] == 1) {
					grid[i+1][j] = 2;
					p = new Pair<>(i+1, j);
					q.enQueue(p);
				}
				
				if((j+1) < n && grid[i][j+1] == 1) {
					grid[i][j+1] = 2;
					p = new Pair<>(i, j+1);
					q.enQueue(p);
				}
				
				// current index (orange) work is done, it has rotten its neighbours,
				// remove it now
				q.deQueue();
				
			}
		}
		

		// again checking whole grid, it any 1 is remaining, we return -1
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					return -1;
				}
			}
		}
		
		// not found any 1 in grid, so return count value
		
		return count;
		
	}
	
	// T.C. is O(n*m) because every element is going into queue atmost once
	// S.C. is O(n*m) because of queue used
	
	public static void main(String[] args) {
		RottenOrangeProblem_FollowsBFS mainClass = new RottenOrangeProblem_FollowsBFS();
		
		int[][] grid = new int[][] {
									{1, 1, 2},
									{0, 1, 2},
									{2, 1, 1}
									};
 		
		try {
 			System.out.println("Minutes taken: " + mainClass.orangesRotting(grid)); 
 		} catch(Exception ex) {
 			ex.printStackTrace();
 		}
	}

}
