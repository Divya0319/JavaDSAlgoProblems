package main.java.NarasimhaKarumanchi.java.t005_Trees.t01_Traversals;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;

public class p005_Postorder_Recursive<T> {
	private void postOrderRecursive(BinaryTreeNode<T> root) {
		if (root != null) {
			postOrderRecursive(root.getLeft());
			postOrderRecursive(root.getRight());
			System.out.print(root.getData() + " ");

		}
	}
	public static void main(String[] args) {	
		p005_Postorder_Recursive<Integer> bt = new p005_Postorder_Recursive<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));

		bt.postOrderRecursive(btn);
	}
}
