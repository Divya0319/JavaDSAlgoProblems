package main.java.NarasimhaKarumanchi.java.t005_Trees._1_Traversals;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;

public class _3_Inorder_Recursive<T> {
	private void inorderRecursive(BinaryTreeNode<T> root) {
		if (root != null) {
			inorderRecursive(root.getLeft());
			System.out.print(root.getData() + " ");
			inorderRecursive(root.getRight());
		}
	}
	public static void main(String[] args) {	
		_3_Inorder_Recursive<Integer> bt = new _3_Inorder_Recursive<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));

		bt.inorderRecursive(btn);
	}
}
