package main.java.NarasimhaKarumanchi.java._4_Trees._3_FANNG_Problems;

import main.java.NarasimhaKarumanchi.java._4_Trees.BinaryTreeNode;

public class _4_q_LongestCommonAncestorInTree {
   
    
    public BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int n1, int n2)
    {
        if(root == null) {
        	return null;
        }
        
        if(root.getData() == n1 || root.getData() == n2) {
        	return root;
        }
        
        BinaryTreeNode<Integer> leftAns = lca(root.getLeft(), n1, n2);
        BinaryTreeNode<Integer> rightAns = lca(root.getRight(), n1, n2);
        
        if(leftAns != null && rightAns != null) {
        	return root;
        }
        else if(leftAns != null && rightAns == null) {
        	return leftAns;
        } 
        else if(leftAns == null && rightAns != null) {
        	return rightAns;
        }
        else {
        	return null;
        }
    }
   

	public static void main(String[] args) {
		_4_q_LongestCommonAncestorInTree mainClass = new _4_q_LongestCommonAncestorInTree();

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

		System.out.println(mainClass.lca(root, 8, 9).getData());
	}

}
