package main.java.NarasimhaKarumanchi.java.t012_Graphs.t02_Problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.java.NarasimhaKarumanchi.java.t005_Trees.LinkedQueue;
import main.java.NarasimhaKarumanchi.java.t012_Graphs.Graph;


public class p002_CycleDetectionInUndirectedGraphsUsingBFS {
	
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
				boolean ans = isCyclicBFS(i);
				
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
		p002_CycleDetectionInUndirectedGraphsUsingBFS mainClass = new p002_CycleDetectionInUndirectedGraphsUsingBFS();
		
		
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
			System.out.println( "Cycle present?: " + mainClass.cycleDetection(n, m));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
