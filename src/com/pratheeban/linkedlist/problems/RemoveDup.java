package com.pratheeban.linkedlist.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import com.pratheeban.linkedlist.LinkedList;
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

	public static ListNode deleteDups(ListNode head) {
		ListNode temp = head;

		ListNode previous = head;
		ListNode current = previous.next;
		while (current != null) {
			// Look backwards for dups, and remove any that you see.
			ListNode runner = head;
			while (runner != current) {
				if (runner.data == current.data) {
					ListNode tmp = current.next;
					previous.next = tmp;
					current = tmp;
					/*
					 * We know we can't have more than one dup preceding our element since it would
					 * have been removed earlier.
					 */
					break;
				}
				runner = runner.next;
			}

			/*
			 * If runner == current, then we didn't find any duplicate elements in the
			 * previous for loop. We then need to increment current. If runner != current,
			 * then we must have hit the break condition, in which case we found a dup and
			 * current has already been incremented.
			 */
			if (runner == current) {
				previous = current;
				current = current.next;
			}
		}
		return temp;
	}
	
	//remove duplicate from sorted array
	public static ListNode removeDuplicate2(ListNode head) {
		ListNode temp = head;
		ListNode prev = head;
		ListNode curr= head.next;
		while (curr != null) {
			if(prev.data==curr.data) {
				prev.next = curr.next;
				curr= curr.next;
				continue;
			}
			prev=curr;
			curr=curr.next;
		}
		return temp;
	}

	public static void main(String[] args) {
		/*
		 * List<Integer> l = new LinkedList<>(); l.add(23); l.add(22); l.add(23);
		 * l.add(23); l.add(24);
		 * 
		 * List<Integer> l1 = new LinkedList<>(); l1.add(23); l1.add(22); l1.add(23);
		 * l1.add(23); l1.add(24); l1.remove(new Integer(23)); List<Integer> l2 = new
		 * CopyOnWriteArrayList<>(l); List<Integer> l3 = new CopyOnWriteArrayList<>(l1);
		 */
		// System.out.println(removeDup(l));
		// System.out.println(removeDup1(l1));
		// System.out.println(l1);
		// System.out.println(removeDup(l2));
		// System.out.println(removeDup1(l3));
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(5);
		list.inserAtLast(head);
		list.inserAtLast(new ListNode(6));
		list.inserAtLast(new ListNode(7));
		list.inserAtLast(new ListNode(6));
		list.inserAtLast(new ListNode(2));
		System.out.println(list.printList(head));
		ListNode s2 = removeDuplicate(head);
		System.out.println(list.printList(s2));

		LinkedList list1 = new LinkedList();
		ListNode head1 = new ListNode(15);
		list1.inserAtLast(head1);
		list1.inserAtLast(new ListNode(16));
		list1.inserAtLast(new ListNode(17));
		list1.inserAtLast(new ListNode(16));
		list1.inserAtLast(new ListNode(12));
		System.out.println(list1.printList(head1));
		ListNode s4 = removeDuplicate1(head1);
		System.out.println(list1.printList(s4));

		LinkedList list2 = new LinkedList();
		ListNode head2 = new ListNode(115);
		list2.inserAtLast(head2);
		list2.inserAtLast(new ListNode(116));
		list2.inserAtLast(new ListNode(117));
		list2.inserAtLast(new ListNode(116));
		list2.inserAtLast(new ListNode(112));
		System.out.println(list2.printList(head2));
		ListNode s5 = deleteDups(head2);
		System.out.println(list2.printList(s5));
		
		LinkedList list3 = new LinkedList();
		ListNode head3 = new ListNode(1);
		list3.inserAtLast(head3);
		list3.inserAtLast(new ListNode(2));
		list3.inserAtLast(new ListNode(2));
		list3.inserAtLast(new ListNode(2));
		list3.inserAtLast(new ListNode(4));
		list3.inserAtLast(new ListNode(5));
		list3.inserAtLast(new ListNode(5));
		ListNode s6 = removeDuplicate2(head3);
		System.out.println(list3.printList(s6));

	}
}
