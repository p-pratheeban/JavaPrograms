package com.pratheeban.tree;

public class MinimumBinaryTree {
	public int minInBinaryTree(BinaryTreeNode root) {
		int minValue = Integer.MAX_VALUE;
		if (root != null) {
			int leftMin = minInBinaryTree(root.left);
			int rightMin = minInBinaryTree(root.right);

			if (leftMin > rightMin)
				minValue = leftMin;
			else
				minValue = rightMin;

			if (root.data < minValue)
				minValue = root.data;
		}
		return minValue;
	}
}
