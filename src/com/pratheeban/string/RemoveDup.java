package com.pratheeban.string;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDup {

	public static String removeDup(String str) {
		String str1 = "";
		Set<Character> s = new LinkedHashSet<>();
		for (char c : str.toCharArray()) {
			s.add(c);
		}
		for (Character ch : s) {
			str1 += ch;
		}
		return str1;
	}

	public static String removeDuplicate(String str) {
		String str1 = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!str1.contains(ch + "")) {
				str1 += ch;
			}
		}
		return str1;
	}

	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;

			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}

			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		for (int i = 0; i < tail; i++) {
			System.out.print(str[i]);
		}
	}

	public static void removeDuplicatesEff(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
		for (int i = 0; i < tail; i++) {
			System.out.print(str[i]);
		}
	}

	public static void main(String[] args) {
		String str = "HelloWorld";
		System.out.println(removeDup(str));
		System.out.println(removeDuplicate(str));
		removeDuplicates(str.toCharArray());
		System.out.println();
		removeDuplicatesEff(str.toCharArray());
	}
}
