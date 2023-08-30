package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;
import main.java.NarasimhaKarumanchi.java._9_c_Algos_Generic.Pair;

public class _4_j_VerticalOrderTraversal {

	ArrayList<Integer> verticalOrderTraversal(BinaryTreeNode<Integer> root) {
		
		ArrayList<Integer> ans = new ArrayList<>();

		try {

			LinkedQueue<Pair<Integer, BinaryTreeNode<Integer>>> q = new LinkedQueue<>();
			Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
			
			q.enQueue(new Pair<>(0, root));
			
			while(!q.isEmpty()) {
				Pair<Integer, BinaryTreeNode<Integer>> curr = q.deQueue();
				if(map.containsKey(curr.first)) {
					map.get(curr.first).add(curr.second.getData());
				} else {
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(curr.second.getData());
					map.put(curr.first, temp);
					
				}
				
				if(curr.second.getLeft() != null) {
					q.enQueue(new Pair<>(curr.first - 1, curr.second.getLeft()));
				}
				
				if(curr.second.getRight() != null) {
					q.enQueue(new Pair<>(curr.first + 1, curr.second.getRight()));
				}
			}
			
			for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
				ans.addAll(entry.getValue());
			}

		} catch (Exception ex) {

		}
		
		return ans;

	}

	public static void main(String[] args) {
		_4_j_VerticalOrderTraversal mainClass = new _4_j_VerticalOrderTraversal();

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
		BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);
		BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(8);
		BinaryTreeNode<Integer> node9 = new BinaryTreeNode<>(9);

		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);
		node6.setRight(node8);
		node7.setRight(node9);

		System.out.println(mainClass.verticalOrderTraversal(root));
	}

}
