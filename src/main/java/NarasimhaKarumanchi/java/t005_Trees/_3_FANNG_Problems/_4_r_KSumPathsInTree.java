package main.java.NarasimhaKarumanchi.java.t005_Trees._3_FANNG_Problems;

import java.util.HashMap;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;

public class _4_r_KSumPathsInTree {
   
	int count = 0;
    
    void solve(BinaryTreeNode<Integer> root, int k, int sum, HashMap<Integer, Integer> hm) {
        
        // base case
    	if(root == null) {
    		return;
    	}
    	
    	sum += root.getData();
    	
    	count += hm.getOrDefault(sum-k, 0);
    	
    	if(sum == k) {
    		count++;
    	}
    	
    	hm.put(sum, hm.getOrDefault(sum, 0)+1);
    	
    	// left call
    	solve(root.getLeft(), k, sum, hm);
    	
    	// right call
    	solve(root.getRight(), k, sum, hm);
    	
    	hm.put(sum, hm.getOrDefault(sum, 0)-1);
        
    }
    
    public int sumK(BinaryTreeNode<Integer> root, int k)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        solve(root, k, 0, hm);
        return count;
    }
   

	public static void main(String[] args) {
		_4_r_KSumPathsInTree mainClass = new _4_r_KSumPathsInTree();

//		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
//		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
//		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
//		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
//		BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);
//		BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(8);
//		BinaryTreeNode<Integer> node9 = new BinaryTreeNode<>(9);
//
//		root.setLeft(node2);
//		root.setRight(node3);
//		node2.setLeft(node4);
//		node2.setRight(node5);
//		node3.setLeft(node6);
//		node3.setRight(node7);
//		node6.setRight(node8);
//		node7.setRight(node9);
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> nodeminus1 = new BinaryTreeNode<>(-1);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> node1_1 = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1_1_1 = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1_1_1_1 = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node2_2 = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);

		root.setLeft(node3);
		root.setRight(nodeminus1);
		node3.setLeft(node2);	
		node3.setRight(node1_1);
		nodeminus1.setLeft(node4);
		nodeminus1.setRight(node5);
		node1_1.setLeft(node1_1_1);
		node4.setLeft(node1_1_1_1);
		node4.setRight(node2_2);
		node5.setRight(node6);
		

		System.out.println(mainClass.sumK(root, 5));
	}

}
