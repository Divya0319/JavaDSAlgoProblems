package main.java.NarasimhaKarumanchi.java.t005_Trees.t01_Traversals;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java.t005_Trees.LinkedStack;

public class p006_Postorder_Iterative<T> {
	// We start from root, then if left exists, we go to left, then left, then left, so on
	// If left does not exist, we go to right, and again we go to left, then its left.
	// If leaf node is seen, we print it, or , while returning, if both left and right of a node is traversed, we print the node
	private void postOrderIterative(BinaryTreeNode<T> root) {
		BinaryTreeNode<T> current = root;
		LinkedStack<BinaryTreeNode<T>> s = new LinkedStack<>();
		while(current != null || !s.isEmpty()) {
			if(current != null) {
				// push current onto stack and make current as its left
				s.push(current);
				current = current.getLeft();
				
			} else {
				
				// when current is null, we check that if node on top of stack
				// have a right child,
				// if it doesn't have right child, means it is leaf node, we visit it
				BinaryTreeNode<T> temp = s.peek().getRight();
				if(temp == null) {
					temp = s.pop();
					System.out.print(temp.getData() + " ");
					
					// after visiting it, we check if, this popped node is right child of new top of stack
					// if it is not right child, it means, top of stack still has right sides to explore
					while(!s.isEmpty() && temp == s.peek().getRight()) {
						temp = s.pop();
						System.out.print(temp.getData() + " ");
					}
				} else {
					// control will come here when temp is not null, means when top of stack has a right child
					// so current will become temp now
					current = temp;
				}
			}
		}
	}
	public static void main(String[] args) {	
		p006_Postorder_Iterative<Integer> bt = new p006_Postorder_Iterative<>();

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
