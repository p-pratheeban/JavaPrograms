package com.pratheeban.tree;

public class CheckPathForSum {
	public boolean hasPathSum(BinaryTreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.data == sum)
			return true;
		else
			return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
	}
}
