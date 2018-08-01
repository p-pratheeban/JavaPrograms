package com.pratheeban.stack;

/**
 * Node class used by linked structures.
 */
class ChainNode {
	Object element;
	ChainNode next;

	ChainNode() {
	}

	ChainNode(Object element) {
		this.element = element;
	}

	ChainNode(Object element, ChainNode next) {
		this.element = element;
		this.next = next;
	}
}
