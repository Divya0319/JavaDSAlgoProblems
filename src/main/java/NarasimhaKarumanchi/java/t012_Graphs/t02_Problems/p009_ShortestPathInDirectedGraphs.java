package main.java.NarasimhaKarumanchi.java.t012_Graphs.t02_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.NarasimhaKarumanchi.java.t003_Stacks.LinkedStack;
import main.java.NarasimhaKarumanchi.java.t012_Graphs.DirectedGraph;
import main.java.NarasimhaKarumanchi.java.t012_Graphs.Pair;

public class p009_ShortestPathInDirectedGraphs {

	static Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
	static Map<Integer, Boolean> visited = new HashMap<>();
	LinkedStack<Integer> stk = new LinkedStack<>();
	static ArrayList<Integer> dist = new ArrayList<>();

	public void getShortestPath(int src) {
		
		dist.set(src, 0);
		
		while(!stk.isEmpty()) {
			int top = stk.peek();
			stk.pop();
			
			if(dist.get(top) != Integer.MAX_VALUE) {
				if(adj.get(top) != null) {
					for(Pair<Integer, Integer> i : adj.get(top)) {
						if(dist.get(top) + i.second < dist.get(i.first)) {
							dist.set(i.first, dist.get(top) + i.second);
						}
					}
				}
			}
		}

		
	}

	public static void main(String[] args) {
		int n = 6;
		int m = 9;

		p009_ShortestPathInDirectedGraphs mainClass = new p009_ShortestPathInDirectedGraphs();
		DirectedGraph g = new DirectedGraph();
		
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 2, 2);
		g.addEdge(1, 3, 6);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);
		
		g.printAdj();
		
		adj = g.getAdjecancyList();
		
		// topological sort
		for(int i = 0; i < n; i++) {
			if(!visited.getOrDefault(i, false)) {
				mainClass.dfs(i);
			}
		}
				
		
		int src = 1;
		
		for(int i = 0; i < n; i++) {
			dist.add(Integer.MAX_VALUE);
		}

		mainClass.getShortestPath(src);
		
		System.out.println("Answer is: ");
		
		for(int i = 0; i < dist.size(); i++) {
			System.out.print(dist.get(i) + " ");
		}
		
		System.out.println();

	}
	
	public void dfs(int node) {
		visited.put(node, true);
		
		if(adj.get(node) != null) {
			for(Pair<Integer, Integer> neighbour : adj.get(node)) {
				if(!visited.getOrDefault(neighbour.first, false)) {
					dfs(neighbour.first);
				}
			}
		}
		
		stk.push(node);
	}

}
