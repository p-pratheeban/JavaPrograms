package com.pratheeban.tree;

public class MinimalBinarySearchTree {
	public static BinaryTreeNode createMinimalBST(int[] a) {
		return createMinimalBST(a, 0, a.length - 1);
	}

	public static BinaryTreeNode createMinimalBST(int[] a, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		BinaryTreeNode bt = new BinaryTreeNode(a[mid]);
		bt.setLeft(createMinimalBST(a, start, mid - 1));
		bt.setRight(createMinimalBST(a, mid + 1, end));
		return bt;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		BinaryTreeNode bt = createMinimalBST(array);
		bt.displayTree();
	}
}
