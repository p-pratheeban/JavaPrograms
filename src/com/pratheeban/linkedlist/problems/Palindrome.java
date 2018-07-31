package com.pratheeban.linkedlist.problems;

import java.util.Stack;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class Palindrome {
	
	public static boolean isPalindrome(ListNode head) {
		ListNode reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}

	private static ListNode reverseAndClone(ListNode node) {
		ListNode head = null;
		while (node != null) {
			ListNode n = new ListNode(node.data);
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}

	public static boolean isEqual(ListNode one, ListNode two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}
	
	public static boolean isPalindrome1(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;			
		}
		
		/* Has odd number of elements, so skip the middle */
		if (fast != null) { 
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	public static class Result {
		public ListNode node;
		public boolean result;
		public Result(ListNode n, boolean res) {
			node = n;
			result = res;
		}
	}

	public static Result isPalindromeRecurse(ListNode head, int length) {
		if (head == null || length <= 0) { // Even number of nodes
			return new Result(head, true);
		} else if (length == 1) { // Odd number of nodes
			return new Result(head.next, true);
		} 
		
		/* Recurse on sublist. */
		Result res = isPalindromeRecurse(head.next, length - 2);
		
		/* If child calls are not a palindrome, pass back up 
		 * a failure. */
		if (!res.result || res.node == null) {
			return res;
		} 
		
		/* Check if matches corresponding node on other side. */
		res.result = (head.data == res.node.data); 
		
		/* Return corresponding node. */
		res.node = res.node.next;
		
		return res;
	}
	
	public static int lengthOfList(ListNode n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}
	
	public static boolean isPalindrome2(ListNode head) {
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head, length);
		return p.result;
	}
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(0);
		list.inserAtLast(head);
		list.inserAtLast(new ListNode(1));
		list.inserAtLast(new ListNode(2));
		list.inserAtLast(new ListNode(1));
		list.inserAtLast(new ListNode(0));
		System.out.println(isPalindrome(head));
		System.out.println(isPalindrome1(head));
		System.out.println(isPalindrome2(head));

	}
}
