package com.pratheeban.tree;

import java.util.Random;
import java.util.Stack;

public class BinaryTreeNode {
	public int data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public BinaryTreeNode parent;
	public int size = 0;

	public BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
		size = 1;
	}

	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public void insert(int d) {
		if (d <= data) {
			if (left == null) {
				left = new BinaryTreeNode(d);
			} else {
				left.insert(d);
			}
		} else {
			if (right == null) {
				right = new BinaryTreeNode(d);
			} else {
				right.insert(d);
			}
		}
		size++;
	}

	public int size() {
		return size;
	}

	public BinaryTreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	public BinaryTreeNode getRandomNode() {
		int leftSize = left == null ? 0 : left.size();
		Random r = new Random();
		int index = r.nextInt(size);
		if (index < leftSize) {
			return left.getRandomNode();
		} else if (index == leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}
	
	public BinaryTreeNode getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size();
		if (i < leftSize) {
			return left.getIthNode(i);
		} else if (i == leftSize) {
			return this;
		} else {
			return right.getIthNode(i - (leftSize + 1));
		}
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}

	// Sets the data stored in this node.
	public String toString() {
		return Integer.toString(data);
	}

	// Sets the data in this BinaryTreeNode node.
	public void setValue(int data) {
		this.data = data;
	}

	// Tests whether this node is a leaf node.
	public boolean isLeaf() {
		return left == null && right == null;
	}

	// Tests whether the root argument contains within itself the data argument.
	public static boolean findInBT(BinaryTreeNode root, int data) {
		if (root == null)
			return false;
		if (root.getData() == data)
			return true;
		return findInBT(root.getLeft(), data) || findInBT(root.getRight(), data);
	}

	// Returns a String representation of this BinaryTreeNode.
	public String display() {
		if (isLeaf()) {
			return this.toString();
		} else {
			String root, left = "null", right = "null";
			root = this.toString();
			if (getLeft() != null) {
				left = getLeft().toString();
			}
			if (getRight() != null) {
				right = getRight().toString();
			}
			return root + " (" + left + ", " + right + ")";
		}
	}

	// Computes a hash code for the complete binary tree rooted at this
	// BinaryTreeNode node.
	public int hashCode() {
		int result = this.hashCode();
		if (left != null) {
			result += 3 * left.hashCode();
		}
		if (right != null) {
			result += 7 * right.hashCode();
		}
		return result;
	}

	// Returns the total number of nodes in this binary tree (include the root in
	// the count).
	public int numberOfNodes() {
		int leftCount = this.left == null ? 0 : left.numberOfNodes();
		int rightCount = this.right == null ? 0 : right.numberOfNodes();
		return 1 + leftCount + rightCount;
	}

	// Returns a new BinaryTreeNode equal to (but not the same as) this binary tree.
	// Every node in this new BinaryTreeNode will be created by the copy method;
	// values
	// will be identical (==) to values in the given binary tree.
	public BinaryTreeNode copy() {
		BinaryTreeNode left = null, right = null;
		if (this.left != null) {
			left = this.left.copy();
		}
		if (this.right != null) {
			right = this.right.copy();
		}
		return new BinaryTreeNode(this.data, left, right);
	}

	// Returns a new binary tree which is the mirror image of the binary tree whose
	// root is at this binary tree. That is, for every node in the new binary tree,
	// its children are in reverse order (left child becomes right child, right
	// child becomes left child).
	public BinaryTreeNode reverse() {
		BinaryTreeNode left = null, right = null;
		if (this.left != null) {
			left = this.left.reverse();
		}
		if (this.right != null) {
			right = this.right.reverse();
		}
		return new BinaryTreeNode(this.data, right, left);
	}

	// Rearranges the binary tree rooted at this binary tree to be the mirror image
	// of its original structure. No new BinaryTreeNode nodes are created in this
	// process.
	public void reverseInPlace() {
		if (this.left != null) {
			left.reverseInPlace();
		}
		if (this.right != null) {
			right.reverseInPlace();
		}
		BinaryTreeNode temp = this.left;
		this.setLeft(this.right);
		this.setRight(temp);
	}

	public void CreateTree(int a[]) {
		for (int i = 0; i < a.length; i++) {
			insert(a[i]);
		}
	}

	public static BinaryTreeNode createMinimalBST(int[] a) {
		return createMinimalBST(a, 0, a.length - 1);
	}

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

	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(this);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while (isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (globalStack.isEmpty() == false) {
				BinaryTreeNode temp = (BinaryTreeNode) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if (temp.left != null || temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false
		System.out.println("......................................................");
	} // end displayTree()

	public static BinaryTreeNode createBinaryTree() {

		BinaryTreeNode rootNode = new BinaryTreeNode(40);
		BinaryTreeNode node20 = new BinaryTreeNode(20);
		BinaryTreeNode node10 = new BinaryTreeNode(10);
		BinaryTreeNode node30 = new BinaryTreeNode(30);
		BinaryTreeNode node60 = new BinaryTreeNode(60);
		BinaryTreeNode node50 = new BinaryTreeNode(50);
		BinaryTreeNode node70 = new BinaryTreeNode(70);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node45 = new BinaryTreeNode(45);
		BinaryTreeNode node55 = new BinaryTreeNode(55);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		node10.right = node5;
		node5.right = node45;

		node50.right = node55;
		return rootNode;
	}
}
