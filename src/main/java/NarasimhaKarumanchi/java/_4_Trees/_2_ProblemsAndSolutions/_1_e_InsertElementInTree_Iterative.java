package main.java.NarasimhaKarumanchi.java._4_Trees._2_ProblemsAndSolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;

public class _1_e_InsertElementInTree_Iterative<T> {
	
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
	
	private BinaryTreeNode<T> insertInBinaryTreeLevelOrder(BinaryTreeNode<T> root, T data) {
		if (root == null)
			return null;
		Queue<BinaryTreeNode<T>> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryTreeNode<T> tmp = q.remove();
			if (tmp.getLeft() != null) {
				q.add(tmp.getLeft());
			} else {
				tmp.setLeft(new BinaryTreeNode<>(data));
				System.out.println(data + " Inserted on left of : " + tmp.getData());
				return root;
			}

			if (tmp.getRight() != null) {
				q.add(tmp.getRight());
			} else {
				tmp.setRight(new BinaryTreeNode<>(data));
				System.out.println(data + "Inserted on right of : " + tmp.getData());
				return root;
			}
		}

		return root;
	}

	
	public static void main(String[] args) {
		_1_e_InsertElementInTree_Iterative<Integer> bt = new _1_e_InsertElementInTree_Iterative<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));
		
		BinaryTreeNode<Integer> newRoot = bt.insertInBinaryTreeLevelOrder(btn, 40);
		System.out.println(bt.levelOrderTraversal(newRoot));

	}

}
