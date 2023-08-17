package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;

public class _1_HeightOfTree {
	
	public int findHeight(BinaryTreeNode<Integer> node) {
		
		// base case
		if(node == null) {
			return 0;
		}
		
		int left = findHeight(node.getLeft());
		int right = findHeight(node.getRight());
		
		return Math.max(left, right) + 1;
		
	}
	
	public static void main(String[] args) {
		_1_HeightOfTree mainClass = new _1_HeightOfTree();
		
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
		
		
		System.out.println(mainClass.findHeight(root));
	}

}
