package com.pratheeban.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertInBinaryTree {
	public BinaryTreeNode insertInBinaryTreeLevelOrder(BinaryTreeNode root, int data) {
		if (root == null)
			return null;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				else {
					tmp.left = new BinaryTreeNode(data);
					return root;
				}
				if (tmp.right != null)
					q.offer(tmp.right);
				else {
					tmp.right = new BinaryTreeNode(data);
					return root;
				}
			}
		}
		return root;
	}

	public void insert(BinaryTreeNode root, int data) {
		if (root == null) {
			root = new BinaryTreeNode(data);
		} else {
			insertHelper(root, data);
		}
	}

	private void insertHelper(BinaryTreeNode root, int data) {
		if (root.data >= data) { // It is not compulsory to put this check.
			if (root.left == null) {
				root.left = new BinaryTreeNode(data);
			} else {
				insertHelper(root.right, data);
			}
		} else {
			if (root.right == null) {
				root.right = new BinaryTreeNode(data);
			} else {
				insertHelper(root.right, data);
			}
		}
	}

	public static BinaryTreeNode insert(BinaryTreeNode root, BinaryTreeNode node) {
		if (root == null) {
			return node;
		}

		if (node.getData() <= root.getData()) {
			root.setLeft(insert(root.getLeft(), node));
		} else {
			root.setRight(insert(root.getRight(), node));
		}
		return root;
	}
}
