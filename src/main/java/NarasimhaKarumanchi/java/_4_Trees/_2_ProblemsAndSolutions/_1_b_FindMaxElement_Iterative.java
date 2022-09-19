package main.java.NarasimhaKarumanchi.java._4_Trees._2_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;

public class _1_b_FindMaxElement_Iterative<T> {
	
	private int maxElementIterative(BinaryTreeNode<T> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int max = Integer.MIN_VALUE;
		LinkedQueue<BinaryTreeNode<T>> q = new LinkedQueue<>();
		q.enQueue(root);
		while (!q.isEmpty()) {
			BinaryTreeNode<T> tmp;
			try {
				tmp = q.deQueue();
				if ((Integer)tmp.getData() > max) {
					max = (Integer)tmp.getData();
				}
				if (tmp.getLeft() != null) {
					q.enQueue(tmp.getLeft());
				}
				if (tmp.getRight() != null) {
					q.enQueue(tmp.getRight());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		return max;
	}
	
	public static void main(String[] args) {
		_1_b_FindMaxElement_Iterative<Integer> bt = new _1_b_FindMaxElement_Iterative<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));
		
		System.out.println(bt.maxElementIterative(btn));
	}

}
