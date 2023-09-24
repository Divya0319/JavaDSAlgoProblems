package main.java.NarasimhaKarumanchi.java._9_c_Graphs._1_Traversals;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;
import main.java.NarasimhaKarumanchi.java._9_c_Graphs.Graph;

public class BreadthFirstSearch {
	private int v;
	
	private static Map<Integer, ArrayList<Integer>> adjList;
	
	public BreadthFirstSearch(int v) {
		this.v = v;
	}
		
	public ArrayList<Integer> bfs(int start) throws Exception{
		boolean[] visited = new boolean[v];
		ArrayList<Integer> ans = new ArrayList<>();
		
		LinkedQueue<Integer> q = new LinkedQueue<>();
		
		visited[start] = true;
		
		q.enQueue(start);
		
		while(!q.isEmpty()) {
			start = q.deQueue();
			ans.add(start);
			
			ArrayList<Integer> n = adjList.get(start);
			
			for(int i = 0; i < n.size(); i++) {
				int node = n.get(i);
				if(!visited[node]) {
					visited[node] = true;
					q.enQueue(node);
				}
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int n;
		int m;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes");
		n = sc.nextInt();
		System.out.println("Enter the number of edges");
		m = sc.nextInt();
		
		Graph g = new Graph(n);
		BreadthFirstSearch mainClass = new BreadthFirstSearch(n);
		
		
		for(int i = 0; i < m; i++) {
			int u, v;
			u = sc.nextInt();
			v = sc.nextInt();
			
			// creating an undirected graph
			g.addEdge(u, v, false);
		}
		
		sc.close();
		
		g.printAdjacencyList();
		
		adjList = g.getAdjacencyListMap();
		
		try {
			System.out.println( "BFS traversal: " + mainClass.bfs(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
