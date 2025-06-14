package main.java.NarasimhaKarumanchi.java.t005_Trees.t03_FANNG_Problems;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java.t012_Graphs.Pair;

public class p007_SumTree {
	
	
	
	public Pair<Boolean, Integer> isSumFast(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return new Pair<>(true, 0);
		}
		
		if(root.getLeft() == null && root.getRight() == null) {
			return new Pair<>(true, root.getData());
		}
		
		Pair<Boolean, Integer> left = isSumFast(root.getLeft());
		Pair<Boolean, Integer> right = isSumFast(root.getRight());
		
		boolean isLeftSum = left.first;
		boolean isRightSum = right.first;
		
		boolean isSumTree = root.getData() == (left.second + right.second);
		
		if(isLeftSum && isRightSum && isSumTree) {
			return new Pair<>(true, 2*(root.getData()));
		} else {
			return new Pair<>(false, 0);
		}
		
	}
	
	public boolean isSum(BinaryTreeNode<Integer> root) {
		
		return isSumFast(root).first;
		
	}
	
	public static void main(String[] args) {
		p007_SumTree mainClass = new p007_SumTree();
		
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(4);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(6);
		
		root1.setLeft(node1);
		root1.setRight(node2);
		node1.setLeft(node3);
		node3.setLeft(node4);
		node2.setRight(node5);
		
		System.out.println(mainClass.isSum(root1));
	}

}
