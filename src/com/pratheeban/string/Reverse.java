package com.pratheeban.string;

public class Reverse {

	// O(n) runtime, O(n) space
	public static String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}

	// O(n) runtime, O(1) space – In-place reverse
	public static String reverseWords(char[] s) {
		reverse(s, 0, s.length);
		for (int i = 0, j = 0; j <= s.length; j++) {
			if (j == s.length || s[j] == ' ') {
				reverse(s, i, j);
				i = j + 1;
			}
		}

		return String.valueOf(s);
	}

	private static void reverse(char[] s, int begin, int end) {
		for (int i = 0; i < (end - begin) / 2; i++) {
			char temp = s[begin + i];
			s[begin + i] = s[end - i - 1];
			s[end - i - 1] = temp;
		}
	}

	public static String reverseString(String str) {
		String reverse = "";
		for (int i = 0; i < str.length(); i++) {
			reverse = str.charAt(i) + reverse;
		}
		return reverse;
	}

	public static String reverseString1(String input) {
		String reverseStr = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reverseStr += input.charAt(i);
		}
		return reverseStr;
	}

	public static String reverseString2(String input) {
		if (input == null || input == "") {
			return input;
		}
		String reverseStr = new StringBuffer(input).reverse().toString();
		return reverseStr;
	}

	public static String reverseString3(String input) {
		if (input.length() == 1 || input == null || input == "") {
			return input;
		}
		return reverseString(input.substring(1)) + input.charAt(0);
	}

	public static void main(String[] args) {
		String str = "the sky is blue";
		System.out.println(reverseWords(str));
		System.out.println(reverseWords(str.toCharArray()));
		//System.out.println(reverseString(str));
		System.out.println(reverseString3(str));
	}
}
