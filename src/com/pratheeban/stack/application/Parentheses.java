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
	
	public static void main(String[] args) {
		System.out.println(isValid("(()){{[]}}"));
		System.out.println(isValid("(()){{[}}"));

	}
}
