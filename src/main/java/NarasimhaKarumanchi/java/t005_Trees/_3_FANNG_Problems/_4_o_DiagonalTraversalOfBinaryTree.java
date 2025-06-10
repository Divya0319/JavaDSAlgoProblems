package main.java.NarasimhaKarumanchi.java.t005_Trees._3_FANNG_Problems;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;

public class _4_o_DiagonalTraversalOfBinaryTree {
	
	Map<Integer, ArrayList<Integer>> hm;

	ArrayList<Integer> diagonalTraversal(BinaryTreeNode<Integer> root) {
		
		ArrayList<Integer> ans = new ArrayList<>();
		hm = new TreeMap<>();
		
		verticalOrder(root, 0);
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry : hm.entrySet()) {
			ans.addAll(entry.getValue());
		}
		
		return ans;
		
	}
	
	public void verticalOrder(BinaryTreeNode<Integer> root, int hd) {
		if(root == null) {
			return;
		}
		
		ArrayList<Integer> ans = hm.get(hd);
		if(ans == null) {
			ans = new ArrayList<>();
			ans.add(root.getData());
		} else {
			ans.add(root.getData());
		}
		
		hm.put(hd, ans);
		
		verticalOrder(root.getLeft(), hd+1);
		verticalOrder(root.getRight(), hd);
	}

	public static void main(String[] args) {
		_4_o_DiagonalTraversalOfBinaryTree mainClass = new _4_o_DiagonalTraversalOfBinaryTree();

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

		System.out.println(mainClass.diagonalTraversal(root));
	}

}
