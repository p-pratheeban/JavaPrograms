package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class MiddleElement {

	public static ListNode getMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static int length(ListNode head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}

	public static ListNode getMiddle1(ListNode head) {
		int len = length(head);
		ListNode mid = head;
		for (int i = 0; i < len / 2; i++) {
			if (mid != null) {
				mid = mid.next;
			}
		}
		return mid;
	}

	public static ListNode getMiddle2(ListNode head) {
		int count = 0;
		ListNode mid = head;
		while (head != null) {
			if((count&1)==1) {
				mid = mid.next;
			}
			head = head.next;
			count++;
		}
		return mid;
	}
	
	public static ListNode deleteMiddle(ListNode head) {
		ListNode temp = head;
		ListNode fast =head;
		ListNode slow = head;
		ListNode prev= null;
		while(fast!=null && fast.next!=null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = slow.next.next;
		return temp;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(0);
		list.inserAtLast(head);
		list.inserAtLast(new ListNode(1));
		list.inserAtLast(new ListNode(2));
		list.inserAtLast(new ListNode(3));
		list.inserAtLast(new ListNode(4));
		list.inserAtLast(new ListNode(5));
		list.inserAtLast(new ListNode(6));
		//list.inserAtLast(new ListNode(7));

		System.out.println(getMiddle(head));
		System.out.println(getMiddle1(head));
		System.out.println(getMiddle2(head));
		System.out.println(list.printList(deleteMiddle(head)));

	}
}
