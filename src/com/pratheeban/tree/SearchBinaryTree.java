package com.pratheeban.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchBinaryTree {
	public static boolean findInBT(BinaryTreeNode root, int data) {
		if (root == null)
			return false;
		if (root.getData() == data)
			return true;
		return findInBT(root.getLeft(), data) || findInBT(root.getRight(), data);
	}
	
	public boolean findInBT1(BinaryTreeNode root, int data){
    	if(root == null)
            return false;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
        	if (tmp.getData() == data){
        		return true;
        	}
            if(tmp != null){
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                if(tmp.right != null)
                    q.offer(tmp.right);
            }
        }
        return false;
    }
}
