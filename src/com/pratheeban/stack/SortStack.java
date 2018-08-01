package com.pratheeban.stack;

import java.util.Stack;

public class SortStack {

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> s1 = new Stack<>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			while (!s1.isEmpty() && s1.peek() > temp) {
				s.push(s1.pop());
			}
			s1.push(temp);
		}
		return s1;
	}
	
	public static Stack<Integer> mergesort(Stack<Integer> inStack) {
		if (inStack.size() <= 1) {
			return inStack;
		}

		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		int count = 0;
		while (inStack.size() != 0) {
			count++;
			if (count % 2 == 0) {
				left.push(inStack.pop());
			} else {
				right.push(inStack.pop());
			}
		}

		left = mergesort(left);
		right = mergesort(right);

		while (left.size() > 0 || right.size() > 0) {
			if (left.size() == 0) {
				inStack.push(right.pop());
			} else if (right.size() == 0) {
				inStack.push(left.pop());
			} else if (right.peek().compareTo(left.peek()) <= 0) {
				inStack.push(left.pop());
			} else {
				inStack.push(right.pop());
			}
		}

		Stack<Integer> reverseStack = new Stack<Integer>();
		while (inStack.size() > 0) {
			reverseStack.push(inStack.pop());
		}

		return reverseStack;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.add(23);
		s.add(14);
		s.add(34);
		s.add(21);
		s.add(45);
		System.out.println(s);
		System.out.println(sort(s));
		
		Stack<Integer> s1 = new Stack<>();
		s1.add(23);
		s1.add(14);
		s1.add(56);
		s1.add(21);
		s1.add(45);
		System.out.println(s1);
		System.out.println(mergesort(s1));


	}

}
