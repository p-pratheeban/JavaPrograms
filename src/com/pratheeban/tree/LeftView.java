package com.pratheeban.tree;

public class LeftView {
	static int max_level = 0;

	// recursive function to print left view
	public static void leftViewUtil(BinaryTreeNode node, int level) {
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}

	public static void main(String[] args) {
		BinaryTreeNode node = BinaryTreeNode.createBinaryTree();
		
		node.displayTree();
		leftViewUtil(node, 1);
	}
}
