package com.pratheeban.string.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringUnique {
	// O(n)
	public static boolean isUnique(String s) {
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Integer a = m.get(s.charAt(i));
			if (a != null && a > 0) {
				return false;
			}
			m.put(s.charAt(i), 1);
		}
		return true;
	}

	// O(n)
	public static boolean isUnique1(String s) {
		boolean[] ch = new boolean[128];
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if (ch[val]) {
				return false;
			}
			ch[val] = true;
		}
		return true;
	}

	public static boolean isUnique2(String s) {
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (i == j)
					continue;
				if (c[i] == c[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isUnique3(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		for (int i = 0; i < c.length-1; i++) {
			if (c[i] == c[++i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(StringUnique.isUnique("4455"));
		System.out.println(StringUnique.isUnique("123"));
		System.out.println(StringUnique.isUnique1("4455"));
		System.out.println(StringUnique.isUnique1("123"));
		System.out.println(StringUnique.isUnique2("4455"));
		System.out.println(StringUnique.isUnique2("123"));
		System.out.println(StringUnique.isUnique3("4455"));
		System.out.println(StringUnique.isUnique3("123"));

	}
}
