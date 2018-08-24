package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class MergeList {

	public static ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode temp = head;
		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				temp.next = l1;
				l1 = l1.next;
			} else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		temp.next = (l1 == null) ? l2 : l1;
		return head.next;
	}

	public static ListNode merge1(ListNode l1, ListNode l2) {
		ListNode result = null;
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		if (l1.data < l2.data) {
			result = l1;
			result.next = merge1(l1.next, l2);
		} else {
			result = l2;
			result.next = merge1(l1, l2.next);
		}

		return result;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(10);
		list.inserAtLast(head);
		list.inserAtLast(new ListNode(17));
		list.inserAtLast(new ListNode(22));
		list.inserAtLast(new ListNode(43));
		list.inserAtLast(new ListNode(49));

		LinkedList list1 = new LinkedList();
		ListNode head1 = new ListNode(9);
		list1.inserAtLast(head1);
		list1.inserAtLast(new ListNode(18));
		list1.inserAtLast(new ListNode(20));
		list1.inserAtLast(new ListNode(43));
		list1.inserAtLast(new ListNode(59));

		ListNode node = merge(head, head1);
		System.out.println("Merge I");
		System.out.println(list.printList(node));
		LinkedList list2 = new LinkedList();
		ListNode head2 = new ListNode(10);
		list2.inserAtLast(head2);
		list2.inserAtLast(new ListNode(17));
		list2.inserAtLast(new ListNode(22));
		list2.inserAtLast(new ListNode(43));
		list2.inserAtLast(new ListNode(49));

		LinkedList list3 = new LinkedList();
		ListNode head3 = new ListNode(9);
		list3.inserAtLast(head3);
		list3.inserAtLast(new ListNode(18));
		list3.inserAtLast(new ListNode(20));
		list3.inserAtLast(new ListNode(43));
		list3.inserAtLast(new ListNode(59));
		System.out.println("Merge II");
		ListNode node1 = merge1(head2, head3);
		System.out.println(list1.printList(node1));

	}
}
