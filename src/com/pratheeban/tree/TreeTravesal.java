package com.pratheeban.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TreeTravesal {

	public static void PreOrder(BinaryTreeNode root) {
		if (root != null) {
			System.out.print(root.data + "\t");
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}

	public ArrayList<Integer> preorderTraversal(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			BinaryTreeNode tmp = s.pop();
			res.add(tmp.data);
			// pay more attention to this sequence.
			if (tmp.right != null)
				s.push(tmp.right);
			if (tmp.getLeft() != null)
				s.push(tmp.getLeft());
		}
		return res;
	}

	public static void InOrder(BinaryTreeNode root) {
		if (root != null) {
			InOrder(root.left);
			System.out.print(root.data + "\t");
			InOrder(root.right);
		}
	}

	public ArrayList<Integer> inorderTraversal(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode curr = root;
		// traverse the tree
		while (curr != null || s.size() > 0) {

			/*
			 * Reach the left most Node of the curr Node
			 */
			while (curr != null) {
				/*
				 * place pointer to a tree node on the stack before traversing the node's left
				 * subtree
				 */
				s.push(curr);
				curr = curr.left;
			}

			/* Current must be NULL at this point */
			curr = s.pop();

			res.add(curr.getData());
			/*
			 * we have visited the node and its left subtree. Now, it's right subtree's turn
			 */
			curr = curr.right;
		}
		return res;
	}

	public void PostOrder(BinaryTreeNode root) {
		if (root != null) {
			PostOrder(root.left);
			PostOrder(root.right);
			System.out.println(root.data);
		}
	}

	public ArrayList<Integer> postorderTraversal(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		BinaryTreeNode prev = null;
		while (!s.isEmpty()) {
			BinaryTreeNode curr = s.peek();
			if (prev == null || prev.getLeft() == curr || prev.right == curr) {
				// traverse from top to bottom, and if curr has left child or right child,
				// push into the stack; otherwise, pop out.
				if (curr.getLeft() != null)
					s.push(curr.getLeft());
				else if (curr.right != null)
					s.push(curr.right);
			} else if (curr.getLeft() == prev) {
				if (curr.right != null)
					s.push(curr.right);
			} else {
				res.add(curr.data);
				s.pop();
			}
			prev = curr;
		}
		return res;
	}

	public void postorderIter(BinaryTreeNode root) {
		if (root == null)
			return;

		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode current = root;

		while (true) {

			if (current != null) {
				if (current.right != null)
					s.push(current.right);
				s.push(current);
				current = current.left;
				continue;
			}

			if (s.isEmpty())
				return;
			current = s.pop();

			if (current.right != null && !s.isEmpty() && current.right == s.peek()) {
				s.pop();
				s.push(current);
				current = current.right;
			} else {
				System.out.print(current.data + " ");
				current = null;
			}
		}
	}

	static void postOder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s1 = new Stack<>();
		Stack<BinaryTreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			BinaryTreeNode node = s1.pop();
			s2.push(node);
			if (node.left != null) {
				s1.push(node.left);
			}
			if (node.right != null) {
				s1.push(node.right);
			}
		}
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().data + "\t");
		}
	}

	static void postoder(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		Stack<BinaryTreeNode> stack = new Stack<>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				BinaryTreeNode temp = stack.peek().right;
				if (temp != null) {
					current = temp;
				} else {
					temp = stack.pop();
					System.out.print(temp.data + "\t");

					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						System.out.print(temp.data + "\t");
					}
				}
			}
		}
	}

	// Prints level order traversal line
	// by line using two queues.
	static void levelOrder(BinaryTreeNode root) {
		if (root == null)
			return;

		Queue<BinaryTreeNode> q = new LinkedList<>();

		// Pushing root node into the queue.
		q.add(root);

		// Pushing delimiter into the queue.
		q.add(null);

		// Executing loop till queue becomes
		// empty
		while (!q.isEmpty()) {

			BinaryTreeNode curr = q.poll();

			// condition to check the
			// occurence of next level
			if (curr == null) {
				if (!q.isEmpty()) {
					q.add(null);
					System.out.println();
				}
			} else {
				// Pushing left child current node
				if (curr.left != null)
					q.add(curr.left);

				// Pushing right child current node
				if (curr.right != null)
					q.add(curr.right);

				System.out.print(curr.data + " ");
			}
		}
	}

	public static void leveloder(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q1 = new LinkedList<>();
		Queue<BinaryTreeNode> q2 = new LinkedList<>();
		q1.add(root);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			while (!q1.isEmpty()) {
				BinaryTreeNode b1 = q1.poll();
				System.out.print(b1.data + "\t");
				if (b1.left != null) {
					q2.add(b1.left);
				}
				if (b1.right != null) {
					q2.add(b1.right);
				}
			}
			System.out.println();
			while (!q2.isEmpty()) {
				BinaryTreeNode b2 = q2.poll();
				System.out.print(b2.data + "\t");
				if (b2.left != null) {
					q1.add(b2.left);
				}
				if (b2.right != null) {
					q1.add(b2.right);
				}
			}
			System.out.println();

		}
	}

	public static void bfs(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode node = queue.remove();
			System.out.println(node.data);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public static void levelOderTravesal(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q1 = new LinkedList<>();
		q1.add(root);
		int levelCount = 1;
		int currentCount = 0;
		while (!q1.isEmpty()) {
			while (levelCount > 0) {
				BinaryTreeNode b1 = q1.poll();
				System.out.print(b1.data + "\t");
				if (b1.left != null) {
					q1.add(b1.left);
					currentCount++;
				}
				if (b1.right != null) {
					q1.add(b1.right);
					currentCount++;
				}
				levelCount--;
			}
			System.out.println();
			levelCount = currentCount;
			currentCount = 0;
		}
	}

	public static void levelOderReversal(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q1 = new LinkedList<>();
		q1.add(root);
		Stack<BinaryTreeNode> s = new Stack<>();
		while (!q1.isEmpty()) {
			BinaryTreeNode b1 = q1.poll();
			if (b1.right != null) {
				q1.add(b1.right);
			}
			if (b1.left != null) {
				q1.add(b1.left);
			}
			s.push(b1);
		}
		while (!s.isEmpty()) {
			System.out.print(s.pop().data + "\t");
		}
		System.out.println();
	}

	public static void printLevelOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode> curLevel = new LinkedList<>();
		Queue<BinaryTreeNode> nextLevel = new LinkedList<>();
		curLevel.add(root);
		while (!curLevel.isEmpty()) {
			while (!curLevel.isEmpty()) {
				BinaryTreeNode curNode = curLevel.poll();
				System.out.print(curNode.data + " ");
				if (curNode.left != null) {
					nextLevel.add(curNode.left);
				}
				if (curNode.right != null) {
					nextLevel.add(curNode.right);
				}
			}
			System.out.println();
			curLevel = nextLevel;
			nextLevel = new LinkedList<BinaryTreeNode>();
		}
	}

	public static void makeVerticalLevelOrder(BinaryTreeNode root, int hd, Map<Integer, List<Integer>> hm,
			int[] minMax) {
		if (root == null) {
			return;
		}
		// save the minimum and maximum
		// horizontal distance (hd) of current node from root
		minMax[0] = Math.min(minMax[0], hd);
		minMax[1] = Math.max(minMax[1], hd);
		List<Integer> curHdLevel;
		if (hm.containsKey(hd)) {
			curHdLevel = hm.get(hd);
		} else {
			curHdLevel = new LinkedList<Integer>();
		}
		curHdLevel.add(root.data);
		hm.put(hd, curHdLevel);
		makeVerticalLevelOrder(root.left, hd - 1, hm, minMax);
		makeVerticalLevelOrder(root.right, hd + 1, hm, minMax);
	}

	public static void printVerticalLevelOder(BinaryTreeNode root) {
		Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
		int minMax[] = new int[2];
		makeVerticalLevelOrder(root, 0, hm, minMax);
		// print the list
		for (int lvl = minMax[0]; lvl <= minMax[1]; lvl++) {
			List<Integer> curHdLevel = hm.get(lvl);
			for (Integer node : curHdLevel) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
	}

	public static List<LinkedList<BinaryTreeNode>> createLevelLinkedListBST(BinaryTreeNode root) {
		List<LinkedList<BinaryTreeNode>> result = new ArrayList<>();
		LinkedList<BinaryTreeNode> current = new LinkedList<>();
		if (root != null) {
			current.add(root);
		}
		while (!current.isEmpty()) {
			result.add(current);
			LinkedList<BinaryTreeNode> parents = current;
			current = new LinkedList<BinaryTreeNode>();
			for (BinaryTreeNode node : parents) {
				if (node.left != null) {
					current.add(node.left);
				}
				if (node.right != null) {
					current.add(node.right);
				}
			}
		}
		return result;
	}

	public static void createLevelLinkedListDFS(BinaryTreeNode root, ArrayList<LinkedList<BinaryTreeNode>> lists,
			int level) {
		if (root == null)
			return;
		LinkedList<BinaryTreeNode> list = null;
		if (lists.size() == level) { // Level not contained in list
			list = new LinkedList<BinaryTreeNode>();
			/*
			 * Levels are always traversed in order. So, if this is the first time we've
			 * visited level i, we must have seen levels 0 through i - 1. We can therefore
			 * safely add the level at the end.
			 */
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedListDFS(root.left, lists, level + 1);
		createLevelLinkedListDFS(root.right, lists, level + 1);
	}

	public static ArrayList<LinkedList<BinaryTreeNode>> createLevelLinkedList(BinaryTreeNode root) {
		ArrayList<LinkedList<BinaryTreeNode>> lists = new ArrayList<LinkedList<BinaryTreeNode>>();
		createLevelLinkedListDFS(root, lists, 0);
		return lists;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeNode.createBinaryTree();
		root.displayTree();
		System.out.println("\nIn Oder");
		InOrder(root);
		System.out.println("\nPre Oder");
		PreOrder(root);
		System.out.println("\nPost Oder");
		postOder(root);
		System.out.println();
		postoder(root);
		System.out.println("\nLevel Oder");
		levelOrder(root);
		System.out.println("\nlevel Oder");
		leveloder(root);
		System.out.println("\nlevel Oder");
		levelOderTravesal(root);
		System.out.println("\nReverse level Oder");
		levelOderReversal(root);
		System.out.println("\nVertical level Oder");
		printVerticalLevelOder(root);
		System.out.println("\nlevel Oder List");

		List<LinkedList<BinaryTreeNode>> result = createLevelLinkedListBST(root);
		for (LinkedList<BinaryTreeNode> level : result)
			System.out.println(level);

		System.out.println("\nlevel Oder List");

		List<LinkedList<BinaryTreeNode>> result1 = createLevelLinkedList(root);
		for (LinkedList<BinaryTreeNode> level : result1)
			System.out.println(level);

	}
}
