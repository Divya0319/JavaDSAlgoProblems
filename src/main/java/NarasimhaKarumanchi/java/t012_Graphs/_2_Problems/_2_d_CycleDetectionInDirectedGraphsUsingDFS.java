package main.java.NarasimhaKarumanchi.java.t012_Graphs._2_Problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.java.NarasimhaKarumanchi.java.t012_Graphs.Graph;


public class _2_d_CycleDetectionInDirectedGraphsUsingDFS {
	
	static Map<Integer, List<Integer>> adj = new HashMap<>();
	Map<Integer, Boolean> visited = new HashMap<>();
	Map<Integer, Boolean> dfsVisited = new HashMap<>();
	
	public boolean cycleDetection(int n) {
		for(int i = 1; i <= n; i++) {
			if(!visited.getOrDefault(i, false)) {
				boolean cycleFound = checkCycleDFS(i);
				
				if(cycleFound) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean checkCycleDFS(int node) {
		visited.put(node, true);
		dfsVisited.put(node, true);
		
		List<Integer> neighbours = adj.get(node);
		
		// excluding nodes from consideration, who have no outward edges from it(no neighbors)
		if(neighbours != null) {
			for(Integer neighbour : neighbours) {
				if(!visited.getOrDefault(neighbour, false)) {
					boolean cycleDetected = checkCycleDFS(neighbour);
					if(cycleDetected) {
						return true;
					}
				} else if(dfsVisited.getOrDefault(neighbour, false)) {
					return true;
				}
			}
		}
		
		dfsVisited.put(node, false);
		return false;
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
		_2_d_CycleDetectionInDirectedGraphsUsingDFS mainClass = new _2_d_CycleDetectionInDirectedGraphsUsingDFS();
		
		
		for(int i = 0; i < m; i++) {
			int u, v;
			u = sc.nextInt();
			v = sc.nextInt();
			
			// creating a directed graph
			g.addEdge(u, v, true);
		}
		
		sc.close();		
		
		adj = g.getAdjacencyListMap();
		
		try {
			System.out.println( "Cycle Present? " + mainClass.cycleDetection(n));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
