package com.pratheeban.stack.application;

import java.util.Stack;

public class EvaluateExpression {
	public static int evalRPN(String[] tokens) {
		int val = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<>();
		for (String s : tokens) {
			if (!operators.contains(s)) {
				stack.push(s);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch (s) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				}
			}
		}
		val = Integer.parseInt(stack.peek());
		return val;
	}

	public static void main(String[] args) {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(tokens));
	}
}
