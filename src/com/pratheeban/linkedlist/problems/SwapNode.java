package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class SwapNode {
	
	public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = head;
		ListNode prev = dummy;
		while (p != null && p.next != null) {
			ListNode q = p.next, r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		ListNode head1 = new ListNode(4);
		list1.inserAtLast(head1);
		list1.inserAtLast(new ListNode(7));
		list1.inserAtLast(new ListNode(9));
		list1.inserAtLast(new ListNode(18));
		list1.inserAtLast(new ListNode(30));
		System.out.println(list1.printList(head1));
		ListNode node = swapPairs(head1);
		System.out.println(list1.printList(node));
	}
	
	
}
