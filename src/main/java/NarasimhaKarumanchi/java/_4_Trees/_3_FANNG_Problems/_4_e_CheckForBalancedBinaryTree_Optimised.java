package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._9_c_Algos_Generic.Pair;

public class _4_e_CheckForBalancedBinaryTree_Optimised {
	
	public Pair<Boolean, Integer> isBalancedFast(BinaryTreeNode<Integer> node) {
		// base case
		
		if(node == null) {
			return new Pair<>(true, 0);
		}
		
		Pair<Boolean, Integer> left = isBalancedFast(node.getLeft());
		Pair<Boolean, Integer> right = isBalancedFast(node.getRight());
		
		boolean leftAns = left.first;
		boolean rightAns = right.first;
		
		boolean diff = Math.abs(left.second - right.second) <= 1;
		
		int ansSecond = Math.max(left.second, right.second) + 1;
		
		boolean ansFirst;
		
		if(leftAns && rightAns && diff) {
			ansFirst = true;
		}
		
		else 
			ansFirst = false;
		
		return new Pair<>(ansFirst, ansSecond);
	}
	
	
	public boolean isBalanced(BinaryTreeNode<Integer> node) {
		
		return isBalancedFast(node).first;

		
	}
	
	public static void main(String[] args) {
		_4_e_CheckForBalancedBinaryTree_Optimised mainClass = new _4_e_CheckForBalancedBinaryTree_Optimised();
		
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
