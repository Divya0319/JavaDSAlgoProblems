package main.java.NarasimhaKarumanchi.java._9_c_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph {
	Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
	
	public void addEdge(int u, int v, int weight) {
		Pair<Integer, Integer> p = new Pair<>(v, weight);
		adj.computeIfAbsent(u, val -> new ArrayList<>()).add(p);
	}
	
	public void printAdj() {
		for(Map.Entry<Integer, List<Pair<Integer, Integer>>> entry : adj.entrySet()) {
				
				System.out.print(entry.getKey() + "->");
				
				if(entry.getValue() != null) {
					for(Pair<Integer, Integer> j : entry.getValue()) {
						System.out.print("(" + j.first + "," + j.second + "),");
					}
					System.out.println();
				}
			
		}
	}
	
	public Map<Integer, List<Pair<Integer, Integer>>> getAdjecancyList() {
		return adj;
	}
	
	public static void main(String[] args) {
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
		
		
	}
}
