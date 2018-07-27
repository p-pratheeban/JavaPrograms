package com.pratheeban.tree;

public class LCA {
	//T(n) = O(n)
	public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
		if(root == null)
			return null;
		if(root.data == a.data || root.data == b.data )
			return root;
 
		BinaryTreeNode left=lowestCommonAncestor(root.left,a,b);
		BinaryTreeNode right=lowestCommonAncestor(root.right,a,b);
 
		// If we get left and right not null , it is lca for a and b
		if(left!=null && right!=null)
			return root;
		if(left== null)
			return right;
		else
			return left;
 
	}
	public static void main(String[] args) {
		BinaryTreeNode rootNode = BinaryTreeNode.createBinaryTree();
		System.out.println("Lowest common ancestor for node 5 and 30:");
		BinaryTreeNode node5=new BinaryTreeNode(5);
		BinaryTreeNode node30=new BinaryTreeNode(30);
		System.out.println(lowestCommonAncestor(rootNode,node5,node30).data);
	}
 
}
