package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._9_c_Algos_Generic.Pair;

public class _6_CheckForIdenticalTrees {
	
	
	
	public boolean isIdentical(BinaryTreeNode<Integer> r1, BinaryTreeNode<Integer> r2) {
		
		if(r1 == null && r2 == null) {
			return true;
		}
		
		if(r1 == null && r2 != null) {
			return false;
		}
		
		if(r1 != null && r2 == null) {
			return false;
		}
		
		boolean left = isIdentical(r1.getLeft(), r2.getLeft());
		boolean right = isIdentical(r1.getRight(), r2.getRight());
		
		boolean currNode = r1.getData() == r2.getData();
		
		if(left && right && currNode) {
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		_6_CheckForIdenticalTrees mainClass = new _6_CheckForIdenticalTrees();
		
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
		
		BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(4);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(6);
		
		root2.setLeft(n1);
		root2.setRight(n2);
		n1.setLeft(n3);
		n3.setLeft(n4);
		n2.setRight(n5);
		
		
		System.out.println(mainClass.isIdentical(root1, root2));
	}

}
