package com.pratheeban.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumBinaryTree {
	public int maxInBinaryTree(BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if (root != null) {
			int leftMax = maxInBinaryTree(root.left);
			int rightMax = maxInBinaryTree(root.right);

			if (leftMax > rightMax)
				maxValue = leftMax;
			else
				maxValue = rightMax;

			if (root.data > maxValue)
				maxValue = root.data;
		}
		return maxValue;
	}

	public int maxInBinaryTreeLevelOrder(BinaryTreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp.data > max) {
				max = tmp.data;
			}
			if (tmp != null) {
				if (tmp.left != null)
					q.offer(tmp.left);
				if (tmp.right != null)
					q.offer(tmp.right);
			}
		}
		return max;
	}
}
