package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;

public class _4_t_MaximumSumOfNonAdjacentNodes {
   
	int getMaxSum(BinaryTreeNode<Integer> root)
    {
        Pair ans = solve(root);
        return Math.max(ans.first, ans.second);
    }
    
    Pair solve(BinaryTreeNode<Integer> root) {
        // base case
        if(root == null) {
            Pair p = new Pair(0,0);
            return p;
        }
        
        Pair left = solve(root.getLeft());
        Pair right = solve(root.getRight());
        
        Pair res = new Pair(-1, -1);
        res.first = root.getData() + left.second + right.second;
        res.second = Math.max(left.first, left.second) + Math.max(right.first, right.second);
        
        return res;
    }
   

	public static void main(String[] args) {
		_4_t_MaximumSumOfNonAdjacentNodes mainClass = new _4_t_MaximumSumOfNonAdjacentNodes();

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
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> node16 = new BinaryTreeNode<>(16);
		BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(8);
		BinaryTreeNode<Integer> node9 = new BinaryTreeNode<>(9);
		BinaryTreeNode<Integer> node21 = new BinaryTreeNode<>(21);
		BinaryTreeNode<Integer> node11 = new BinaryTreeNode<>(11);
		BinaryTreeNode<Integer> node15 = new BinaryTreeNode<>(15);
		BinaryTreeNode<Integer> node70 = new BinaryTreeNode<>(70);
		BinaryTreeNode<Integer> node18 = new BinaryTreeNode<>(18);
		BinaryTreeNode<Integer> node65 = new BinaryTreeNode<>(65);
		BinaryTreeNode<Integer> nodeminus8 = new BinaryTreeNode<>(-8);

		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node6);
		node3.setLeft(node4);
		node3.setRight(node5);
		node6.setLeft(node16);
		node6.setRight(node8);
		node16.setLeft(node11);
		node16.setRight(node15);
		node8.setRight(node70);
		node4.setLeft(node9);
		node5.setLeft(node21);
		node9.setRight(node18);
		node21.setLeft(node65);
		node21.setRight(nodeminus8);

		

		System.out.println(mainClass.getMaxSum(root));
	}
	
	static class Pair {
        int first;
        int second;
        
        Pair(int f, int s) {
            first = f;
            second = s;
        }
    }

}
