package main.java.NarasimhaKarumanchi.java.t005_Trees.t03_FANNG_Problems;

import java.util.ArrayList;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;

public class p014_RightViewOfBinaryTree {
	ArrayList<Integer> ans = new ArrayList<>();


	ArrayList<Integer> rightView(BinaryTreeNode<Integer> root) {
		
		solve(root, 0);
		
		return ans;

	}
	
	void solve(BinaryTreeNode<Integer> root, int lvl) {
		if(root == null) {
			return;
		}
		
		// we entered into a new level
		if(lvl == ans.size()) {
			ans.add(root.getData());
		}
		
		solve(root.getRight(), lvl+1);
		solve(root.getLeft(), lvl+1);
	}

	public static void main(String[] args) {
		p014_RightViewOfBinaryTree mainClass = new p014_RightViewOfBinaryTree();

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

		System.out.println(mainClass.rightView(root));
	}

}
