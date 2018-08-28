package com.pratheeban.stack.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parentheses {
	private static final Map<Character, Character> map = new HashMap<Character, Character>() {
		{
			put('(', ')');
			put('{', '}');
			put('[', ']');
		}
	};

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || map.get(stack.pop()) != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	/*
	 * Check if a given string contains balanced parenthesis.
	 */
	public static boolean isBalanced(char[] str) {
		int count = 0, i;
		for (i = 0; i < str.length; i++) {
			if (str[i] == '(') {
				count++;
			} else {
				count--;
				if (count < 0) {
					return false;
				}
			}
		}
		if (count != 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValid("(()){{[]}}"));
		System.out.println(isValid("(()){{[}}"));
		System.out.println(isBalanced("()(())".toCharArray()));

	}
}
