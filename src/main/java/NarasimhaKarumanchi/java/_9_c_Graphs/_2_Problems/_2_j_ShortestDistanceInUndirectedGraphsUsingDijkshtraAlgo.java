package main.java.NarasimhaKarumanchi.java._9_c_Graphs._2_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.java.NarasimhaKarumanchi.java._2_Stacks.LinkedStack;
import main.java.NarasimhaKarumanchi.java._9_c_Graphs.Pair;

public class _2_j_ShortestDistanceInUndirectedGraphsUsingDijkshtraAlgo {

	static Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
	static Map<Integer, Boolean> visited = new HashMap<>();
	LinkedStack<Integer> stk = new LinkedStack<>();
	static ArrayList<Integer> dist = new ArrayList<>();
	
	public void addEdge(int u, int v, int w) {
		
		adj.computeIfAbsent(u, val -> new ArrayList<>()).add(new Pair<>(v, w));
		adj.computeIfAbsent(v, val -> new ArrayList<>()).add(new Pair<>(u, w));
		
	}
	
	public void printAdj() {
		for(Map.Entry<Integer, List<Pair<Integer, Integer>>> entry : adj.entrySet()) {
				
				System.out.print(entry.getKey() + "->");
				
				for(Pair<Integer, Integer> j : entry.getValue()) {
					System.out.print("(" + j.first + "," + j.second + "),");
				}
				System.out.println();
				
			
		}
	}
	
	
	public ArrayList<Integer> dijkstra(int vertices, int edges, int source) {
		// create adjacency list
		
		ArrayList<Integer> dist = new ArrayList<>();
		
		// creation of distance array with infinite value
		for(int i = 0; i < vertices; i++) {
			dist.add(Integer.MAX_VALUE);
		}
		
		// creation of set on basis (distance, node)
		Set<Pair<Integer, Integer>> st = new HashSet<>();
		
		
		// initialise distance and set with source node
		dist.set(source, 0);
		
		st.add(new Pair<>(0, source));
		
		while(!st.isEmpty()) {
			
			// fetch top minimum record
			Pair<Integer, Integer> top = Collections.min(st, 
					(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) -> p1.second - p2.second);
			
			int nodeDistance = top.first;
			int topNode = top.second;
			
			// remove top record now
			st.remove(top);
			
			// traverse on neighbours
			for(Pair<Integer, Integer> neighbour : adj.get(topNode)) {
				if(nodeDistance + neighbour.second < dist.get(neighbour.first)) {
					
					Pair<Integer, Integer> record = new Pair<>(dist.get(neighbour.first), neighbour.first);
					// if record with same node exists in set
					if(st.contains(record)) {
						st.remove(record);
					}
					
					// distance update
					dist.set(neighbour.first, nodeDistance + neighbour.second);
					
					// record push in set
					st.add(new Pair<Integer, Integer>(dist.get(neighbour.first), neighbour.first));
				}
			}
		}
		
		return dist;
	}


	public static void main(String[] args) {
		int n = 5;
		int m = 7;

		_2_j_ShortestDistanceInUndirectedGraphsUsingDijkshtraAlgo mainClass = new _2_j_ShortestDistanceInUndirectedGraphsUsingDijkshtraAlgo();
		
		mainClass.addEdge(0, 1, 7);
		mainClass.addEdge(0, 2, 1);
		mainClass.addEdge(0, 3, 2);
		mainClass.addEdge(1, 2, 3);
		mainClass.addEdge(1, 3, 5);
		mainClass.addEdge(1, 4, 1);
		mainClass.addEdge(3, 4, 7);
		
		mainClass.printAdj();
				
		ArrayList<Integer> result = mainClass.dijkstra(n, m, 0);
		
		System.out.println("Distance array: " + result.toString());

	}

}
