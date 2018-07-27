package com.pratheeban.tree;

public class BinaryTreeSize {
	// Returns the total number of nodes in this binary tree (include the root in
	// the count).
	public static int size(BinaryTreeNode root) {
		int leftCount = root.left == null ? 0 : size(root.left);
		int rightCount = root.right == null ? 0 : size(root.right);
		return 1 + leftCount + rightCount;
	}
	public static void main(String[] args) {
		BinaryTreeNode b = BinaryTreeNode.createBinaryTree();
		System.out.println(size(b));
	}
}
