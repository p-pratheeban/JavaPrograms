package com.pratheeban.tree;

public class CheckMirrors {
	public boolean areMirrors(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.data != root2.data)
			return false;
		else
			return (areMirrors(root1.getLeft(), root2.right) && areMirrors(root1.right, root2.getLeft()));
	}
}
