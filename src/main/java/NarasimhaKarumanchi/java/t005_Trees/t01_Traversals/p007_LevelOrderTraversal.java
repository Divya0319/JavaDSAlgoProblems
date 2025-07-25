package main.java.NarasimhaKarumanchi.java.t005_Trees.t01_Traversals;

import main.java.NarasimhaKarumanchi.java.t005_Trees.BinaryTreeNode;
import main.java.NarasimhaKarumanchi.java.t005_Trees.LinkedQueue;

public class p007_LevelOrderTraversal<T> {
	private void levelOrderTraversal(BinaryTreeNode<T> root) {
		LinkedQueue<BinaryTreeNode<T>> q = new LinkedQueue<>();
		
		try {
			q.enQueue(root);
			
			// adding/enqueing separator to mark end of level
			q.enQueue(null);
			
			while(!q.isEmpty()) {
				BinaryTreeNode<T> temp = q.deQueue();
				
				// temp null ka matlab 
				//purana level complete traverse ho chuka hai
				if(temp == null) {
					System.out.println();
					
					if(!q.isEmpty()) // q still has come child nodes
									// means I again have to put separator, as child nodes present will be in same level
					{
						q.enQueue(null);
					}
				} else {
					System.out.print(temp.getData() + " ");

					if(temp.getLeft() != null) {
						q.enQueue(temp.getLeft());
					}
					if(temp.getRight() != null) {
						q.enQueue(temp.getRight());
					}
				}

				 
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public static void main(String[] args) {	
		p007_LevelOrderTraversal<Integer> bt = new p007_LevelOrderTraversal<>();

		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(1);
		btn.setLeft(new BinaryTreeNode<>(2));
		btn.setRight(new BinaryTreeNode<>(9));
		btn.getLeft().setLeft(new BinaryTreeNode<>(4));
		btn.getLeft().setRight(new BinaryTreeNode<>(5));
		btn.getRight().setLeft(new BinaryTreeNode<>(6));
		btn.getRight().setRight(new BinaryTreeNode<>(7));

		bt.levelOrderTraversal(btn);
	}
}
