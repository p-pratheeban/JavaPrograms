package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class ReverseLinkedList {
	public static ListNode reverseLinkedList(ListNode head) {
		ListNode current = head;
		ListNode nextNode = null;
		ListNode previousNode = null;
		while (current != null) {
			nextNode = head.next;
			current.next = previousNode;
			previousNode = current;
			current = nextNode;

		}
		return previousNode;
	}

	public static ListNode reverseLinkedList1(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}

		ListNode remaining = reverseLinkedList1(node.next);
		node.next.next = node;
		node.next = null;
		return remaining;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(5);
		list.inserAtLast(head);
		list.inserAtLast(new ListNode(6));
		list.inserAtLast(new ListNode(7));
		list.inserAtLast(new ListNode(1));
		list.inserAtLast(new ListNode(2));
		System.out.println(list);
		System.out.println(list.printList(head));
		ListNode n1 = list.nthFromLastNode(head, 2);
		System.out.println(n1.data);

		ListNode node = reverseLinkedList(head);
		System.out.println(list.printList(node));
		ListNode node1 = reverseLinkedList(node);
		System.out.println(list.printList(node1));

		LinkedList list1 = new LinkedList();
		// Creating a linked list
		ListNode loopNode=new ListNode(7);
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
		// Test if loop existed or not
		System.out.println("Loop existed-->" + list1.ifLoopExist());
	}
}
