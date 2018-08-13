package com.pratheeban.tree;

public class PrintPaths {
	public void printPaths(BinaryTreeNode root) {
		int[] path = new int[256];
		printPaths(root, path, 0);
	}

	private void printPaths(BinaryTreeNode root, int[] path, int pathLen) {
		if (root == null)
			return;
		// append this node to the path array
		path[pathLen] = root.getData();
		pathLen++;
		// it's a leaf, so print the path that led to here
		if (root.getLeft() == null && root.getRight() == null) {
			printArray(path, pathLen);
		} else { // otherwise try both subtrees
			printPaths(root.getLeft(), path, pathLen);
			printPaths(root.getRight(), path, pathLen);
		}
	}

	private void printArray(int[] ints, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println();
	}
}
