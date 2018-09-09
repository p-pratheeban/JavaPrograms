package com.pratheeban.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SubString {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
		boolean[] flag = new boolean[256];
		int result = 0;
		int start = 0;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char current = arr[i];
			if (flag[current]) {
				result = Math.max(result, i - start);
				// the loop update the new start point
				// and reset flag array
				// for example, abccab, when it comes to 2nd c,
				// it update start from 0 to 3, reset flag for a,b
				for (int k = start; k < i; k++) {
					if (arr[k] == current) {
						start = k + 1;
						break;
					}
					flag[arr[k]] = false;
				}
			} else {
				flag[current] = true;
			}
		}
		result = Math.max(arr.length - start, result);
		return result;
	}

	public static int lengthOfLongestSubstring1(String s) {
		if (s == null)
			return 0;
		char[] arr = s.toCharArray();
		int pre = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				pre = Math.max(pre, map.size());
				i = map.get(arr[i]);
				map.clear();
			}
		}
		return Math.max(pre, map.size());
	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			if (map.size() > 2) {
				max = Math.max(max, i - start);
				while (map.size() > 2) {
					char t = s.charAt(start);
					int count = map.get(t);
					if (count > 1) {
						map.put(t, count - 1);
					} else {
						map.remove(t);
					}
					start++;
				}
			}
		}
		max = Math.max(max, s.length() - start);
		return max;
	}

	// Given two strings, determine if they share a common substring.
	public static String twoStrings(String s1, String s2) {
		Set<Character> s = new HashSet<>();
		for (char c : s1.toCharArray()) {
			s.add(c);
		}
		for (char c : s2.toCharArray()) {
			if (s.contains(c)) {
				return "YES";
			}
		}
		return "NO";
	}

	public static String twoStrings1(String s1, String s2) {
		Set<Character> s11 = new HashSet<>();
		Set<Character> s22 = new HashSet<>();

		for (char c : s1.toCharArray()) {
			s11.add(c);
		}
		for (char c : s2.toCharArray()) {
			s22.add(c);
		}
		s11.retainAll(s22);
		System.out.println(s11);
		return s11.isEmpty()?"NO":"YES";
	}

	
	public static void main(String[] args) {
		String s = "abcbbdefg";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstring1(s));
		
		String s1="Hello";
		String s2="World";
		System.out.println(twoStrings(s1, s2));
		System.out.println(twoStrings1(s1, s2));

	}
}
