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
	public static BinaryTreeNode commonAncestor(BinaryTreeNode p, BinaryTreeNode q) {
		int delta = depth(p) -depth(q);
		BinaryTreeNode first = delta > 0 ? q : p; // get shallower node
		BinaryTreeNode second = delta > 0 ? p : q; // get deeper node
		second = goUpBy(second, Math.abs(delta)); // move shallower node to depth of deeper
		while (first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}
		return first == null || second == null ? null : first;
	}
	public static BinaryTreeNode goUpBy(BinaryTreeNode n,int delta) {
		while(delta>0&& n!=null) {
			n=n.parent;
			delta--;
		}
		return n;
	}
	
	public static int depth(BinaryTreeNode n) {
		int depth=0;
		while(n!=null) {
			n = n.parent;
			depth++;
		}
		return depth;
	}
	public static void main(String[] args) {
		BinaryTreeNode rootNode = BinaryTreeNode.createBinaryTree();
		System.out.println("Lowest common ancestor for node 5 and 30:");
		BinaryTreeNode node5=new BinaryTreeNode(5);
		BinaryTreeNode node30=new BinaryTreeNode(30);
		System.out.println(lowestCommonAncestor(rootNode,node5,node30).data);
		
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		BinaryTreeNode bt = BinaryTreeNode.createMinimalBST(array);
		bt.displayTree();
		BinaryTreeNode p = bt.left.left;
		BinaryTreeNode q= bt.left.right.right;
		System.out.println(commonAncestor(p, q));
	}
 
}
