package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class Partion {
	static ListNode partion(ListNode node, int x) {
		ListNode head = node;
		ListNode tail = node;
		while (node != null) {
			ListNode next = node.next;
			if (node.data < x) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}

	static ListNode partion1(ListNode node, int x) {
		ListNode beforeStart = null;
		ListNode afterStart = null;
		while (node != null) {
			ListNode next = node.next;
			if (node.data < x) {
				node.next = beforeStart;
				beforeStart = node;
			} else {
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}
		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}

		ListNode head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
	}
	
	public static ListNode partition(ListNode node, int x) {
		ListNode beforeStart = null;
		ListNode beforeEnd = null;
		ListNode afterStart = null;
		ListNode afterEnd = null;
		
		/* Partition list */
		while (node != null) {
			ListNode next = node.next;
			node.next = null;
			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}	
			node = next;
		}
		
		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
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

		ListNode node = partion(head, 4);
		System.out.println(list.printList(node));
		
		LinkedList list1 = new LinkedList();
		ListNode head1 = new ListNode(5);
		list1.inserAtLast(head1);
		list1.inserAtLast(new ListNode(6));
		list1.inserAtLast(new ListNode(7));
		list1.inserAtLast(new ListNode(1));
		list1.inserAtLast(new ListNode(2));
		System.out.println(list1.printList(head1));

		ListNode node1 = partion1(head1, 4);
		System.out.println(list1.printList(node1));
		
		LinkedList list2 = new LinkedList();
		ListNode head2 = new ListNode(15);
		list2.inserAtLast(head2);
		list2.inserAtLast(new ListNode(6));
		list2.inserAtLast(new ListNode(17));
		list2.inserAtLast(new ListNode(1));
		list2.inserAtLast(new ListNode(2));
		System.out.println(list2.printList(head2));

		ListNode node2 = partition(head2, 4);
		System.out.println(list2.printList(node2));
	}
}
