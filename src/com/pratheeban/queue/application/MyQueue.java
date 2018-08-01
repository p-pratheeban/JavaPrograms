package com.pratheeban.queue.application;

import java.util.*;

class MyQueue<E> {
	// Two stacks that simulate a Queue:
	Stack<E> stack1;
	Stack<E> stack2;

	public MyQueue() {
		this.stack1 = new Stack<E>();
		this.stack2 = new Stack<E>();
	}

	public void push(E x) {
		stack1.push(x);
	}

	public void pop() {

		shiftStacks();
		stack2.pop();
	}

	public E peek() {

		shiftStacks();
		return stack2.peek();
	}

	private void shiftStacks() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scanner = new Scanner(System.in);
		int q = scanner.nextInt();

		// Process each query:
		for (int i = 0; i < q; i++) {
			int queryType = scanner.nextInt();

			if (queryType == 1) {
				int x = scanner.nextInt();
				queue.push(x);
			}

			else if (queryType == 2) {
				queue.pop();
			}

			else { // queryType == 3, print first value
				System.out.println(queue.peek());
			}
		}

		scanner.close();
	}
}
