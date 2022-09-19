package main.java.NarasimhaKarumanchi.java._4_Trees._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;

public class _1_c_SearchElementInTree_Recursive<T> {
	
	private boolean searchInBinaryTree(BinaryTreeNode<T> root, int target) {
		if (root == null)
			return false;
		if ((Integer) root.getData() == target) {
			return true;
		}
		return searchInBinaryTree(root.getLeft(), target) || searchInBinaryTree(root.getRight(), target);
	}
	
	public static void main(String[] args) {
		_1_c_SearchElementInTree_Recursive<Integer> bt = new _1_c_SearchElementInTree_Recursive<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));
		
		System.out.println(bt.searchInBinaryTree(btn, 90));

	}

}
