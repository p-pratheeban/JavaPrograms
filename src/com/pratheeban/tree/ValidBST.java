package com.pratheeban.tree;

public class ValidBST {
	int index = 0;
	Integer last_printed = null;

	public void copyBST(BinaryTreeNode root, BinaryTreeNode[] arr) {
		if (root == null) {
			return;
		}
		copyBST(root.left, arr);
		arr[index] = root;
		index++;
		copyBST(root.right, arr);
	}

	public boolean checkBST(BinaryTreeNode root) {
		BinaryTreeNode[] arr = new BinaryTreeNode[root.numberOfNodes()];
		copyBST(root, arr);
		;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].data > arr[i + 1].data) {
				return false;
			}
		}
		return true;
	}

	public boolean checkBST1(BinaryTreeNode node) {
		return checkBST(node, true);
	}

	// Allow "equal" value only for left child. This validates the BST property.
	public boolean checkBST(BinaryTreeNode n, boolean isLeft) {
		if (n == null) {
			return true;
		}

		// Check / recurse left
		if (!checkBST(n.left, true)) {
			return false;
		}

		// Check current
		if (last_printed != null) {
			if (isLeft) {
				// left child "is allowed" be equal to parent.
				if (n.data < last_printed) {
					return false;
				}
			} else {
				// Right child "is not allowed" be equal to parent.
				if (n.data <= last_printed) {
					return false;
				}
			}
		}
		last_printed = n.data;

		// Check / recurse right
		if (!checkBST(n.right, false)) {
			return false;
		}
		return true;
	}

	public boolean checkBST(BinaryTreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
			return false;
		}
		return true;
	}

	public boolean checkBST2(BinaryTreeNode n) {
		return checkBST(n, null, null);
	}

	public static void main(String[] args) {
		ValidBST b1 = new ValidBST();
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		BinaryTreeNode root = BinaryTreeNode.createMinimalBST(array);
		root.displayTree();
		System.out.println(b1.checkBST(root));
		System.out.println(b1.checkBST1(root));
		System.out.println(b1.checkBST2(root));

		ValidBST b2 = new ValidBST();

		int[] array1 = { 1, 21, 3, 4, 5, 6, 7, 8, 9, 10 };
		BinaryTreeNode root1 = BinaryTreeNode.createMinimalBST(array1);
		root.displayTree();
		System.out.println(b2.checkBST(root1));
		System.out.println(b2.checkBST1(root1));
		System.out.println(b2.checkBST2(root1));

	}
}
