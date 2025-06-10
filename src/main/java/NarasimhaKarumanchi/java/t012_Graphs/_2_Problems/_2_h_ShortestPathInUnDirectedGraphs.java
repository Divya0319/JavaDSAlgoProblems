package main.java.NarasimhaKarumanchi.java.t012_Graphs._2_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;
import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedQueue;
import main.java.NarasimhaKarumanchi.java.t012_Graphs.LinkedList;

public class _2_h_ShortestPathInUnDirectedGraphs {

	static Map<Integer, List<Integer>> adj = new HashMap<>();
	
	public void addEdge(int u, int v) {
		
		adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
		adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
		
	}

	public LinkedList<Integer> shortestPath(int v, int e, int s, int d) throws Exception {
		
		// do bfs
		Map<Integer, Boolean> visited = new HashMap<>();
		Map<Integer, Integer> parent = new HashMap<>();
		LinkedQueue<Integer> q = new LinkedQueue<>();
		
		q.enQueue(s);
		
		visited.put(s, true);
		
		parent.put(s, -1);
		
		while(!q.isEmpty()) {
			int front = q.getFront().getData();
			q.deQueue();
			
			for(Integer i : adj.get(front)) {
				if(!visited.getOrDefault(i, false)) {
					visited.put(i, true);
					parent.put(i, front);
					q.enQueue(i);
				}
			}
		}
		
		// prepare shortest path
		LinkedList<Integer> ans = new LinkedList<>();
		int currentNode = d;
		ans.insert(d);
		
		while(currentNode != s) {
			currentNode = parent.get(currentNode);
			ans.insert(currentNode);
		}
		
		// reverse linked list
		LinkedList<Integer> reversed = reverseLL(ans);
		
		return reversed;
		
	}
	
	public LinkedList<Integer> reverseLL(LinkedList<Integer> ll) {
		
		ListNode<Integer> head = ll.getHead();
		ListNode<Integer> curr = head, prev = null;
		
		while(curr != null) {
			ListNode<Integer> next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		
		LinkedList<Integer> result = new LinkedList<>();
		result.insert(prev.getData());
		prev = prev.getNext();
		
		while(prev != null) {
			result.insert(prev.getData());
			prev = prev.getNext();
		}
		
		return result;
	}

	public static void main(String[] args) {
		int n;
		int m;
		int s;
		int d;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes");
		n = sc.nextInt();
		System.out.println("Enter the number of edges");
		m = sc.nextInt();
		System.out.println("Enter source node");
		s = sc.nextInt();
		System.out.println("Enter destination node");
		d = sc.nextInt();

//		Graph<Integer> g = new Graph<>(n);
		_2_h_ShortestPathInUnDirectedGraphs mainClass = new _2_h_ShortestPathInUnDirectedGraphs();

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
			System.out.println("Shortest path from " + s + " to " + d + " is " + mainClass.shortestPath(n, m, s, d));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
