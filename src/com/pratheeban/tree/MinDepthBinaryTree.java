package com.pratheeban.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBinaryTree {
	// O(n) runtime, O(n) space – Breadth-first traversal
	public static int minDepth(BinaryTreeNode root) {
		if (root == null)
			return 0;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		int count = 1;
		while (!q.isEmpty()) {
			BinaryTreeNode currentNode = q.poll();
			if (currentNode != null) {
				if (currentNode.left == null && currentNode.right == null) {
					return count;
				}
				if (currentNode.left != null) {
					q.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					q.offer(currentNode.right);
				}
			} else {
				if (!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}
		}
		return count;
	}

	// O(n) runtime, O(log n) space – Depth-first traversal:
	public static int minDepth1(BinaryTreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return minDepth1(root.right) + 1;
		if (root.right == null)
			return minDepth1(root.left) + 1;
		return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeNode.createBinaryTree();
		root.displayTree();
		System.out.println(minDepth(root));
		System.out.println(minDepth1(root));
	}

}
