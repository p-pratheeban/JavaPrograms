package com.pratheeban.tree;

public class SubTree {
	public static boolean containsTree(BinaryTreeNode t1, BinaryTreeNode t2) {
		StringBuilder string1 = new StringBuilder();
		StringBuilder string2 = new StringBuilder();
		
		getOrderString(t1, string1);
		getOrderString(t2, string2);
		System.out.println(string1);
		System.out.println(string2);
		return string1.indexOf(string2.toString()) != -1;
	}
	public static void getOrderString(BinaryTreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("X");             // Add null indicator
			return;
		}
		sb.append(node.data);           // Add root 
		getOrderString(node.left, sb);  // Add left
		getOrderString(node.right, sb); // Add right
	}
	
	public static boolean containsTree1(BinaryTreeNode t1, BinaryTreeNode t2) {
		if (t2 == null) {
			return true; // The empty tree is a subtree of every tree.
		}
		return subTree(t1, t2);
	}
	
	/* Checks if the binary tree rooted at r1 contains the binary tree 
	 * rooted at r2 as a subtree somewhere within it.
	 */
	public static boolean subTree(BinaryTreeNode r1, BinaryTreeNode r2) {
		if (r1 == null) {
			return false; // big tree empty & subtree still not found.
		} else if (r1.data == r2.data && matchTree(r1,r2)) {
			return true;
		}
		return subTree(r1.left, r2) || subTree(r1.right, r2); 
	}

	/* Checks if the binary tree rooted at r1 contains the 
	 * binary tree rooted at r2 as a subtree starting at r1.
	 */
	public static boolean matchTree(BinaryTreeNode r1, BinaryTreeNode r2) {
		if (r1 == null && r2 == null) {
			return true; // nothing left in the subtree
		} else if (r1 == null || r2 == null) { 
			return false; // exactly tree is empty, therefore trees don't match
		} else if (r1.data != r2.data) {  
			return false;  // data doesn't match
		} else {
			return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
		}
	}
	public static void main(String[] args) {
		int[] array1 = {1, 2, 1, 3, 1, 1, 5};
		int[] array2 = {1, 2, 1};
		
		BinaryTreeNode t1 = BinaryTreeNode.createMinimalBST(array1);
		BinaryTreeNode t2 = BinaryTreeNode.createMinimalBST(array2);
		t1.displayTree();
		t2.displayTree();
		if (containsTree(t1, t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}
		
		if (containsTree1(t1, t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}
		
		BinaryTreeNode b = new BinaryTreeNode(4);
		b.CreateTree(array1);
		b.displayTree();
		System.out.println(b.find(3));
		System.out.println(b.getRandomNode());
	}
}
