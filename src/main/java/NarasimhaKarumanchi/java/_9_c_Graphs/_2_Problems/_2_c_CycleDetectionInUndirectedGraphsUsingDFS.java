package main.java.NarasimhaKarumanchi.java._9_c_Graphs._2_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;
import main.java.NarasimhaKarumanchi.java._9_c_Graphs.Graph;


public class _2_c_CycleDetectionInUndirectedGraphsUsingDFS {
	
	static Map<Integer, List<Integer>> adj = new HashMap<>();
	Map<Integer, Boolean> visited = new HashMap<>();
	
	public boolean isCyclicBFS(int src) throws Exception{
		Map<Integer, Integer> parent = new HashMap<>();
		
		parent.put(src, -1);
		visited.put(src, true);
		
		LinkedQueue<Integer> q = new LinkedQueue<>();
		q.enQueue(src);
		
		while(!q.isEmpty()) {
			Integer front = q.deQueue();
			for(int neighbour: adj.get(front) ) {
				if(visited.getOrDefault(neighbour, false) && neighbour != parent.get(front)) {
					return true;
				} else if(!visited.getOrDefault(neighbour, false)) {
					q.enQueue(neighbour);
					visited.put(neighbour, true);
					parent.put(neighbour, front);
				}
			}
		}
		
		return false;
	}
	
	public boolean isCyclicDFS(int node, int parent) {
		visited.put(node, true);
		
		for(Integer neighbour : adj.get(node)) {
			if(!visited.getOrDefault(neighbour, false)) {
				boolean cycleDetected = isCyclicDFS(neighbour, node);
				
				if(cycleDetected) {
					return true;
				}
			} else if(neighbour != parent) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean cycleDetection(
			//List<List<Integer>> edges, 
			int n, int m) throws Exception {
		
		// create adjacency list
//		for(int i = 0; i < n; i++) {
//			int u = edges.get(i).get(0);
//			int v = edges.get(i).get(1);
//			
//			adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
//			adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
//		}
		
		// to handle disconnected components
		for(int i = 0; i < n; i++) {
			if(!visited.getOrDefault(i, false)) {
				boolean ans = isCyclicDFS(i, -1);
				
				if(ans) {
					return true;
				}
			}
		}
		
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
		_2_c_CycleDetectionInUndirectedGraphsUsingDFS mainClass = new _2_c_CycleDetectionInUndirectedGraphsUsingDFS();
		
		
		for(int i = 0; i < m; i++) {
			int u, v;
			u = sc.nextInt();
			v = sc.nextInt();
			
			// creating an undirected graph
			g.addEdge(u, v, false);
		}
		
		sc.close();		
		
		adj = g.getAdjacencyListMap();
		
		try {
			System.out.println( "DFS traversal: " + mainClass.cycleDetection(n, m));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
