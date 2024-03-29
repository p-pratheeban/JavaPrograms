package com.pratheeban.tree;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfLeavesInBinaryTree {
	public int numberOfLeavesInBTusingLevelOrder(BinaryTreeNode root) {
		int count = 0;
		if (root == null)
			return 0;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp.left == null && tmp.right == null)
				count++;
			if (tmp.left != null)
				q.offer(tmp.left);
			if (tmp.right != null)
				q.offer(tmp.right);
		}
		return count;
	}
}
