package com.pratheeban.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightView {
	static int max_level = 0;

	// recursive function to print left view
	public static void rightViewUtil(BinaryTreeNode node, int level) {
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}

		// Recur for left and right subtrees
		rightViewUtil(node.right, level + 1);
		rightViewUtil(node.left, level + 1);
	}

	public static List<Integer> rightSideView(BinaryTreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root == null)
			return result;

		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			// get size here
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				BinaryTreeNode top = queue.remove();

				// the first element in the queue (right-most of the tree)
				if (i == 0) {
					result.add(top.data);
				}
				// add right first
				if (top.right != null) {
					queue.add(top.right);
				}
				// add left
				if (top.left != null) {
					queue.add(top.left);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		BinaryTreeNode node = BinaryTreeNode.createBinaryTree();

		node.displayTree();
		rightViewUtil(node, 1);
		System.out.println();
		System.out.println(rightSideView(node));
	}
}
