package main.java.NarasimhaKarumanchi.java._9_c_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Graph {
	Map<Integer, ArrayList<Integer>> adj;
	int noOfVertices;
	
	public void addEdge(int u, int v, boolean direction) {
		// direction = false -> undirected graph
		// direction = true -> directed graph
		
		// create an edge from u to v
		adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
		
		if(!direction) {
			adj.computeIfAbsent(v,  val -> new ArrayList<>()).add(u);
		}
	}
	
	public Graph(int n) {
		adj = new HashMap<>();
		this.noOfVertices = n;
	}
	
	public void printAdjacencyList() {
		for(Map.Entry<Integer, ArrayList<Integer>> entry : adj.entrySet()) {
			System.out.print(entry.getKey() + "->");
				for(Integer i : entry.getValue()) {
					System.out.print(i + ", ");
				}
				
				System.out.println();
		}
	}
	
	public Map<Integer, ArrayList<Integer>> getAdjacencyListMap() {
		return adj;
	}
	
	public int size() {
		return noOfVertices;
	}
	
	public static void main(String[] args) {
		int n;
		int m;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes");
		n = sc.nextInt();
		System.out.println("Enter the number of edges");
		m = sc.nextInt();
		
		Graph g = new Graph(n);
		
		
		for(int i = 0; i < m; i++) {
			int u, v;
			u = sc.nextInt();
			v = sc.nextInt();
			
			// creating an undirected graph
			g.addEdge(u, v, false);
		}
		
		// printing graph
		g.printAdjacencyList();
		sc.close();
		
	}
}
