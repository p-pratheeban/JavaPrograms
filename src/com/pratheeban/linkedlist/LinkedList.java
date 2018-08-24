package com.pratheeban.linkedlist;

public class LinkedList {

	private int length;
	private ListNode head;

	public LinkedList() {
		length = 0;
	}

	public ListNode getHead() {
		return head;
	}

	public void inserAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	public void inserAtLast(ListNode node) {
		if (head == null) {
			head = node;
		} else {
			ListNode current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
		}
		length++;
	}

	public void insert(int data, int position) {
		if (position < 0) {
			position = 1;
		}
		if (position > length) {
			position = length;
		}
		if (position == 0) {
			ListNode newNode = new ListNode(data);
			newNode.setNext(head);
			head = newNode;
		} else {
			ListNode previous = head;
			for (int i = 1; i < position; i++) {
				previous = previous.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
		}
		length++;
	}

	public ListNode removeBegin() {
		ListNode node = head;
		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		length--;
		return node;
	}

	public ListNode removeLast() {
		ListNode node = head;

		if (node == null) {
			return null;
		}
		if (node.getNext() == null) {
			head = null;
			length--;
			return node;
		}
		ListNode previous = null;
		while (node.getNext() != null) {
			previous = node;
			node = node.getNext();
		}
		previous.setNext(null);
		length--;
		return node;
	}

	public ListNode remove(int position) {
		ListNode node = head;
		if (position < 0) {
			position = 0;
		}
		if (position >= length) {
			position = length - 1;
		}
		if (head == null) {
			return null;
		}
		if (position == 0) {
			head = head.getNext();
			return head;
		}
		for (int i = 0; i < position; i++) {
			node = node.getNext();
		}
		ListNode temp = node;
		node.setNext(node.getNext().getNext());
		length--;
		return temp;
	}

	// Return the current length of the list.
	public int length() {
		return length;
	}

	public void removeMatched(ListNode element) {
		ListNode node = head;
		if (head == null) {
			return;
		}

		if (element.equals(node)) {
			head.setNext(node.getNext());
			return;
		}

		while (node != null) {
			if (element.equals(node.getNext())) {
				node.setNext(node.getNext().getNext());
				length--;
				return;
			}
			node = node.getNext();
		}
	}

	// Return a string representation of this collection, in the form
	public String toString() {
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

	public String printList(ListNode head) {
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
//[15,6,16,7,1,2]

	public boolean ifLoopExist() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr) {
				return true;
			} 
		}
		return false;
	}

	public ListNode nthFromLastNode(ListNode head, int n) {
		ListNode firstPtr = head;
		ListNode secondPtr = head;

		for (int i = 0; i < n; i++) {
			firstPtr = firstPtr.next;

		}

		while (firstPtr != null) {
			firstPtr = firstPtr.next;
			secondPtr = secondPtr.next;
		}

		return secondPtr;
	}

	// Find the position of the first value that is equal to a given value.
	public int getPosition(int data) {
		ListNode temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data) {
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		return Integer.MIN_VALUE;
	}

	// Size of the list.
	public boolean isEmpty() {
		return length == 0;
	}

	// Remove everything from the list.
	public void clearList() {
		head = null;
		length = 0;
	}
}
