package com.pratheeban.string;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Pratheepan Check if a string is a palindrome or not
 */
public class Palindrome {
	/**
	 * Check whether the given input string is palindrome or not The time complexity
	 * of reverse() is O(n). So it would be done in o(n)
	 * 
	 * @param inputStr
	 * @return true if string is palindrome otherwise return false
	 */
	public boolean isPalindrome(String inputStr) {

		if (inputStr == null || inputStr == "") {
			return false;
		}
		String input = getOnlyString(inputStr.trim().toLowerCase());
		StringBuilder sb = new StringBuilder(input);
		StringBuilder reverse = sb.reverse();
		if (input.trim().toLowerCase().equals(String.valueOf(reverse))) {
			return true;
		}
		return false;
	}

	/**
	 * Display the result whether the given input string is palindrome or not
	 * 
	 * @param inputStr
	 */
	public void display(String inputStr) {
		if (isPalindrome(inputStr)) {
			System.out.println(inputStr + " is a palindrome");
		} else {
			System.out.println(inputStr + " is not a palindrome");
		}
	}

	/**
	 * Remove special characters and space from string
	 * 
	 * @param str
	 * @return a string without having special characters or space
	 */
	public String getOnlyString(String str) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(str);
		return matcher.replaceAll("");
	}

	public boolean isPalindrome1(String s) {
		if (s == null)
			return false;
		if (s.length() < 2)
			return true;
		char[] charArray = s.toCharArray();
		int len = s.length();
		int i = 0;
		int j = len - 1;

		while (i < j) {
			char left = charArray[i], right = charArray[j];
			while (i < len - 1 && !isAlpha(left) && !isNum(left)) {
				i++;
			}
			while (j > 0 && !isAlpha(right) && !isNum(right)) {
				j--;
			}
			if (i >= j)
				break;
			if (!isSame(left, right)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public boolean isAlpha(char a) {
		if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNum(char a) {
		if (a >= '0' && a <= '9') {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSame(char a, char b) {
		if (isNum(a) && isNum(b)) {
			return a == b;
		} else if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
			return true;
		} else {
			return false;
		}
	}

	public void display1(String inputStr) {
		if (isPalindrome1(inputStr)) {
			System.out.println(inputStr + " is a palindrome");
		} else {
			System.out.println(inputStr + " is not a palindrome");
		}
	}

	public boolean isPalindrome2(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int len = s.length();
		if (len < 2)
			return true;
		Stack<Character> stack = new Stack<>();
		int index = 0;
		while (index < len / 2) {
			stack.push(s.charAt(index));
			index++;
		}
		if (len % 2 == 1)
			index++;
		while (index < len) {
			if (stack.empty())
				return false;
			char temp = stack.pop();
			if (s.charAt(index) != temp)
				return false;
			else
				index++;
		}
		return true;
	}

	public void display2(String inputStr) {
		if (isPalindrome2(inputStr)) {
			System.out.println(inputStr + " is a palindrome");
		} else {
			System.out.println(inputStr + " is not a palindrome");
		}
	}

	public boolean isPalindrome3(String s) {
		if (s == null || s.length() == 0)
			return false;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public void display3(String inputStr) {
		if (isPalindrome3(inputStr)) {
			System.out.println(inputStr + " is a palindrome");
		} else {
			System.out.println(inputStr + " is not a palindrome");
		}
	}

	public boolean isPalindrome4(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
				i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
				j--;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	public void display4(String inputStr) {
		if (isPalindrome4(inputStr)) {
			System.out.println(inputStr + " is a palindrome");
		} else {
			System.out.println(inputStr + " is not a palindrome");
		}
	}

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		palindrome.display("1221");
		palindrome.display("1121");
		palindrome.display("Noel saw I was Leon.");
		palindrome.display("Live on evasions? No, I save no evil.");
		System.out.println(palindrome.getOnlyString("<H1>Hello World</H1>"));
		palindrome.display1("Live on evasions? No, I save no evil.");
		palindrome.display2("Live on evasions? No, I save no evil.");
		palindrome.display3("Live on evasions? No, I save no evil.");
		palindrome.display4("Live on evasions? No, I save no evil.");


	}
}
