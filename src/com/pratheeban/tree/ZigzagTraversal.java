package com.pratheeban.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigzagTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		boolean leftToRight = true;
		ArrayList<Integer> curr = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				curr.add(tmp.data);
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				if (leftToRight) {
					ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
					res.add(c_curr);
					curr.clear();
				} else {
					Stack<Integer> s = new Stack<Integer>();
					s.addAll(curr);
					ArrayList<Integer> c_curr = new ArrayList<Integer>();
					while (!s.isEmpty()) {
						c_curr.add(s.pop());
					}
					res.add(c_curr);
					curr.clear();
				}
				if (!q.isEmpty()) {
					q.offer(null);
					leftToRight = !leftToRight;
				}
			}
		}
		return res;
	}

	public static void spiralOrZigzagLevelOrder(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);

		boolean directionflag = false;
		while (!stack.isEmpty()) {
			Stack<BinaryTreeNode> tempStack = new Stack<>();

			while (!stack.isEmpty()) {
				BinaryTreeNode tempNode = stack.pop();
				System.out.printf("%d ", tempNode.data);
				if (!directionflag) {
					if (tempNode.left != null)
						tempStack.push(tempNode.left);
					if (tempNode.right != null)
						tempStack.push(tempNode.right);
				} else {
					if (tempNode.right != null)
						tempStack.push(tempNode.right);
					if (tempNode.left != null)
						tempStack.push(tempNode.left);
				}
			}
			// for changing direction
			directionflag = !directionflag;

			stack = tempStack;
		}
	}
	public static void main(String[] args) {
		BinaryTreeNode b = BinaryTreeNode.createBinaryTree();
		spiralOrZigzagLevelOrder(b);
	}
}
