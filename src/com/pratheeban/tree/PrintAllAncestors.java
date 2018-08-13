package com.pratheeban.tree;

public class PrintAllAncestors {
	public static boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode node) {
		if (root == null)
			return false;
		if (root.getLeft() == node || root.getRight() == node || printAllAncestors(root.getLeft(), node)
				|| printAllAncestors(root.getRight(), node)) {
			System.out.println(root.getData());
			return true;
		}
		return false;
	}
}
