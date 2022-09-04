package main.java.NarasimhaKarumanchi.java._4_Trees._1_Traversals;

import java.util.ArrayList;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.StackUsingLinkedList;

public class _4_Inorder_Iterative<T> {
	private ArrayList<T> inorderIterative(BinaryTreeNode<T> root) {
		ArrayList<T> res = new ArrayList<>();
		if (root == null)
			return res;
		StackUsingLinkedList<BinaryTreeNode<T>> s = new StackUsingLinkedList<>();
		BinaryTreeNode<T> currentNode = root;
		while (true) {
			while (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.getLeft();
			}
			if (s.isEmpty())
				break;

			currentNode = s.pop();
			res.add(currentNode.getData());
			currentNode = currentNode.getRight();

		}

		return res;
	}
	public static void main(String[] args) {	
		_4_Inorder_Iterative<Integer> bt = new _4_Inorder_Iterative<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));

		ArrayList<Integer> res2 = bt.inorderIterative(btn);
		System.out.println(res2.toString());
	}
}
