package com.pratheeban.recursive;

import java.util.ArrayList;
import java.util.HashMap;

public class Permutation {
	public static ArrayList<String> getPerms(String str) {
		if (str == null) {
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
	            
		char first = str.charAt(0); // get the first character
		String remainder = str.substring(1); // remove the first character
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	public static ArrayList<String> getPerms1(String str) {
		int len = str.length();
		ArrayList<String> result = new ArrayList<String>();
		
		/* Base case. */
		if (len == 0) {
			result.add(""); // Be sure to return empty string!
			return result;
		}
		
		
		for (int i = 0; i < len; i++) {
			/* Remove char i and find permutations of remaining characters.*/
			String before = str.substring(0, i);
			String after = str.substring(i + 1, len);
			ArrayList<String> partials = getPerms1(before + after);
			
			/* Prepend char i to each permutation.*/
			for (String s : partials) {
				result.add(str.charAt(i) + s);
			}			
		}
		
		return result;
	}
	
	public static void getPerms(String prefix, String remainder, ArrayList<String> result) {
		if (remainder.length() == 0) {
			result.add(prefix);
		}
		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			getPerms(prefix + c, before + after, result);
		}
	}
	
	public static ArrayList<String> getPerms2(String str) {
		ArrayList<String> result = new ArrayList<String>();
		getPerms("", str, result);
		return result;
	}
	
	
	//with duplicates
	public static HashMap<Character, Integer> buildFreqTable(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
	}
	
	public static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
		if (remaining == 0) {
			result.add(prefix);
			return;
		}
		
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (count > 0) {
				map.put(c,  count - 1);
				printPerms(map, prefix + c, remaining - 1, result);
				map.put(c,  count);
			}
		}
	}
	
	public static ArrayList<String> printPerms(String s) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = buildFreqTable(s);
		printPerms(map, "", s.length(), result);
		return result;
	}
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
		
		ArrayList<String> list1 = getPerms1("def");
		System.out.println("There are " + list1.size() + " permutations.");
		for (String s : list1) {
			System.out.println(s);
		}
		
		ArrayList<String> list2= getPerms2("ghi");
		System.out.println("There are " + list2.size() + " permutations.");
		for (String s : list2) {
			System.out.println(s);
		}
		
		String s = "aabbccc";
		ArrayList<String> result = printPerms(s);
		System.out.println("Count: " + result.size());
		for (String r : result) {
			System.out.println(r);
		}
		
	}
}
