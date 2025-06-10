package main.java.NarasimhaKarumanchi.java.t012_Graphs._2_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.LinkedStack;
import main.java.NarasimhaKarumanchi.java.t012_Graphs.Graph;


public class _2_e_TopologicalSortInDAGUsingDFS {
	
	static Map<Integer, List<Integer>> adj = new HashMap<>();
	Map<Integer, Boolean> visited = new HashMap<>();
	Map<Integer, Boolean> dfsVisited = new HashMap<>();
	
	public void topoSort(int node, Map<Integer, Boolean> visited, LinkedStack<Integer> s, Map<Integer, List<Integer>> adj) {
		visited.put(node, true);
		
		List<Integer> ns = adj.get(node);
		
		if(ns != null) {
			for(Integer n : ns) {
				if(!visited.getOrDefault(n, false)) {
					topoSort(n, visited, s, adj);
				}
			}
		}
		
		s.push(node);
	}
	
	public ArrayList<Integer> topologicalSort(int v, int e) {
		
		// create adj list
		
		// call dfs topological sort util function for all components
		LinkedStack<Integer> s = new LinkedStack<Integer>();
		for(int i = 0; i < v; i++) {
			if(!visited.getOrDefault(i, false)) {
				topoSort(i, visited, s, adj);
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(!s.isEmpty()) {
			ans.add(s.peek());
			s.pop();
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
		_2_e_TopologicalSortInDAGUsingDFS mainClass = new _2_e_TopologicalSortInDAGUsingDFS();
		
		
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
