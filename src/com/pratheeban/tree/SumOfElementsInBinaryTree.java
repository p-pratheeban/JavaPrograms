package com.pratheeban.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfElementsInBinaryTree {
	public int addBT1(BinaryTreeNode root) {
		int sum = 0;
		if (root == null)
			return 0;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			sum += tmp.data;
			if (tmp.getLeft() != null)
				q.offer(tmp.getLeft());
			if (tmp.right != null)
				q.offer(tmp.right);
		}
		return sum;
	}
	public int addBT(BinaryTreeNode  root) {
		if(root == null) return 0;
		else return(root.getData() + addBT(root.getLeft()) +  addBT(root.getRight()));
	}
}
