package main.java.NarasimhaKarumanchi.java._9_c_Graphs;

import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedQueue;

public class Practice {
	
	int timestamp = 0;
	public int orangesRotting(int[][] grid) throws Exception {
		
		int m = grid.length;
		int n = grid[0].length;
		LinkedQueue<Node> q = new LinkedQueue<>();
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 2) {
					q.enQueue(new Node(0, i ,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node temp = q.deQueue();
			
			if(temp.x-1 >= 0 && grid[temp.x-1][temp.y] == 1) {
				q.enQueue(new Node(temp.timestamp + 1, temp.x-1, temp.y));
				grid[temp.x-1][temp.y] = 2; 
				timestamp = temp.timestamp + 1;
			}
			
			if(temp.x+1 < m && grid[temp.x+1][temp.y] == 1) {
				q.enQueue(new Node(temp.timestamp + 1, temp.x+1, temp.y));
				grid[temp.x+1][temp.y] = 2; 
				timestamp = temp.timestamp + 1;
			}
			
			if(temp.y+1 < n && grid[temp.x][temp.y+1] == 1) {
				q.enQueue(new Node(temp.timestamp + 1, temp.x, temp.y+1));
				grid[temp.x][temp.y+1] = 2; 
				timestamp = temp.timestamp + 1;
			}
			
			if(temp.y-1 >= 0 && grid[temp.x][temp.y-1] == 1) {
				q.enQueue(new Node(temp.timestamp + 1, temp.x, temp.y-1));
				grid[temp.x][temp.y-1] = 2; 
				timestamp = temp.timestamp + 1;
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					return -1;
				}
			}
		}
		
		return timestamp;
	}
	
	// T.C. is O(n*m) because every element is going into queue atmost once
	// S.C. is O(n*m) because of queue used
	
	public static void main(String[] args) {
		Practice mainClass = new Practice();
		
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
		int timestamp;
		int x,y;
		
		public Node(int timestamp, int x, int y) {
			this.timestamp = timestamp;
			this.x = x;
			this.y = y;
		}
		
		
	}

}
