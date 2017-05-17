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

	public static void main(String[] args) {
		System.out.println(isAnagram("word", "wrdo"));
		System.out.println(isAnagrams("word", "wrdo"));
		System.out.println(checkAnagram("word", "wrdo"));

	}
}
