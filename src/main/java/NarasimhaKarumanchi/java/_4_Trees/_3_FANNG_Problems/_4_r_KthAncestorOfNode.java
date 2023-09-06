package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;

public class _4_r_KthAncestorOfNode {
   
	private int k;
    BinaryTreeNode<Integer> solve(BinaryTreeNode<Integer> root, int node) {
        // base case
        if(root == null) {
            return null;
        }
        
        if(root.getData() == node) {
            return root;
        }
        
        BinaryTreeNode<Integer> leftAns = solve(root.getLeft(), node);
        BinaryTreeNode<Integer> rightAns = solve(root.getRight(), node);
        
        // we are returning from left and right calls
        if(leftAns != null && rightAns == null) {
            k--;
            if(k <= 0) {
                k = Integer.MAX_VALUE;
                return root;
            }
            
            return leftAns;
        }
        
        if(leftAns == null && rightAns != null) {
            k--;
            if(k <= 0) {
                k = Integer.MAX_VALUE;
                return root;
            }
            
            return rightAns;
        }
        
        return null;
    }
    public int kthAncestor(BinaryTreeNode<Integer> root, int k, int node)
    {
       this.k = k;
       BinaryTreeNode<Integer> ans = solve(root, node);
       if(ans == null || ans.getData() == node) {
           return -1;
       }
       
       return ans.getData();
    }
   

	public static void main(String[] args) {
		_4_r_KthAncestorOfNode mainClass = new _4_r_KthAncestorOfNode();

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

		System.out.println(mainClass.kthAncestor(root, 2, 8));
	}

}
