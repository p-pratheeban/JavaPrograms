package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class LoopDetection {
	public static ListNode FindBeginning(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		// Find meeting point
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (fast == null || fast.next == null) {
			return null;
		}

		/*
		 * Move slow to Head. Keep fast at Meeting Point. Each are k steps /* from the
		 * Loop Start. If they move at the same pace, they must meet at Loop Start.
		 */
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		// Both now point to the start of the loop.
		return fast;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		// Creating a linked list
		ListNode loopNode = new ListNode(7);
		list1.inserAtLast(new ListNode(15));
		list1.inserAtLast(new ListNode(6));
		list1.inserAtLast(new ListNode(7));
		list1.inserAtLast(new ListNode(16));
		list1.inserAtLast(loopNode);
		list1.inserAtLast(new ListNode(1));
		list1.inserAtLast(new ListNode(2));
		System.out.println(list1);

		// creating a loop
		list1.inserAtLast(loopNode);

		ListNode loop = FindBeginning(list1.getHead());
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
	}
}
