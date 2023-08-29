package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java._4_Trees.LinkedQueue;
import main.java.NarasimhaKarumanchi.java._9_c_Algos_Generic.Pair;

public class _4_j_VerticalOrderTraversal {

	ArrayList<Integer> ans;

	List<Integer> verticalOrderTraversal(BinaryTreeNode<Integer> root) {

		try {

			Map<Integer, Map<Integer, List<Integer>>> nodes = new HashMap<>();
			LinkedQueue<Pair<BinaryTreeNode<Integer>, Pair<Integer, Integer>>> q = new LinkedQueue<>();

			List<Integer> ans = new ArrayList<>();

			// base case
			if (root == null) {
				return ans;
			}

			// pushing root to queue
			q.enQueue(new Pair<>(root, new Pair<>(0, 0)));

			while (!q.isEmpty()) {
				Pair<BinaryTreeNode<Integer>, Pair<Integer, Integer>> temp = q.deQueue();
				
				BinaryTreeNode<Integer> frontNode = temp.first;
				int hd = temp.second.first;
				int lvl = temp.second.second;
				
				// at whatever node we are, create a mapping in map
				if(!nodes.containsKey(hd)) {
					nodes.put(hd, new LinkedHashMap<>());
				}
				
				if(!nodes.get(hd).containsKey(lvl)) {
					nodes.get(hd).put(lvl, new ArrayList<>());
				}
				
				nodes.get(hd).get(lvl).add(frontNode.getData());
				
				if(frontNode.getLeft() != null) {
					q.enQueue(new Pair<>(frontNode.getLeft(), new Pair<>(hd-1, lvl+1)));
				}
				
				if(frontNode.getRight() != null) {
					q.enQueue(new Pair<>(frontNode.getRight(), new Pair<>(hd+1, lvl+1)));
				}
				
			}
			
			// creating a temp hashmap, sorted according to horizontal distance
			HashMap<Integer, Map<Integer, List<Integer>>> temp
            = nodes.entrySet()
                  .stream()
                  .sorted((i1, i2)
                              -> i1.getKey().compareTo(
                                  i2.getKey()))
                  .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1, e2) -> e1, LinkedHashMap::new));
 
			
			// putting mapped values one by one into ans array
			for(Map.Entry<Integer, Map<Integer, List<Integer>>> i : temp.entrySet()) {
				
				for(Map.Entry<Integer, List<Integer>> j : i.getValue().entrySet()) {
					
					for(Integer k : j.getValue()) {
						ans.add(k);
					}
				}
			}
			
			return ans;

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
