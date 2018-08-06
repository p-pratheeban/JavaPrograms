package com.pratheeban.tree;

public class BinaryTreeHight {
	
	public static int height(BinaryTreeNode root) {
		if(root ==null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right)+1;
	}
	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeNode.createBinaryTree();
		root.displayTree();
		System.out.println(height(root));
	}
}
