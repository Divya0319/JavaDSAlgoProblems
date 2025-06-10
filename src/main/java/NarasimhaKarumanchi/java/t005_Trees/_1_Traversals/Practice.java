package main.java.NarasimhaKarumanchi.java.t005_Trees._1_Traversals;

import main.java.NarasimhaKarumanchi.java.t004_Queues.LinkedQueue;

public class Practice {

	public int maxElementIter(Node root) {
		int MAX = Integer.MIN_VALUE;

		try {
			
		
			if(root == null) {
				return Integer.MIN_VALUE;
			}
			
			LinkedQueue<Node> q = new LinkedQueue<>();
			q.enQueue(root);
			
			while(!q.isEmpty()) {
				Node temp = q.deQueue();
				if(temp.val > MAX) {
					MAX = temp.val;
				}
				
				if(temp.left != null) {
					q.enQueue(temp.left);
				}
				
				if(temp.right != null) {
					q.enQueue(temp.right);
				}
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return MAX;
	}

	public static void main(String[] args) {
		Practice main = new Practice();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n9 = new Node(9);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n1.left = n2;
		n1.right = n9;
		n2.left = n4;
		n2.right = n5;
		n9.left = n6;
		n9.right = n7;

		System.out.println("Maximum element in tree: " + main.maxElementIter(n1));

	}

	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
}
