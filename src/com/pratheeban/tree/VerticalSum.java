package com.pratheeban.tree;

import java.util.HashMap;

public class VerticalSum {
	public static void vSum(HashMap<Integer, Integer> hash, BinaryTreeNode root, int c) {
		if (root.left != null)
			vSum(hash, root.left, c - 1);
		if (root.right != null)
			vSum(hash, root.right, c + 1);
		int data = 0;
		if (hash.containsKey(c))
			data = hash.get(c);
		hash.put(c, root.data + data);
	}

	public static void verticalSum(BinaryTreeNode root) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		vSum(hash, root, 0);
		System.out.println();

		for (int k : hash.keySet()) {
			System.out.println("key(pos): " + k + " sum: " + hash.get(k) + " ");
		}
	}
}
