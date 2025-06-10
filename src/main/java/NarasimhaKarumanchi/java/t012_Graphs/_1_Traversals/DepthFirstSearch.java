package main.java.NarasimhaKarumanchi.java.t012_Graphs._1_Traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.java.NarasimhaKarumanchi.java.t012_Graphs.Graph;

public class DepthFirstSearch {
	
	private static Map<Integer, List<Integer>> adjList;
	private ArrayList<Integer> component;
	Map<Integer, Boolean> visited;
	
		
	public void dfs(int node) throws Exception{
		component.add(node);
		visited.put(node, true);
		
		// har connected node ke liye recursive call
		for(int i : adjList.get(node)) {
			if(visited.getOrDefault(i, false) == false) {
				dfs(i);
			}
		}
		
		
	}
	
	public ArrayList<Integer> depthFirstSearch(int v) throws Exception{
		
		visited = new HashMap<>();
		component = new ArrayList<>();
		
		ArrayList<Integer> ans = new ArrayList<>();
		for(Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			if(visited.getOrDefault(entry.getKey(), false) == false) {
				dfs(entry.getKey());
				ans.addAll(component);
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
		DepthFirstSearch mainClass = new DepthFirstSearch();
		
		
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
			System.out.println( "DFS traversal: " + mainClass.depthFirstSearch(n));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
