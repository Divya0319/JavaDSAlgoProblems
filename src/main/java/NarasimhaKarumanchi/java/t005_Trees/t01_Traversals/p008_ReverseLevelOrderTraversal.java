package main.java.NarasimhaKarumanchi.java.t005_Trees.t01_Traversals;

import main.java.NarasimhaKarumanchi.java.t003_Stacks.LinkedStack;
import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java.t005_Trees.LinkedQueue;

public class p008_ReverseLevelOrderTraversal<T> {
	private void levelOrderTraversal(BinaryTreeNode<T> root) {
		LinkedStack<T> s = new LinkedStack<>();
		LinkedQueue<BinaryTreeNode<T>> q = new LinkedQueue<>();
		
		try {
			q.enQueue(root);
			
			// adding/enqueing separator to mark end of level
			q.enQueue(null);
			
			while(!q.isEmpty()) {
				BinaryTreeNode<T> temp = q.deQueue();
				
				if(temp == null) {	
					s.push(null);

					if(!q.isEmpty()) // q still has come child nodes
					{
						q.enQueue(null);
					}
				} else {
					
					s.push(temp.getData());

					if(temp.getLeft() != null) {
						q.enQueue(temp.getLeft());
					}
					if(temp.getRight() != null) {
						q.enQueue(temp.getRight());
					}
				}
				
				 
			}
			
			while(!s.isEmpty()) {
				if(s.peek() == null) {
					System.out.println();
					s.pop();
				} else {
					System.out.print(s.pop() + " ");
				}
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public static void main(String[] args) {	
		p008_ReverseLevelOrderTraversal<Integer> bt = new p008_ReverseLevelOrderTraversal<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));

		bt.levelOrderTraversal(btn);
	}
}
