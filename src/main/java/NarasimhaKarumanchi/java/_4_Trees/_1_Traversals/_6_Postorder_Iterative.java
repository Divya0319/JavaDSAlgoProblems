package main.java.NarasimhaKarumanchi.java._4_Trees._1_Traversals;

import java.util.ArrayList;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.StackUsingLinkedList;

public class _6_Postorder_Iterative<T> {
	private ArrayList<T> postOrderIterative(BinaryTreeNode<T> root) {
		ArrayList<T> res = new ArrayList<>();
		if (root == null)
			return res;
		StackUsingLinkedList<BinaryTreeNode<T>> s = new StackUsingLinkedList<>();
		BinaryTreeNode<T> previous = null;
		BinaryTreeNode<T> current = root;
		while (true) {
			while (current != null) {
				s.push(current);
				current = current.getLeft();
			}
			if (s.isEmpty())
				break;
			while (current == null && !s.isEmpty()) {
				current = s.peek();
				if (current.getRight() == null || current.getRight() == previous) {
					res.add(current.getData());
					s.pop();
					previous = current;
					current = null;
				} else {
					current = current.getRight();
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {	
		_6_Postorder_Iterative<Integer> bt = new _6_Postorder_Iterative<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));

		ArrayList<Integer> res2 = bt.postOrderIterative(btn);
		System.out.println(res2.toString());
	}
}
