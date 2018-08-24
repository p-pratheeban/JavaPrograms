package com.pratheeban.linkedlist.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class DeleteSum {
	public static void removeZeroSumElements(ListNode root) {
		ListNode start = root;
		Stack<ListNode> stack = new Stack<>();
		boolean flag = false;
		List<ListNode> list = new ArrayList<>();
		while (start != null) {
			if (start.data > 0)
				stack.push(start);
			else {
				int sum = start.data;
				flag = false;
				while (!stack.isEmpty()) {
					ListNode temp = stack.pop();
					sum += temp.data;
					if (sum == 0) {
						flag = true;
						list.clear();
						break;
					}
					list.add(temp);
				}
				if (!flag) {
					list.forEach(i -> stack.add(i));
					stack.add(start);
				}
			}
			start = start.next;
		}
		stack.forEach(i -> System.out.print(i.data + " -> "));
		System.out.println("NULL");
	}

	public static ListNode removeZeroSumElements1(ListNode head) {
		ListNode temp = new ListNode(0);
		ListNode start = temp;
		ListNode end = null;
		int sum = 0;
		boolean modified = false;

		while (head != null) {
			end = head;
			sum = 0;
			modified = false;

			while (end != null) {
				sum += end.data;
				if (sum == 0) {
					start.next = end.next;
					head = end.next;
					modified = true;
					break;
				}
				end = end.next;
			}
			if (!modified) {
				head = head.next;
				start = start.next;
			}
		}
		return temp.next;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(6);
		list.inserAtLast(head);
		list.inserAtLast(new ListNode(-16));
		list.inserAtLast(new ListNode(8));
		list.inserAtLast(new ListNode(14));
		list.inserAtLast(new ListNode(-12));
		list.inserAtLast(new ListNode(9));
		list.inserAtLast(new ListNode(18));
		list.inserAtLast(new ListNode(-8));
		list.inserAtLast(new ListNode(4));
		list.inserAtLast(new ListNode(-4));
		list.inserAtLast(new ListNode(14));
		list.inserAtLast(new ListNode(-14));
		list.inserAtLast(new ListNode(24));
		list.inserAtLast(new ListNode(-4));

		removeZeroSumElements(head);
		ListNode node = removeZeroSumElements1(head);
		System.out.println(list.printList(node));

	}
}
