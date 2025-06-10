package main.java.NarasimhaKarumanchi.java.t005_Trees.t03_FANNG_Problems;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;

public class p002_DiameterOfTree {
	
	public int diameter(BinaryTreeNode<Integer> node) {
		
		// base case
		
		if(node == null) {
			return 0;
		}
		
		int op1 = diameter(node.getLeft());
		int op2 = diameter(node.getRight());
		int op3 = height(node.getLeft())+ height(node.getRight()) + 1;
		
		int ans = Math.max(op1, Math.max(op2,  op3));
		
		return ans;
		
	}
	
	public int height(BinaryTreeNode<Integer> node) {
			
			// base case
			if(node == null) {
				return 0;
			}
			
			int left = height(node.getLeft());
			int right = height(node.getRight());
			
			return Math.max(left, right) + 1;
			
	}
	
	
	public static void main(String[] args) {
		p002_DiameterOfTree mainClass = new p002_DiameterOfTree();
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(4);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(6);
		
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node3.setLeft(node4);
		node2.setRight(node5);
		
		
		System.out.println(mainClass.diameter(root));
	}

}
