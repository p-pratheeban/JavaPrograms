package com.pratheeban.tree;

public class DiameterOfTree {
public static int diameter = 0;
	
	public int diameterOfTree(BinaryTreeNode root){
		int left, right;
		if(root == null) 
			return 0;
		left = diameterOfTree(root.getLeft());
		right = diameterOfTree(root.getRight());
		if(left + right > diameter)
			diameter = left + right;
		return Math.max(left, right)+1;
	}
	// Alternative Coding
	public int diameter(BinaryTreeNode root){
		if(root==null) return 0;

		//the path goes through the root
		int len1 = height(root.left) + height(root.right) +3;

		//the path does not pass the root
		int len2 = Math.max(diameter(root.left), diameter(root.right));

		return Math.max(len1, len2);
	}
	public int height(BinaryTreeNode root) {
		if(root == null) 
			return 0;
		/* compute the depth of each subtree */
		int leftDepth = height(root.getLeft());
		int rightDepth = height(root.right);
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	} 
}
