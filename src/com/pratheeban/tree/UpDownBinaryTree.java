package com.pratheeban.tree;

public class UpDownBinaryTree {
	public static BinaryTreeNode UpsideDownBinaryTree(BinaryTreeNode root) {
		BinaryTreeNode p = root, parent = null, parentRight = null;
		while (p != null) {
			BinaryTreeNode left = p.left;
			p.left = parentRight;
			parentRight = p.right;
			p.right = parent;
			parent = p;
			p = left;
		}
		return parent;
	}
	public static void main(String[] args) {
		BinaryTreeNode btn = BinaryTreeNode.createBinaryTree();
		btn.displayTree();
		
		BinaryTreeNode bt= UpsideDownBinaryTree(btn);
		bt.displayTree();
	}
}
