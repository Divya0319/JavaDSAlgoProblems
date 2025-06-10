package main.java.NarasimhaKarumanchi.java.t005_Trees.t03_FANNG_Problems;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java.t005_Trees.LinkedQueue;

public class p011_TopViewOfBinaryTree {

	ArrayList<Integer> topView(BinaryTreeNode<Integer> root) {
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		// base case
		if(root == null) {
			return ans;
		}
		
		Map<Integer, Integer> topNode = new TreeMap<>();
		LinkedQueue<Pair> q = new LinkedQueue<>();
		
		try {
			
			q.enQueue(new Pair(0, root));
			
			while(!q.isEmpty()) {
				Pair temp = q.deQueue();
				BinaryTreeNode<Integer> frontNode = temp.node;
				int hd = temp.hd;
				
				// if one value is present for a horizontal distance, then do nothing
				if(!topNode.containsKey(hd)) {
					topNode.put(hd, frontNode.getData());
				}
				
				if(frontNode.getLeft() != null) {
					q.enQueue(new Pair(hd-1, frontNode.getLeft()));
				}
				
				if(frontNode.getRight() != null) {
					q.enQueue(new Pair(hd+1, frontNode.getRight()));
				}
			}
			
			for(Map.Entry<Integer, Integer> entry : topNode.entrySet()) {
				ans.add(entry.getValue());
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return ans;

	}

	public static void main(String[] args) {
		p011_TopViewOfBinaryTree mainClass = new p011_TopViewOfBinaryTree();

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
		BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);
		BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(8);
		BinaryTreeNode<Integer> node9 = new BinaryTreeNode<>(9);

		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);
		node6.setRight(node8);
		node7.setRight(node9);

		System.out.println(mainClass.topView(root));
	}
	
	class Pair {
		int hd;
		BinaryTreeNode<Integer> node;
		
		public Pair(int hd, BinaryTreeNode<Integer> node) {
			this.hd = hd;
			this.node = node;
		}
	}

}
