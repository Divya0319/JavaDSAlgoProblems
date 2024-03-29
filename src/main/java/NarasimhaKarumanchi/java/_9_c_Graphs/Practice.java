package main.java.NarasimhaKarumanchi.java._9_c_Graphs;

import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java._9_c_Graphs._2_Problems._2_a_RottenOrangeProblem_FollowsBFS;

public class Practice {
	
	public int rottenOranges(int[][] grid) throws Exception {
		int m = grid.length;
		int n = grid[0].length;
		
		LinkedQueue<Node> q = new LinkedQueue<>();
		
		int timeFrameFinal = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 2) {
					q.enQueue(new Node(0, i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node temp = q.deQueue();
			
			// right orange
			if(temp.x + 1 < m && grid[temp.x+1][temp.y] == 1) {
				grid[temp.x+1][temp.y] = 2;
				q.enQueue(new Node(temp.timeframe + 1, temp.x+1, temp.y));
				timeFrameFinal = temp.timeframe + 1;
			}
			
			// top orange
			if(temp.y - 1 >= 0 && grid[temp.x][temp.y - 1] == 1) {
				grid[temp.x][temp.y - 1] = 2;
				q.enQueue(new Node(temp.timeframe + 1, temp.x, temp.y - 1));
				timeFrameFinal = temp.timeframe + 1;
			}
			
			// below orange
			if(temp.y + 1 < m && grid[temp.x][temp.y + 1] == 1) {
				grid[temp.x][temp.y + 1] = 2;
				q.enQueue(new Node(temp.timeframe + 1, temp.x, temp.y + 1));
				timeFrameFinal = temp.timeframe + 1;
			}
			
			// left orange
			if(temp.x - 1 >= 0 && grid[temp.x-1][temp.y] == 1) {
				grid[temp.x-1][temp.y] = 2;
				q.enQueue(new Node(temp.timeframe + 1, temp.x-1, temp.y));
				timeFrameFinal = temp.timeframe + 1;
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
	
	public static void main(String[] args) {
		_2_a_RottenOrangeProblem_FollowsBFS mainClass = new _2_a_RottenOrangeProblem_FollowsBFS();

		int[][] grid = new int[][] {
			{2, 1, 0},
			{1, 1, 0},
			{0, 1, 1}
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
