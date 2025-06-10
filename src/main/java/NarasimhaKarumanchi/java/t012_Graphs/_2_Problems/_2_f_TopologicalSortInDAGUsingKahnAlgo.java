package main.java.NarasimhaKarumanchi.java.t012_Graphs._2_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java.t012_Graphs.Graph;


public class _2_f_TopologicalSortInDAGUsingKahnAlgo {
	
	static Map<Integer, List<Integer>> adj = new HashMap<>();

	
	public ArrayList<Integer> topologicalSort(int v, int e) throws Exception {
		
		// create adj list
		
		// Kahn's algorithm
		
		// find all indegrees
		ArrayList<Integer> indegree = new ArrayList<>();
		
		for(int i = 0; i < v; i++) {
			indegree.add(0);
		}
		
		for(Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
			if(entry.getValue() != null) {
				for(Integer j : entry.getValue()) {
					int pv = indegree.get(j);
					pv = pv + 1;
					indegree.set(j, pv);
				}
			}
		}
		
		// 0 indegree walon ko queue mein push kar do
		LinkedQueue<Integer> q = new LinkedQueue<>();
		
		for(int i = 0; i < v; i++) {
			if(indegree.get(i) == 0) {
				q.enQueue(i);
			}
		}
		
		// do bfs
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int front = q.first();
			q.deQueue();
			
			ans.add(front);
			
			List<Integer> ns = adj.get(front);
			
			if(ns != null) {
				for(Integer neighbour : ns) {
					int pv = indegree.get(neighbour);
					pv = pv - 1;
					indegree.set(neighbour, pv);
					
					if(indegree.get(neighbour) == 0) {
						q.enQueue(neighbour);
					}
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
		_2_f_TopologicalSortInDAGUsingKahnAlgo mainClass = new _2_f_TopologicalSortInDAGUsingKahnAlgo();
		
		
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
			System.out.println( "Topological sort: " + mainClass.topologicalSort(n, m));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
