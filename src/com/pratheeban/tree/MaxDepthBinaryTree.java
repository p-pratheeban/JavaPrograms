package com.pratheeban.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthBinaryTree {
	
	//O(n) runtime, O(log n) space – Recursion
	public static int maxDepthRecursive(BinaryTreeNode root) {
		if (root == null)
			return 0;
		/* compute the depth of each subtree */
		int leftDepth = maxDepthRecursive(root.left);
		int rightDepth = maxDepthRecursive(root.right);
		return Math.max(leftDepth, rightDepth)+1;
	}

	// Returns the depth of this binary tree. The depth of a binary tree is the
	// length of the longest path from this node to a leaf. The depth of a
	// binary tree with no descendants (that is, just a leaf) is zero.
	public static int maxDepthIterative(BinaryTreeNode root) {
		if (root == null)
			return 0;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		int maxDepth = 0;
		BinaryTreeNode prev = null;
		while (!s.isEmpty()) {
			BinaryTreeNode curr = s.peek();
			if (prev == null || prev.getLeft() == curr || prev.right == curr) {
				if (curr.getLeft() != null)
					s.push(curr.getLeft());
				else if (curr.right != null)
					s.push(curr.right);
			} else if (curr.getLeft() == prev) {
				if (curr.right != null)
					s.push(curr.right);
			} else
				s.pop();
			prev = curr;
			if (s.size() > maxDepth)
				maxDepth = s.size();
		}
		return maxDepth;
	}

	public static int maxDepthLevelOrder(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int maxDepth = 1;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				if (!q.isEmpty()) {
					++maxDepth;
					q.offer(null);
				}
			}
		}
		return maxDepth;
	}
	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeNode.createBinaryTree();
		root.displayTree();
		System.out.println(maxDepthRecursive(root));
		System.out.println(maxDepthIterative(root));
		System.out.println(maxDepthLevelOrder(root));
	}
}
