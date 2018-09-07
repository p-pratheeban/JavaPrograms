package com.pratheeban.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchBinaryTree {
	public static boolean findInBT(BinaryTreeNode root, int data) {
		if (root == null)
			return false;
		if (root.getData() == data)
			return true;
		return findInBT(root.getLeft(), data) || findInBT(root.getRight(), data);
	}

	public boolean findInBT1(BinaryTreeNode root, int data) {
		if (root == null)
			return false;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp.getData() == data) {
				return true;
			}
			if (tmp != null) {
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				if (tmp.right != null)
					q.offer(tmp.right);
			}
		}
		return false;
	}

	/*
	 * In a Binary Search Tree (BST) find the number of elements in a given range.
	 */
	public static int numbersInRange(BinaryTreeNode root, int start, int end) {
		if (root == null) {
			return 0;
		}
		if (root.data >= start && root.data <= end) {
			return numbersInRange(root.left, start, end) + numbersInRange(root.right, start, end) + 1;
		} else if (root.data > end) {
			return numbersInRange(root.left, start, end);
		} else { // if (node.data < start)
			return numbersInRange(root.right, start, end);
		}
	}

	public static void printRange(BinaryTreeNode root, int low, int high) {
		if (root == null) {
			return;
		}

		if (low <= root.getData()) {
			printRange(root.getLeft(), low, high);
		}

		if (low <= root.getData() && root.getData() <= high) {
			System.out.println(root.getData());
		}

		if (high > root.getData()) {
			printRange(root.getRight(), low, high);
		}
	}

	public static BinaryTreeNode nextInOrder(BinaryTreeNode n) {
		if (n == null) {
			return null;
		}
		if (n.right != null) {
			n = n.right;
			while (n.left != null) {
				n = n.left;
			}
			return n;
		} else {
			BinaryTreeNode p = n.parent;
			while (p != null && p.left != n) {
				n = p;
				p = p.parent;
			}
			return p;
		}
	}

	public static BinaryTreeNode nextPostOrder(BinaryTreeNode n) {
		if (n == null) {
			return null;
		}
		BinaryTreeNode p = n.parent;
		if (p != null && n == p.left) {
			n = p.right;
			while (n.left != null || n.right != null) {
				n = n.left;
			}
			return n;
		} // else if (p!=null && n == p.right) {
		return p;
		// }

	}

	public static BinaryTreeNode nextPostOrder1(BinaryTreeNode n) {
		if (n == null || n.parent == null) {
			return null;
		}
		if (n.parent.left == n) {
			BinaryTreeNode h = n.parent.right;
			if (h == null) {
				return n.parent;
			}
			while (h.left != null) {
				h = h.left;
			}
			return h;
		} else {
			return n.parent;
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode node = BinaryTreeNode.createMinimalBST(new int[] { 1, 2, 3, 5, 7, 9, 12 });
		node.displayTree();
		System.out.println(numbersInRange(node, 2, 9));
		System.out.println("In oder");
		System.out.println(nextInOrder(node.left.right));
		System.out.println(nextInOrder(node.left));
		System.out.println("Post Oder");
		System.out.println(nextPostOrder(node.left));
		System.out.println(nextPostOrder(node.left.left));
		System.out.println(nextPostOrder(node.left.right));

	}
}
