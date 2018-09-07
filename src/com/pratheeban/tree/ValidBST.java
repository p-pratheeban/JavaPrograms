package com.pratheeban.tree;

public class ValidBST {
	int index = 0;
	Integer last_printed = null;
	private static BinaryTreeNode prev;

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

	// O(n) runtime, O(n) stack space – Top-down recursion
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

	public static boolean isBST(BinaryTreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data > min && root.data < max) {
			return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
		}
		return false;
	}

	public static boolean isBinarySearchTree(BinaryTreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.getData() <= min || root.getData() > max) {
			return false;
		}

		return isBinarySearchTree(root.getLeft(), min, root.getData())
				&& isBinarySearchTree(root.getRight(), root.getData(), max);
	}

	public static boolean isValidBST(BinaryTreeNode root) {
		prev = null;
		return isMonotonicIncreasing(root);
	}

	// O(n) runtime, O(n) stack space – In-order traversal
	private static boolean isMonotonicIncreasing(BinaryTreeNode p) {
		if (p == null)
			return true;
		if (isMonotonicIncreasing(p.left)) {
			if (prev != null && p.data <= prev.data)
				return false;
			prev = p;
			return isMonotonicIncreasing(p.right);
		}
		return false;
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
		System.out.println(b1.isValidBST(root));
		System.out.println(b1.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		ValidBST b2 = new ValidBST();

		int[] array1 = { 1, 21, 3, 4, 5, 6, 7, 8, 9, 10 };
		BinaryTreeNode root1 = BinaryTreeNode.createMinimalBST(array1);
		root.displayTree();
		System.out.println(b2.checkBST(root1));
		System.out.println(b2.checkBST1(root1));
		System.out.println(b2.checkBST2(root1));
		System.out.println(b2.isValidBST(root1));
		System.out.println(b2.isBST(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}
}
