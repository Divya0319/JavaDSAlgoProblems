package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;
import main.java.NarasimhaKarumanchi.java._9_c_Algos_Generic.Pair;

public class _4_j_VerticalOrderTraversal {

	ArrayList<Integer> verticalOrderTraversal(BinaryTreeNode<Integer> root) {
		
		// we store the ans in this
		ArrayList<Integer> ans = new ArrayList<>();

		try {

			// used to do level order traversal
			LinkedQueue<Pair<Integer, BinaryTreeNode<Integer>>> q = new LinkedQueue<>();
			
			// used to create mapping from horizontal distance of each node, to the node's data itself
			// and any h.d. can have more than 1 node mapped to it.
			Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
			
			// pushing root node to queue
			q.enQueue(new Pair<>(0, root));
			
			while(!q.isEmpty()) {
				Pair<Integer, BinaryTreeNode<Integer>> curr = q.deQueue();
				
				// if map contains this h.d.
				if(map.containsKey(curr.first)) {
					// simply map it to current node's data
					map.get(curr.first).add(curr.second.getData());
				} else {
					// map doesn't contain this h.d.
					// create a new arraylist, add current node data to it
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(curr.second.getData());
					// and create a new mapping in map for it
					map.put(curr.first, temp);
					
				}
				
				// if current node has left child
				if(curr.second.getLeft() != null) {
					// assign the correct h.d. to this left child, and store it in queue
					q.enQueue(new Pair<>(curr.first - 1, curr.second.getLeft()));
				}
				
				// if current node has right child
				if(curr.second.getRight() != null) {
					// assign the correct h.d. to this right child, and store it in queue
					q.enQueue(new Pair<>(curr.first + 1, curr.second.getRight()));
				}
			}
			
			// fetch all the node's data in increasing order of h.d. from map
			// and add them to answer in same order
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
