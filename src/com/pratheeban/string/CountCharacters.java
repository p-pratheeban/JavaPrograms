package com.pratheeban.string;

import java.util.*;

/**
 * Java program to count the number of occurrence of any character on String.
 * 
 * @author Pratheepan
 *
 */
public class CountCharacters {

	public static int countOccurrencesOf(String input, char c) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	public static int countOccurrences(String input, char c) {
		int count = 0;
		for (char ch : input.toCharArray()) {
			if (ch == c) {
				count++;
			}
		}
		return count;
	}

	public static Map<Character, Integer> countOccurrences(String input) {
		Map<Character, Integer> countChars = new LinkedHashMap<>();
		for (char ch : input.toCharArray()) {
			countChars.put(ch, countChars.containsKey(ch) ? countChars.get(ch) + 1 : 1);
		}
		return countChars;
	}

	public static int countOccurrence(String input, char c) {
		int len = input.length();
		if ((len == 0) || (c == '\0')) // obvious case for empty string or nil
										// char.
			return 0; // Your recursion always ends here

		String rest = input.substring(1);
		if (input.charAt(0) == c) {
			return countOccurrence(rest, c) + 1; // recurse on substring
		} else {
			return countOccurrence(rest, c); // recurse on substring
		}
	}

	public static void main(String[] args) {
		String input = "count of character 'a' on String: 'Today is Monday' using for loop  ";
		System.out.println(countOccurrencesOf(input, 'a'));
		System.out.println(countOccurrences(input, 'a'));
		System.out.println(countOccurrences(input));
		System.out.println(countOccurrence(input,'a'));

	}
}
