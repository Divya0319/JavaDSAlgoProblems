package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;

public class _4_p_SumOfLongestBloodlineOfTree {
   
    
    void solve(BinaryTreeNode<Integer> root, int sum, int[] maxSum, int len, int[] maxLen) {
        
        // base case
        if(root == null) {
            if(len > maxLen[0]) {
                maxLen[0] = len;
                maxSum[0] = sum;
            } else if(len == maxLen[0]) {
                maxSum[0] = Math.max(sum, maxSum[0]);
            }
            
            return;
        }
        
        sum = sum + root.getData();
        
        solve(root.getLeft(), sum, maxSum, len+1, maxLen);
        solve(root.getRight(), sum, maxSum, len+1, maxLen);
        
    }
    
    public int sumOfLongRootToLeafPath(BinaryTreeNode<Integer> root)
    {
        //code here
        int len = 0;

        int sum = 0;
        
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        
        int[] maxLen = new int[1];
        maxLen[0] = 0;

        solve(root, sum, maxSum, len, maxLen);
        return maxSum[0];
    }
   

	public static void main(String[] args) {
		_4_p_SumOfLongestBloodlineOfTree mainClass = new _4_p_SumOfLongestBloodlineOfTree();

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

		System.out.println(mainClass.sumOfLongRootToLeafPath(root));
	}

}
