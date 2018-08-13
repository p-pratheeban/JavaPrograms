package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class Merge {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null)
			p.next = l1;
		if (l2 != null)
			p.next = l2;
		return dummyHead.next;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(5);
		list.inserAtLast(head);
		list.inserAtLast(new ListNode(6));
		list.inserAtLast(new ListNode(7));
		list.inserAtLast(new ListNode(11));
		list.inserAtLast(new ListNode(20));

		LinkedList list1 = new LinkedList();
		ListNode head1 = new ListNode(4);
		list1.inserAtLast(head1);
		list1.inserAtLast(new ListNode(7));
		list1.inserAtLast(new ListNode(9));
		list1.inserAtLast(new ListNode(18));
		list1.inserAtLast(new ListNode(30));

		ListNode merge = mergeTwoLists(head, head1);
		System.out.println(list.printList(merge));
	}
}
