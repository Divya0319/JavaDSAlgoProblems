package main.java.NarasimhaKarumanchi.java._9_c_Graphs._2_Problems;

import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedQueue;


public class RottenOrangeProblem_FollowsBFS {
	
	public int orangesRotting(int[][] grid) throws Exception {
		int m = grid.length;
		int n = grid[0].length;
		
		LinkedQueue<Node> q = new LinkedQueue<>();
		
		int timeFrameFinal = 0;
		
		// scanning all elements of grid one by one
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				// if a 2 is found, store its coordinates in queue
				if(grid[i][j] == 2) {
					// timeframe will be 0 initially for all oranges
					q.enQueue(new Node(0, i, j));
				}
			}
		}
		
		// we start rotting all adjacent oranges from here now
		while(!q.isEmpty()) {
			Node temp = q.deQueue();
			
			// left orange is unrotten
			if(temp.x - 1 >= 0 && grid[temp.x - 1][temp.y] == 1) {
				// add it to queue for future adjacency check
				// and rot this orange as well
				timeFrameFinal = temp.timeframe + 1;
				q.enQueue(new Node(temp.timeframe + 1, temp.x - 1, temp.y));
				grid[temp.x - 1][temp.y] = 2;
			}
			
			// above orange is unrotten
			if(temp.y - 1 >= 0 && grid[temp.x][temp.y - 1] == 1) {
				// add it to queue for future adjacency check
				// and rot this orange as well
				timeFrameFinal = temp.timeframe + 1;
				q.enQueue(new Node(temp.timeframe + 1, temp.x, temp.y - 1));
				grid[temp.x][temp.y - 1] = 2;
			}
			
			// right orange is unrotten
			if(temp.x + 1 < m && grid[temp.x + 1][temp.y] == 1) {
				// add it to queue for future adjacency check
				// and rot this orange as well
				timeFrameFinal = temp.timeframe + 1;
				q.enQueue(new Node(temp.timeframe + 1, temp.x + 1, temp.y));
				grid[temp.x + 1][temp.y] = 2;
			}
			
			// below orange is unrotten
			if(temp.y + 1 < n && grid[temp.x][temp.y + 1] == 1) {
				// add it to queue for future adjacency check
				// and rot this orange as well
				timeFrameFinal = temp.timeframe + 1;
				q.enQueue(new Node(temp.timeframe + 1, temp.x, temp.y + 1));
				grid[temp.x][temp.y + 1] = 2;
			}
			
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					return -1;
				}
			}
		}
		
		return timeFrameFinal;
		
		
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
	
	class Node {
		int timeframe;
		int x,y;
		
		public Node(int timeframe, int x, int y) {
			this.timeframe = timeframe;
			this.x = x;
			this.y = y;
		}
	}

}
