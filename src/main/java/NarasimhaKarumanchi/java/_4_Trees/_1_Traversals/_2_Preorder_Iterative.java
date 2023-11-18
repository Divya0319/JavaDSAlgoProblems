package main.java.NarasimhaKarumanchi.java._4_Trees._1_Traversals;

import java.util.ArrayList;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedStack;

public class _2_Preorder_Iterative<T> {

	private ArrayList<T> preOrderIterative(BinaryTreeNode<T> root) {
		ArrayList<T> res = new ArrayList<>();
		if (root == null)
			return res;
		LinkedStack<BinaryTreeNode<T>> s = new LinkedStack<>();
		
		s.push(root);
		
		while(!s.isEmpty()) {
			BinaryTreeNode<T> tmp = s.pop();
			res.add(tmp.getData());
			
			if(tmp.getRight() != null) {
				s.push(tmp.getRight()); // pushing right first, so that it gets popped after left
			}
			if(tmp.getLeft() != null) {
				s.push(tmp.getLeft()); // pushing left last, so that it gets popped first
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		_2_Preorder_Iterative<Integer> bt = new _2_Preorder_Iterative<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));

		ArrayList<Integer> res = bt.preOrderIterative(btn);
		System.out.println(res.toString());
	}

}
