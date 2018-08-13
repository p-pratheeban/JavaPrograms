package com.pratheeban.tree;

public class MirrorOfBinaryTree {
	public BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root) {
		BinaryTreeNode temp;
		if (root != null) {
			mirrorOfBinaryTree(root.left);
			mirrorOfBinaryTree(root.right);
			/* swap the pointers in this node */
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}
}
