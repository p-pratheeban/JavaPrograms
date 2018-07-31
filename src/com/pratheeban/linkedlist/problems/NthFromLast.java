package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class NthFromLast {
	public static ListNode nthFromLast(ListNode head, int n) {
		if (head == null || n < 1) {
			return null;
		}
		ListNode firstPtr = head;
		ListNode secondPtr = head;
		for (int i = 0; i < n; i++) {
			if (firstPtr == null)
				return null;
			firstPtr = firstPtr.next;
		}
		while (firstPtr != null) {
			firstPtr = firstPtr.next;
			secondPtr = secondPtr.next;
		}
		return secondPtr;
	}

	public static int printKthToLast(ListNode head, int k) {
		if (head == null) {
			return 0;
		}
		int index = printKthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		return index;
	}

	/*
	 * Function to get the nth node from the last of a linked list
	 */
	static void printNthFromLast(ListNode head, int n) {
		int len = 0;
		ListNode temp = head;

		// 1) count the number of nodes in Linked List
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		// check if value of n is not more than length of
		// the linked list
		if (len < n)
			return;

		temp = head;

		// 2) get the (len-n+1)th node from the begining
		for (int i = 1; i < len - n + 1; i++)
			temp = temp.next;

		System.out.println(temp.data);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(5);
		list.inserAtLast(head);
		list.inserAtLast(new ListNode(6));
		list.inserAtLast(new ListNode(7));
		list.inserAtLast(new ListNode(1));
		list.inserAtLast(new ListNode(2));
		System.out.println(list.printList(head));
		ListNode n1 = nthFromLast(head, 4);
		System.out.println(n1.data);
		printKthToLast(head, 4);
		printNthFromLast(head, 4);
	}
}
