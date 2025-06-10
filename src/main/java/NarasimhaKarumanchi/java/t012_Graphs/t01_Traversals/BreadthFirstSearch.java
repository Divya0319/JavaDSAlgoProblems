package main.java.NarasimhaKarumanchi.java.t012_Graphs.t01_Traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.java.NarasimhaKarumanchi.java.t005_Trees.LinkedQueue;
import main.java.NarasimhaKarumanchi.java.t012_Graphs.Graph;

public class BreadthFirstSearch {
	
	private static Map<Integer, List<Integer>> adjList;

		
	public ArrayList<Integer> bfs(int start) throws Exception{
		Map<Integer, Boolean> visited = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		LinkedQueue<Integer> q = new LinkedQueue<>();
		
		visited.put(start, true);
		
		q.enQueue(start);
		
		while(!q.isEmpty()) {
			start = q.deQueue();
			ans.add(start);
			
			List<Integer> n = adjList.get(start);
			
			for(int i = 0; i < n.size(); i++) {
				int node = n.get(i);
				if(!visited.getOrDefault(node, false) == false) {
					visited.put(node, true);
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
		
		Graph<Integer> g = new Graph<>(n);
		BreadthFirstSearch mainClass = new BreadthFirstSearch();
		
		
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
			System.out.println( "BFS traversal: " + mainClass.bfs(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
