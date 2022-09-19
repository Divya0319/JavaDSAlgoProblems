package main.java.NarasimhaKarumanchi.java._4_Trees._2_ProblemsAndSolutions;

import java.util.ArrayList;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;

public class _1_y_SumOfAllElementInTree_Recursive<T> {
	
	private int sumOfAllElements(BinaryTreeNode<T> root) {
		if (root == null)
			return 0;
		int sum = (Integer)root.getData();
		sum += sumOfAllElements(root.getLeft());
		sum += sumOfAllElements(root.getRight());

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
		_1_y_SumOfAllElementInTree_Recursive<Integer> bt = new _1_y_SumOfAllElementInTree_Recursive<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));
		
		System.out.println(bt.levelOrderTraversal(btn));
		System.out.println("Sum of all elements of tree is :" + bt.sumOfAllElements(btn));

	}

}
