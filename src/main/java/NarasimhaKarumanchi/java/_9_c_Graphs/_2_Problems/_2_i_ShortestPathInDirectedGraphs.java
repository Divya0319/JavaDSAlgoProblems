package main.java.NarasimhaKarumanchi.java._9_c_Graphs._2_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.java.NarasimhaKarumanchi.java._3_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java._9_c_Graphs.Graph;

public class _2_i_ShortestPathInDirectedGraphs {

	static Map<Integer, List<Integer>> adj = new HashMap<>();
	
	public void addEdge(int u, int v) {
		
		int newu = u - 1;
		int newv = v - 1;
		
		adj.computeIfAbsent(newu, val -> new ArrayList<>()).add(newv);
		
	}

	public boolean cycleDetection(int v, int e) throws Exception {

		// create adj list

		// Kahn's algorithm

		// find all indegrees
		ArrayList<Integer> indegree = new ArrayList<>();

		for (int i = 0; i < v; i++) {
			indegree.add(0);
		}

		for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
			if (entry.getValue() != null) {
				for (Integer j : entry.getValue()) {
					int pv = indegree.get(j);
					pv = pv + 1;
					indegree.set(j, pv);
				}
			}
		}

		// 0 indegree walon ko queue mein push kar do
		LinkedQueue<Integer> q = new LinkedQueue<>();

		for (int i = 0; i < v; i++) {
			if (indegree.get(i) == 0) {
				q.enQueue(i);
			}
		}

		// do bfs

		int cnt = 0;

		while (!q.isEmpty()) {
			int front = q.first();
			q.deQueue();

			// inc cnt
			cnt++;

			List<Integer> ns = adj.get(front);

			if (ns != null) {
				for (Integer neighbour : ns) {
					int pv = indegree.get(neighbour);
					pv = pv - 1;
					indegree.set(neighbour, pv);

					if (indegree.get(neighbour) == 0) {
						q.enQueue(neighbour);
					}
				}
			}
		}

		if(cnt == v) {
			return false;
		} else {
			return true;
		}
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
		_2_i_ShortestPathInDirectedGraphs mainClass = new _2_i_ShortestPathInDirectedGraphs();

		for (int i = 0; i < m; i++) {
			int u, v;
			u = sc.nextInt();
			v = sc.nextInt();

			// creating a directed graph
			mainClass.addEdge(u, v);
		}

		sc.close();

//		adj = g.getAdjacencyListMap();

		try {
			System.out.println("Cycle Present? " + mainClass.cycleDetection(n, m));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
