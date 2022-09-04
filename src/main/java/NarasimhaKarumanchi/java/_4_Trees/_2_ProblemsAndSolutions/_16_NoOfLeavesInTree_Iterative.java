package main.java.NarasimhaKarumanchi.java._4_Trees._2_ProblemsAndSolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;

public class _16_NoOfLeavesInTree_Iterative<T> {
	
	public int findNoOfLeaves(BinaryTreeNode<T> root) {
		int count = 0;
		if (root == null)
			return 0;
		LinkedQueue<BinaryTreeNode<T>> q = new LinkedQueue<>();
		q.enQueue(root);
		while (!q.isEmpty()) {
			BinaryTreeNode<T> tmp;
			try {
				tmp = q.deQueue();
				if (tmp.getLeft() == null && tmp.getRight() == null)
					count++;
				if (tmp.getLeft() != null)
					q.enQueue(tmp.getLeft());
				if (tmp.getRight() != null)
					q.enQueue(tmp.getRight());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		return count;
	}
	
	private ArrayList<T> levelOrderTraversal(BinaryTreeNode<T> root) {
		ArrayList<T> res = new ArrayList<>();
		if (root == null) {
			return null;
		}

		LinkedQueue<BinaryTreeNode<T>> q = new LinkedQueue<>();
		q.enQueue(root);
		while (!q.isEmpty()) {
			try {
				int size = q.size();
				while (size-- > 0) {
					BinaryTreeNode<T> current = q.deQueue();
					res.add(current.getData());

					if (current.getLeft() != null)
						q.enQueue(current.getLeft());
					if (current.getRight() != null)
						q.enQueue(current.getRight());

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return res;
	}

	
	public static void main(String[] args) {
		_16_NoOfLeavesInTree_Iterative<Integer> bt = new _16_NoOfLeavesInTree_Iterative<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));
		
		System.out.println(bt.levelOrderTraversal(btn));
		System.out.println("No. of leaves in given tree is :" + bt.findNoOfLeaves(btn));

	}

}
