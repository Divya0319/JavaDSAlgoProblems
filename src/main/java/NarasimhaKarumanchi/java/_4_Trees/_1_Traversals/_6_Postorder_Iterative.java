package main.java.NarasimhaKarumanchi.java._4_Trees._1_Traversals;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedStack;

public class _6_Postorder_Iterative<T> {
	private void postOrderIterative(BinaryTreeNode<T> root) {
		BinaryTreeNode<T> current = root;
		LinkedStack<BinaryTreeNode<T>> s = new LinkedStack<>();
		while(current != null || !s.isEmpty()) {
			if(current != null) {
				s.push(current);
				current = current.getLeft();
				
			} else {
				BinaryTreeNode<T> temp = s.peek().getRight();
				if(temp == null) {
					temp = s.pop();
					System.out.print(temp.getData() + " ");
					
					while(!s.isEmpty() && temp == s.peek().getRight()) {
						temp = s.pop();
						System.out.print(temp.getData() + " ");
					}
				} else {
					current = temp;
				}
			}
		}
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

		bt.postOrderIterative(btn);
	}
}
