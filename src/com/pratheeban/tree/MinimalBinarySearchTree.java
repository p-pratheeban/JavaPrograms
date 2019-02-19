package com.pratheeban.tree;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class MinimalBinarySearchTree {
	private ListNode list;

	public static BinaryTreeNode createMinimalBST(int[] a) {
		return createMinimalBST(a, 0, a.length - 1);
	}

	// O(n) runtime, O(log n) stack space – Divide and conquer
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

	// O(n) runtime, O(log n) stack space – Brute force
	private static int findNode(ListNode root, int n) {
		int i = 0;
		while (root != null && i < n) {
			root = root.next;
			i++;
		}
		return root.data;
	}

	// O(n log n) runtime, O(log n) stack space – Brute force
	public static BinaryTreeNode createMinimalBST(ListNode a, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;

		BinaryTreeNode bt = new BinaryTreeNode(findNode(a, mid));
		bt.setLeft(createMinimalBST(a, start, mid - 1));
		bt.setRight(createMinimalBST(a, mid + 1, end));
		return bt;
	}

	// O(n) runtime, O(log n) stack space – Bottom-up recursion
	private BinaryTreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		BinaryTreeNode leftChild = sortedListToBST(start, mid - 1);
		BinaryTreeNode parent = new BinaryTreeNode(list.data);
		parent.left = leftChild;
		list = list.next;
		parent.right = sortedListToBST(mid + 1, end);
		return parent;
	}

	public BinaryTreeNode sortedListToBST(ListNode head) {
		int n = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			n++;
		}
		list = head;
		return sortedListToBST(0, n - 1);
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		BinaryTreeNode bt = createMinimalBST(array);
		bt.displayTree();

		LinkedList list2 = new LinkedList();
		ListNode head2 = new ListNode(115);
		list2.inserAtLast(head2);
		list2.inserAtLast(new ListNode(116));
		list2.inserAtLast(new ListNode(117));
		list2.inserAtLast(new ListNode(118));
		list2.inserAtLast(new ListNode(122));

		MinimalBinarySearchTree mt = new MinimalBinarySearchTree();
		BinaryTreeNode bt1 = mt.sortedListToBST(head2);
		bt1.displayTree();

		BinaryTreeNode bt2 = createMinimalBST(head2, 0, list2.length() - 1);
		bt2.displayTree();
	}
}
