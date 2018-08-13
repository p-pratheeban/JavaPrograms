package com.pratheeban.stack.application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateExpression {
	
	private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

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


	public static int evalRPN1(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS.contains(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(eval(x, y, token));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	private static int eval(int x, int y, String operator) {
		switch (operator) {
		case "+":
			return x + y;
		case "-":
			return x - y;
		case "*":
			return x * y;
		default:
			return x / y;
		}
	}

	public static void main(String[] args) {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(tokens));
		
		System.out.println(evalRPN1(tokens));

	}
}
