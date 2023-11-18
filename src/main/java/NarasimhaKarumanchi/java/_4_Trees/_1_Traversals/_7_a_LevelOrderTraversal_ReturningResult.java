package main.java.NarasimhaKarumanchi.java._4_Trees._1_Traversals;

import java.util.ArrayList;
import java.util.List;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;

public class _7_a_LevelOrderTraversal_ReturningResult<T> {
	private List<T> levelOrderTraversal(BinaryTreeNode<T> root) {
		LinkedQueue<BinaryTreeNode<T>> q = new LinkedQueue<>();
		ArrayList<T> res = new ArrayList<>();
		
		try {
			q.enQueue(root);
			q.enQueue(null);
			
			while(!q.isEmpty()) {
				BinaryTreeNode<T> temp = q.deQueue();
				
				if(temp == null) {
					res.add((T)Integer.valueOf(-1));
					
					if(!q.isEmpty()) {
						q.enQueue(null);
					}
				} else {
						res.add(temp.getData());
							
						if(temp.getLeft() != null) {
							q.enQueue(temp.getLeft());
						}
						if(temp.getRight() != null) {
							q.enQueue(temp.getRight());
						}
				}
				 
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return res;
		
	}
	public static void main(String[] args) {	
		_7_a_LevelOrderTraversal_ReturningResult<Integer> bt = new _7_a_LevelOrderTraversal_ReturningResult<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));

		System.out.println(bt.levelOrderTraversal(btn).toString());
	}
}
