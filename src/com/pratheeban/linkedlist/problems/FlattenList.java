package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class FlattenList {
	public static ListNode flaternList(java.util.LinkedList<LinkedList> mainList) {
		ListNode m = mainList.get(0).getHead();
		int size = mainList.size();
		int i = 1;
		while (size > 0 && i < size) {
			m = MergeList.merge(m, mainList.get(i++).getHead());
		}
		return m;
	}

	public static void main(String[] args) {
		/*
		 * Let us create the following linked list 5 -> 10 -> 19 -> 28 | | | | V V V V 7
		 * 20 22 35 | | | V V V 8 50 40 | V 30
		 */
		LinkedList list = new LinkedList();

		ListNode head = new ListNode(5);
		list.inserAtLast(head);
		list.inserAtLast(new ListNode(7));
		list.inserAtLast(new ListNode(8));
		list.inserAtLast(new ListNode(30));
		list.inserAtLast(new ListNode(10));

		LinkedList list1 = new LinkedList();
		ListNode head1 = new ListNode(10);
		list1.inserAtLast(head1);
		list1.inserAtLast(new ListNode(20));

		LinkedList list2 = new LinkedList();
		ListNode head2 = new ListNode(19);
		list2.inserAtLast(head2);
		list2.inserAtLast(new ListNode(22));
		list2.inserAtLast(new ListNode(50));

		LinkedList list3 = new LinkedList();
		ListNode head3 = new ListNode(28);
		list3.inserAtLast(head3);
		list3.inserAtLast(new ListNode(35));
		list3.inserAtLast(new ListNode(40));

		java.util.LinkedList<LinkedList> mainList = new java.util.LinkedList<>();
		mainList.add(list);
		mainList.add(list1);
		mainList.add(list2);
		mainList.add(list3);
		System.out.println(mainList);
		ListNode node = flaternList(mainList);
		System.out.println(list.printList(node));

	}
}
