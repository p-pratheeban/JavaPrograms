package com.pratheeban.tree;

public class WidthOfTree {
	// The width of a binary tree is the maximum number of elements on one level of
	// the tree.
	public int width(BinaryTreeNode root) {
		int max = 0;
		int height = maxDepthRecursive(root);
		for (int k = 0; k <= height; k++) {
			int tmp = width(root, k);
			if (tmp > max)
				max = tmp;
		}
		return max;
	}

	// Returns the number of node on a given level
	public int width(BinaryTreeNode root, int depth) {
		if (root == null)
			return 0;
		else if (depth == 0)
			return 1;
		else
			return width(root.left, depth - 1) + width(root.right, depth - 1);
	}

	public int maxDepthRecursive(BinaryTreeNode root) {
		if (root == null)
			return 0;
		/* compute the depth of each subtree */
		int leftDepth = maxDepthRecursive(root.getLeft());
		int rightDepth = maxDepthRecursive(root.right);
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}
}
