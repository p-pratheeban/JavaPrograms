package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.ListNode;

public class Intersection {
	public static class Result {
		public ListNode tail;
		public int size;

		public Result(ListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	public static Result getTailAndSize(ListNode list) {
		if (list == null)
			return null;

		int size = 1;
		ListNode current = list;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}

	public static ListNode getKthNode(ListNode head, int k) {
		ListNode current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}

	public static ListNode findIntersection(ListNode list1, ListNode list2) {
		if (list1 == null || list2 == null)
			return null;

		/* Get tail and sizes. */
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);

		/* If different tail nodes, then there's no intersection. */
		if (result1.tail != result2.tail) {
			return null;
		}

		/* Set pointers to the start of each linked list. */
		ListNode shorter = result1.size < result2.size ? list1 : list2;
		ListNode longer = result1.size < result2.size ? list2 : list1;

		/*
		 * Advance the pointer for the longer linked list by the difference in lengths.
		 */
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));

		/* Move both pointers until you have a collision. */
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		/* Return either one. */
		return longer;
	}

}
