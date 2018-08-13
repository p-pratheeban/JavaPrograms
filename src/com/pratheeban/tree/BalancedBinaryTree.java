package com.pratheeban.tree;

public class BalancedBinaryTree {
	public static int height(BinaryTreeNode root) {
		if (root == null) {
			return -1;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	// O(n2) runtime, O(n) stack space – Brute force top-down recursion
	public static boolean isBalncedBT(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}
		int left = height(root.left);
		int right = height(root.right);

		int heightDiff = Math.abs(left - right);
		if (heightDiff > 1) {
			return false;
		} else {
			return isBalncedBT(root.left) && isBalncedBT(root.right);
		}

	}

	public static int checkHeight(BinaryTreeNode root) {
		if (root == null) {
			return -1;
		}
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE; // Propagate error up

		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE; // Propagate error up

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE; // Found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static boolean isBalanced(BinaryTreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	public static boolean isBalanced1(BinaryTreeNode root) {
		return maxDepth(root) != -1;
	}
	
	//O(n) runtime, O(n) stack space – Bottom-up recursion:
	private static int maxDepth(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int L = maxDepth(root.left);
		if (L == -1)
			return -1;
		int R = maxDepth(root.right);
		if (R == -1)
			return -1;
		return (Math.abs(L - R) <= 1) ? (Math.max(L, R) + 1) : -1;
	}

	public static void main(String[] args) {
		BinaryTreeNode bt = BinaryTreeNode.createBinaryTree();
		bt.displayTree();
		boolean isBalance = isBalncedBT(bt);

		if (isBalance)
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");

		boolean isBalance1 = isBalanced(bt);

		if (isBalance1)
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
		

		boolean isBalance2 = isBalanced1(bt);

		if (isBalance2)
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}

}
