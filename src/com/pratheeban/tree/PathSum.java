package com.pratheeban.tree;

public class PathSum {
	private int maxSum;

	public static int countPathsWithSum(BinaryTreeNode root, int targetSum) {
		if (root == null)
			return 0;

		/* Count paths with sum starting from the root. */
		int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

		/* Try the nodes on the left and right. */
		int pathsOnLeft = countPathsWithSum(root.left, targetSum);
		int pathsOnRight = countPathsWithSum(root.right, targetSum);

		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}

	/* Returns the number of paths with this sum starting from this node. */
	public static int countPathsWithSumFromNode(BinaryTreeNode node, int targetSum, int currentSum) {
		if (node == null)
			return 0;

		currentSum += node.data;

		int totalPaths = 0;
		if (currentSum == targetSum) { // Found a path from the root
			totalPaths++;
		}

		totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum); // Go left
		totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum); // Go right

		return totalPaths;
	}

	public int maxPathSum(BinaryTreeNode root) {
		maxSum = Integer.MIN_VALUE;
		findMax(root);
		return maxSum;
	}

	private int findMax(BinaryTreeNode p) {
		if (p == null)
			return 0;
		int left = findMax(p.left);
		int right = findMax(p.right);
		maxSum = Math.max(p.data + left + right, maxSum);
		int ret = p.data + Math.max(left, right);
		return ret > 0 ? ret : 0;
	}
	
	public static boolean hasPathSum(BinaryTreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.getLeft() == null && root.right == null && root.data == sum)
			return true;
		else
			return hasPathSum(root.getLeft(), sum - root.data) || hasPathSum(root.right, sum - root.data);
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 1, 3, 1, 5 };

		BinaryTreeNode t1 = BinaryTreeNode.createMinimalBST(array1);
		t1.displayTree();
		System.out.println(countPathsWithSum(t1, 2));
		
		PathSum p = new PathSum();
		System.out.println(p.maxPathSum(t1));
		
		System.out.println(hasPathSum(t1, 7));
		System.out.println(hasPathSum(t1, 8));

	}
}
