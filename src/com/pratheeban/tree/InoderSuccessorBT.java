package com.pratheeban.tree;

public class InoderSuccessorBT {
	public static BinaryTreeNode inorderSucc(BinaryTreeNode n) { 
		if (n == null) return null;
		
		// Found right children -> return left most node of right subtree
		if (n.parent == null || n.right != null) { 
			return leftMostChild(n.right); 
		} else { 
			BinaryTreeNode q = n;
			BinaryTreeNode x = q.parent;
			// Go up until were on left instead of right
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}  
	} 
		
	public static BinaryTreeNode leftMostChild(BinaryTreeNode n) {
		if (n == null) {
			return null;
		}
		while (n.left != null) {
			n = n.left; 
		}
		return n; 
	}
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		BinaryTreeNode bt = BinaryTreeNode.createMinimalBST(array);
		bt.displayTree();

		System.out.println(inorderSucc(bt));
		System.out.println(inorderSucc(bt.right));
		System.out.println(inorderSucc(bt.right.right));
		System.out.println(inorderSucc(bt.left));
		System.out.println(inorderSucc(bt.left.right.right));





	}
}
