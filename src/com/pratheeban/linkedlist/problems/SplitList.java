package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class SplitList {
	public static String printList(ListNode head) {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		result = result + head.getData();
		ListNode temp = head.getNext();
		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}

	public static void splitList(ListNode head) {
		ListNode first = head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast != null) {
			fast = fast.next;
			if (fast == null) {
				break;
			}
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
			}
		}

		ListNode second = slow.next;
		slow.next = null;
		System.out.println(printList(first));
		System.out.println(printList(second));

	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(10);
		list.inserAtLast(head);
		list.inserAtLast(new ListNode(1));
		list.inserAtLast(new ListNode(2));
		list.inserAtLast(new ListNode(11));
		list.inserAtLast(new ListNode(10));
		splitList(head);
	}
}
