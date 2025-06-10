package main.java.NarasimhaKarumanchi.java.t005_Trees._3_FANNG_Problems;

import java.util.ArrayList;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;

public class _4_i_BoundaryTraversal {
	
	ArrayList<Integer> ans;
	
	
	void traverseLeft(BinaryTreeNode<Integer> root) {
		
		// base case
		if((root == null) || (root.getLeft() == null && root.getRight() == null)) {
			return;
		}
		
		ans.add(root.getData());
		
		if(root.getLeft() != null) {
			traverseLeft(root.getLeft());
		} else {
			traverseLeft(root.getLeft());
		}
	}
	
	void traverseLeaf(BinaryTreeNode<Integer> root) {
		// base case
		if(root == null) {
			return;
		}
		if(root.getLeft() == null && root.getRight() == null) {
			ans.add(root.getData());
			return;
		}
		
		traverseLeaf(root.getLeft());
		
		traverseLeaf(root.getRight());
		
	}
	
	void traverseRight(BinaryTreeNode<Integer> root) {
		// base case
		if((root == null) || (root.getLeft() == null && root.getRight() == null)) {
			return;
		}
		
		if(root.getRight() != null) {
			traverseRight(root.getRight());
		} else {
			traverseRight(root.getLeft());
		}
		
		ans.add(root.getData());
	}

	ArrayList<Integer> boundaryTraversal(BinaryTreeNode<Integer> root) {
		ans = new ArrayList<>();
				
		if(root == null) {
			return ans;
		}
		
		ans.add(root.getData());
		
		// first print left nodes from root, excluding leaf nodes
		traverseLeft(root.getLeft());
		
		
		// then print all leaf nodes
		
		// left sub tree
		traverseLeaf(root.getLeft());
		// right sub tree
		traverseLeaf(root.getRight());
		
		
		// then print right nodes from root, excluding leaf nodes, but print in reverse
		traverseRight(root.getRight());
		
		return ans;
		
	}

	public static void main(String[] args) {
		_4_i_BoundaryTraversal mainClass = new _4_i_BoundaryTraversal();

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

		System.out.println(mainClass.boundaryTraversal(root1));
	}

}
