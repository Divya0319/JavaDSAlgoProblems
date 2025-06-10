package main.java.NarasimhaKarumanchi.java.t012_Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Graph<T> {
	Map<T, List<T>> adj;
	int noOfVertices;
	
	public void addEdge(T u, T v, boolean direction) {
		// direction = false -> undirected graph
		// direction = true -> directed graph
		
		// create an edge from u to v
		adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
		
		if(!direction) {
			adj.computeIfAbsent(v,  val -> new ArrayList<>()).add(u);
		}
	}
	
	public Graph(int n) {
		adj = new TreeMap<>();
		this.noOfVertices = n;
	}
	
	public void printAdjacencyList() {
		for(Map.Entry<T, List<T>> entry : adj.entrySet()) {
			System.out.print(entry.getKey() + "->");
				for(T i : entry.getValue()) {
					System.out.print(i + ", ");
				}
				
				System.out.println();
		}
	}
	
	public Map<T, List<T>> getAdjacencyListMap() {
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
		
		Graph<Integer> g = new Graph<>(n);
		
		
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
