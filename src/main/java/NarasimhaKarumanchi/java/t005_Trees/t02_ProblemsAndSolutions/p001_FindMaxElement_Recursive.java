package main.java.NarasimhaKarumanchi.java.t005_Trees.t02_ProblemsAndSolutions;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;

public class p001_FindMaxElement_Recursive<T> {
	
	private Integer maxElementRecursive(BinaryTreeNode<T> root) {
		int maxValue = Integer.MIN_VALUE;
		if (root != null) {
			int leftMax = maxElementRecursive(root.getLeft());
			int rightMax = maxElementRecursive(root.getRight());
			
			if (leftMax > rightMax)
				maxValue = leftMax;
			else
				maxValue = rightMax;
			if ((Integer) root.getData() > maxValue)
				maxValue = (Integer) root.getData();
			
		}

		return maxValue;
	}
	
	public static void main(String[] args) {
		p001_FindMaxElement_Recursive<Integer> bt = new p001_FindMaxElement_Recursive<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));
		
		System.out.println(bt.maxElementRecursive(btn));

	}

}
