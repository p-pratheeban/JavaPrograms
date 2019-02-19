package com.pratheeban.tree;

public class CheckStructurullySameTrees {
	public boolean checkStructurullySameTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return (checkStructurullySameTrees(root1.left, root2.right)
				&& checkStructurullySameTrees(root1.right, root2.left));
	}
}
