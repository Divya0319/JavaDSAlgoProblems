package main.java.NarasimhaKarumanchi.java.t005_Trees._3_FANNG_Problems;

import java.util.ArrayList;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java.t005_Trees.LinkedQueue;
import main.java.NarasimhaKarumanchi.java.t005_Trees.ListNode;

public class _4_h_ZigzagTraversal {

	public ArrayList<Integer> zigzagTraversal(BinaryTreeNode<Integer> root) {

		ArrayList<Integer> result = new ArrayList<>();

		try {
			if (root == null) {
				return result;
			}

			LinkedQueue<BinaryTreeNode<Integer>> q = new LinkedQueue<>();
			
			// in starting, q has root
			q.enQueue(root);
			
			// depending on this flag, it will be decided
			// that we put elements in ans in normal flow,
			// or in reverse flow
			boolean leftToRight = true;

			while (!q.isEmpty()) {

				// to find out how many elements are there at particular level
				int size = q.size();
				
				// to store those elements at a level
				ArrayList<BinaryTreeNode<Integer>> ans = new ArrayList<>();
				
				// initialising Arraylist with 10 entries of null values beforehand, so that 
				// we can add values at particular indices in it and avoid IndexOutOfBounds
				for(int j = 0; j < 10; j++) {
					ans.add(new BinaryTreeNode<>(null));
				}

				// level process
				for (int i = 0; i < size; i++) {

					// take out front node first from queue
					ListNode<BinaryTreeNode<Integer>> frontNode = q.getFront();
					q.deQueue();
					
					// normal insert or reverse insert
					int index = leftToRight ? i : size - i - 1;
					// setting values at particular index
					ans.set(index, frontNode.getData());
					
					if(frontNode.getData().getLeft() != null) {
						q.enQueue(frontNode.getData().getLeft());
					}
					
					if(frontNode.getData().getRight() != null) {
						q.enQueue(frontNode.getData().getRight());
					}


				}
				
				// direction change karni hai
				leftToRight = !leftToRight;
				
				for(int i = 0; i < ans.size(); i++) {
					BinaryTreeNode<Integer> node = ans.get(i);
					
					// only adding those entries from ans into result arraylist, which are non-null
					if(node.getData() != null) {
					 result.add(node.getData()); 
					}
				}

				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

	}

	public static void main(String[] args) {
		_4_h_ZigzagTraversal mainClass = new _4_h_ZigzagTraversal();

		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(4);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(6);

		root1.setLeft(node1);
		root1.setRight(node2);
		node1.setLeft(node3);
		node3.setLeft(node4);
		node2.setRight(node5);

		System.out.println(mainClass.zigzagTraversal(root1));
	}

}
