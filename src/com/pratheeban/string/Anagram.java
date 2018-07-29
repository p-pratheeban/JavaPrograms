package com.pratheeban.string.examples;

import java.util.Arrays;

/**
 * This program checks if two Strings are anagrams or not
 * 
 * @author Pratheepan
 *
 */
public class Anagram {
	public static boolean isAnagram(String word, String anagram) {
		if (word == null || anagram == null || word.length() != anagram.length()) {
			return false;
		}
		anagram = anagram.toLowerCase();
		char[] chars = word.toLowerCase().toCharArray();

		for (char c : chars) {
			int index = anagram.indexOf(c);
			if (index != -1) {
				anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
			} else {
				return false;
			}
		}
		return anagram.isEmpty();
	}

	public static boolean isAnagrams(String word, String anagram) {

		if (word == null || anagram == null || word.length() != anagram.length()) {
			return false;
		}

		char[] charFromWord = word.toLowerCase().toCharArray();
		char[] charFromAnagram = anagram.toLowerCase().toCharArray();
		Arrays.sort(charFromWord);
		Arrays.sort(charFromAnagram);
		return Arrays.equals(charFromWord, charFromAnagram);
	}

	public static boolean checkAnagram(String word, String anagram) {
		if (word == null || anagram == null || word.length() != anagram.length()) {
			return false;
		}

		char[] characters = word.toCharArray();
		StringBuilder sbAnagram = new StringBuilder(anagram);

		for (char ch : characters) {
			int index = sbAnagram.indexOf("" + ch);
			if (index != -1) {
				sbAnagram.deleteCharAt(index);
			} else {
				return false;
			}
		}
		return sbAnagram.length() == 0 ? true : false;
	}

	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it’s a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}

	public static boolean areAnagram(char str1[], char str2[]) {
		int NO_OF_CHARS = 256;
		// Create 2 count arrays and initialize
		// all values as 0
		int count1[] = new int[NO_OF_CHARS];
		Arrays.fill(count1, 0);
		int count2[] = new int[NO_OF_CHARS];
		Arrays.fill(count2, 0);
		int i;

		// For each character in input strings,
		// increment count in the corresponding
		// count array
		for (i = 0; i < str1.length && i < str2.length; i++) {
			count1[str1[i]]++;
			count2[str2[i]]++;
		}

		// If both strings are of different length.
		// Removing this condition will make the program
		// fail for strings like "aaca" and "aca"
		if (str1.length != str2.length)
			return false;

		// Compare count arrays
		for (i = 0; i < NO_OF_CHARS; i++)
			if (count1[i] != count2[i])
				return false;

		return true;
	}
	
	public static boolean isAnagram(char str1[], char str2[]) {
		int NO_OF_CHARS = 256;
		// Create 2 count arrays and initialize
		// all values as 0
		int count1[] = new int[NO_OF_CHARS];
		Arrays.fill(count1, 0);
		int i;

		// For each character in input strings,
		// increment count in the corresponding
		// count array
		for (i = 0; i < str1.length && i < str2.length; i++) {
			count1[str1[i]]++;
			count1[str2[i]]--;
		}

		// If both strings are of different length.
		// Removing this condition will make the program
		// fail for strings like "aaca" and "aca"
		if (str1.length != str2.length)
			return false;

		// Compare count arrays
		for (i = 0; i < NO_OF_CHARS; i++)
			if (count1[i] != 0)
				return false;

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("word", "wrdo"));
		System.out.println(isAnagrams("word", "wrdo"));
		System.out.println(checkAnagram("word", "wrdo"));
		System.out.println(anagram("word", "wrdo"));
		System.out.println(anagram("worod", "wrodo"));
		System.out.println(areAnagram("worod".toCharArray(), "wrodo".toCharArray()));
		System.out.println(isAnagram("worod".toCharArray(), "wrodo".toCharArray()));

	}
}
