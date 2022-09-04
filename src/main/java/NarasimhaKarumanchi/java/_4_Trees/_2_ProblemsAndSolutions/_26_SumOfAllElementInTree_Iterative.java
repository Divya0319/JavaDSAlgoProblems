package main.java.NarasimhaKarumanchi.java._4_Trees._2_ProblemsAndSolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;

public class _26_SumOfAllElementInTree_Iterative<T> {
	
	private int sumOfAllElementsIter(BinaryTreeNode<T> root) {
		if (root == null)
			return 0;
		LinkedQueue<BinaryTreeNode<T>> q = new LinkedQueue<>();
		q.enQueue(root);
		int sum = 0;
		while (!q.isEmpty()) {
			BinaryTreeNode<T> tmp;
			try {
				tmp = q.deQueue();
				sum += (Integer)tmp.getData();
				if (tmp.getLeft() != null)
					q.enQueue(tmp.getLeft());
				if (tmp.getRight() != null)
					q.enQueue(tmp.getRight());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		return sum;
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
		_26_SumOfAllElementInTree_Iterative<Integer> bt = new _26_SumOfAllElementInTree_Iterative<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));
		
		System.out.println(bt.levelOrderTraversal(btn));
		System.out.println("Sum of all elements of tree is :" + bt.sumOfAllElementsIter(btn));

	}

}
