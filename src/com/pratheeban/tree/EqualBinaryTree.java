package com.pratheeban.tree;

public class EqualBinaryTree {
	public static boolean checkBinaryTreeSame(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.data != root2.data) {
			return false;
		}
		return checkBinaryTreeSame(root1.left, root2.left) && checkBinaryTreeSame(root1.right, root2.right);
	}

	public static void main(String[] args) {
		BinaryTreeNode b1 = BinaryTreeNode.createMinimalBST(new int[] { 4, 7, 9, 12, 13 });
		BinaryTreeNode b2 = BinaryTreeNode.createMinimalBST(new int[] { 4, 7, 9, 12, 13 });
		b1.displayTree();
		System.out.println(checkBinaryTreeSame(b1, b2));
	}
}
