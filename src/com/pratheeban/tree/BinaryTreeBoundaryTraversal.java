package com.pratheeban.tree;

public class BinaryTreeBoundaryTraversal {
		public static void boundaryLevelTraversal(BinaryTreeNode root) {
		System.out.print(root.data + " ");
		printLeftEdgeNodes(root.left);
		printLeafNodes(root);
		printRightBottomUp(root.right);

	}

	private static void printLeafNodes(BinaryTreeNode root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
			return;
		}
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}

	private static void printRightBottomUp(BinaryTreeNode root) {
		if (root == null)
			return;

		// if leaf node, ignore while printing edges
		if (root.left == null && root.right == null) {
			return;
		}

		if (root.right != null) {
			printRightBottomUp(root.right);
		} else if (root.left != null) {
			printRightBottomUp(root.left);
		}

		System.out.print(root.data + " ");
	}

	private static void printLeftEdgeNodes(BinaryTreeNode root) {
		if (root == null)
			return;

		// if leaf node, ignore while printing edges
		if (root.left == null && root.right == null)
			return;

		System.out.print(root.data + " ");

		// If left is null, right will be the boundary edge.
		if (root.left == null) {
			printLeftEdgeNodes(root.right);
		} else {
			printLeftEdgeNodes(root.left);
		}

	}

	public static void main(String[] args) {
		// Creating a binary tree
		
		BinaryTreeNode rootNode = BinaryTreeNode.createBinaryTree();
		System.out.println("Boundary traversal of binary tree will be:");
		boundaryLevelTraversal(rootNode);
	}

	
}
