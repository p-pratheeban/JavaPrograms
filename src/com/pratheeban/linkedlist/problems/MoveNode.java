package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.LinkedList;
import com.pratheeban.linkedlist.ListNode;

public class MoveNode {
	
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
	
	public static void moveNode(ListNode source, ListNode dest) {
		ListNode moveToNode = source;
		source = source.next;
		moveToNode.next =dest;
		
		System.out.println(printList(source));
		System.out.println(printList(moveToNode));
	}
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		ListNode head1 = new ListNode(15);
		list1.inserAtLast(head1);
		list1.inserAtLast(new ListNode(16));
		list1.inserAtLast(new ListNode(17));
		list1.inserAtLast(new ListNode(16));
		list1.inserAtLast(new ListNode(12));
		

		LinkedList list2 = new LinkedList();
		ListNode head2 = new ListNode(115);
		list2.inserAtLast(head2);
		list2.inserAtLast(new ListNode(116));
		list2.inserAtLast(new ListNode(117));
		list2.inserAtLast(new ListNode(116));
		list2.inserAtLast(new ListNode(112));
		moveNode(head1, head2);
	}
}
