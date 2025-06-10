package main.java.NarasimhaKarumanchi.java.t005_Trees._1_Traversals;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;

public class _1_Preorder_Recursive<T> {
	
	private void preorderRecursive(BinaryTreeNode<T> root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			preorderRecursive(root.getLeft());
			preorderRecursive(root.getRight());
		}
	}
	
	public static void main(String[] args) {
		_1_Preorder_Recursive<Integer> bt = new _1_Preorder_Recursive<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));

		bt.preorderRecursive(btn);
	}

}
