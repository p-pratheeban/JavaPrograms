package com.pratheeban.tree;

public class BuildBinaryTree {
	public static BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int postEnd = postorder.length - 1;
		return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}

	public static BinaryTreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
			int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;
		int rootValue = postorder[postEnd];
		BinaryTreeNode root = new BinaryTreeNode(rootValue);
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}
		root.left = buildTree(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1));
		// Becuase k is not the length, it it need to -(inStart+1) to get the length
		root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k - inStart, postEnd - 1);
		// postStart+k-inStart = postStart+k-(inStart+1) +1
		return root;
	}

	/*
	 * Given that a tree is a full binary tree (= every node other than the leaves
	 * has two children) and the pre-order and post-order traversal of the tree,
	 * re-construct it.
	 */
	static int mPreIndex = 0;

	public static BinaryTreeNode constructTree(int[] pre, int[] post, int lo, int hi) {
		if ((lo > hi) || (mPreIndex >= pre.length)) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode(pre[mPreIndex]);
		mPreIndex++;
		if (lo == hi) {
			return root;
		}
		int i;
		for (i = lo; i < hi; i++) {
			if (pre[mPreIndex] == post[i]) {
				break;
			}
		}
		root.left = constructTree(pre, post, lo, i);
		root.right = constructTree(pre, post, i + 1, hi - 1);
		return root;
	}

	public static void main(String[] args) {
		// in-order: 4 2 5 (1) 6 7 3 8
		// post-order: 4 5 2 6 7 8 3 (1)
		int[] inorder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] postorder = { 4, 5, 2, 6, 7, 8, 3, 1 };
		int[] preoder = { 1, 2, 4, 5, 3, 7, 6, 8 };
		BinaryTreeNode root = buildTree(inorder, postorder);
		root.displayTree();

		BinaryTreeNode root1 = constructTree(inorder, postorder, 0, inorder.length - 1);
		root1.displayTree();
	}
}
