package com.pratheeban.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTravesal {

	public void PreOrder(BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root.data);
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

	public void InOrder(BinaryTreeNode root) {
		if (root != null) {
			InOrder(root.left);
			System.out.println(root.data);
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
	
	public void postorderIter( BinaryTreeNode root) {
		if( root == null ) return;
 
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>( );
		BinaryTreeNode current = root;
 
		while( true ) {
 
			if( current != null ) {
				if( current.right != null ) 
					s.push( current.right );
				s.push( current );
				current = current.left;
				continue;
			}
 
			if( s.isEmpty( ) ) 
				return;
			current = s.pop( );
 
			if( current.right != null && ! s.isEmpty( ) && current.right == s.peek( ) ) {
				s.pop( );
				s.push( current );
				current = current.right;
			} else {
				System.out.print( current.data + " " );
				current = null;
			}
		}
	}
	static void postOder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s1 = new Stack<>();
		Stack<BinaryTreeNode> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()) {
			BinaryTreeNode node = s1.pop();
			s2.push(node);
			if(node.left!=null) {
				s1.push(node.left);
			}
			if(node.right!=null) {
				s1.push(node.right);
			}
		}
		while(!s2.isEmpty()) {
			System.out.print(s2.pop().data + "\t");
		}
	}
	static void postoder(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		Stack<BinaryTreeNode> stack = new Stack<>();
		while(current!=null || !stack.isEmpty()) {
			if(current!=null) {
				stack.push(current);
				current = current.left;
			}else {
				BinaryTreeNode temp = stack.peek().right;
				if(temp!=null) {
					current = temp;
				}else {
					temp = stack.pop();
					System.out.print(temp.data+"\t");

					while(!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						System.out.print(temp.data+"\t");
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
	public static void main(String[] args) {
		System.out.println("Level Oder");
		BinaryTreeNode root = BinaryTreeNode.createBinaryTree();
		levelOrder(root);
		System.out.println("\nPost Oder");
		postOder(root);
		System.out.println();
		postoder(root);
	}
}
