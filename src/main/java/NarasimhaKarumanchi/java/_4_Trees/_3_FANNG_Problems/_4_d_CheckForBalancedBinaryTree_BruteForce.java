package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;

public class _4_d_CheckForBalancedBinaryTree_BruteForce {
	
	
	public boolean isBalanced(BinaryTreeNode<Integer> node) {
		// base case
		
		if(node == null) {
			return true;
		}
		
		boolean left = isBalanced(node.getLeft());
		boolean right = isBalanced(node.getRight());
		boolean diff = Math.abs(height(node.getLeft()) - height(node.getRight())) <= 1;
		
		if(left && right && diff) {
			return true;
		}
		
		return false;

		
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
		_4_d_CheckForBalancedBinaryTree_BruteForce mainClass = new _4_d_CheckForBalancedBinaryTree_BruteForce();
		
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
		
		
		System.out.println(mainClass.isBalanced(root));
	}

}
