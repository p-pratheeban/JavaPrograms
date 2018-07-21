package com.pratheeban.linkedlist.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import com.pratheeban.linkedlist.ListNode;

public class RemoveDup {
	public static List<Integer> removeDup(List<Integer> l) {
		Map<Integer, Integer> g = new HashMap<>();
		for (Integer i : l) {
			if (g.get(i) != null && g.get(i) > 0) {
				l.remove(i);
			} else {
				g.put(i, 1);
			}
		}
		return l;
	}

	public static List<Integer> removeDup1(List<Integer> l) {
		Set<Integer> g = new HashSet<>();
		for (Integer i : l) {
			if (g.contains(i)) {
				l.remove(i);
			} else {
				g.add(i);
			}
		}
		return l;
	}

	public static ListNode removeDuplicate(ListNode head) {
		Set<Integer> s = new HashSet<>();
		ListNode previous = null;
		ListNode temp = head;

		while (head != null) {
			if (s.contains(head.data)) {
				previous.next = head.next;
			} else {
				s.add(head.data);
				previous = head;

			}
			head = head.next;
		}
		return temp;
	}

	public static ListNode removeDuplicate1(ListNode head) {
		ListNode previous = null;
		ListNode temp = head;

		while (head != null) {
			ListNode runner = head;
			while (runner.next != null) {
				if (runner.next.data == head.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;

				}
			}
			head = head.next;
		}
		return temp;
	}

	public static void main(String[] args) {
		List<Integer> l = new LinkedList<>();
		l.add(23);
		l.add(22);
		l.add(23);
		l.add(23);
		l.add(24);

		List<Integer> l1 = new LinkedList<>();
		l1.add(23);
		l1.add(22);
		l1.add(23);
		l1.add(23);
		l1.add(24);
		l1.remove(new Integer(23));
		List<Integer> l2 = new CopyOnWriteArrayList<>(l);
		List<Integer> l3 = new CopyOnWriteArrayList<>(l1);

		// System.out.println(removeDup(l));
		// System.out.println(removeDup1(l1));
		System.out.println(l1);
		System.out.println(removeDup(l2));
		System.out.println(removeDup1(l3));
		ListNode s = new ListNode(23);
		ListNode s11 = new ListNode(24);
		ListNode s3 = new ListNode(23);

		s.next = s11;
		s11.next = s3;
		s3.next = new ListNode(25);

		// ListNode s1= removeDuplicate(s);
		ListNode s1 = removeDuplicate1(s);

		while (s1 != null) {
			System.out.print(s1.data + " ");
			s1 = s1.next;
		}

	}
}
