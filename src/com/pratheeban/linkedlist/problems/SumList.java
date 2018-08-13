package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class SumList {
	public static ListNode sumList(ListNode list1, ListNode list2, int carry) {
		if (list1 == null && list2 == null && carry == 0) {
			return null;
		}
		ListNode result = new ListNode();
		int value = carry;
		if (list1 != null) {
			value += list1.data;
		}
		if (list2 != null) {
			value += list2.data;
		}
		result.data = value % 10;
		if (list1 != null || list2 != null) {
			ListNode more = sumList(list1 == null ? null : list1.next, list2 == null ? null : list2.next,
					value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}

	static class PartialSum {
		public ListNode sum = null;
		public int carry = 0;
	}

	private static int length(ListNode l) {
		if (l == null) {
			return 0;
		} else {
			return 1 + length(l.next);
		}
	}

	private static PartialSum addListsHelper(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		ListNode full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	private static ListNode addLists(ListNode l1, ListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		PartialSum sum = addListsHelper(l1, l2);
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			ListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	private static ListNode padList(ListNode l, int padding) {
		ListNode head = l;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}

	private static ListNode insertBefore(ListNode list, int data) {
		ListNode node = new ListNode(data);
		if (list != null) {
			node.next = list;
		}
		return node;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.data : 0;
			int y = (q != null) ? q.data : 0;
			int digit = carry + x + y;
			carry = digit / 10;
			curr.next = new ListNode(digit % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();// 617
		ListNode head1 = new ListNode(7);
		list1.inserAtLast(head1);
		list1.inserAtLast(new ListNode(1));
		list1.inserAtLast(new ListNode(6));

		LinkedList list2 = new LinkedList();// 295
		ListNode head2 = new ListNode(5);
		list2.inserAtLast(head2);
		list2.inserAtLast(new ListNode(9));
		list2.inserAtLast(new ListNode(2));

		ListNode result = sumList(head1, head2, 0);// 617+295=912
		System.out.println(list1.printList(result));
		
		ListNode result1 = addTwoNumbers(head1, head2);// 716+592=912
		System.out.println(list1.printList(result1));
	}
}
