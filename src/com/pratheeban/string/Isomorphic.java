package com.pratheeban.string;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
	public static Character getKey(Map<Character, Character> map, Character c) {
		for (Map.Entry<Character, Character> entry : map.entrySet()) {
			if (entry.getValue().equals(c)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.length() != t.length())
			return false;
		if (s.length() == 0 && t.length() == 0)
			return true;
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character c1 = s.charAt(i);
			Character c2 = t.charAt(i);
			Character c = getKey(map, c2);
			if (c != null && c1 != c) {
				return false;
			} else if (map.containsKey(c1)) {
				if (c2 != map.get(c1)) {
					return false;
				}
			} else {
				map.put(c1, c2);
			}
		}
		System.out.println(map);
		return true;
	}
	public static void main(String[] args) {
		 System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("egg", "adt"));

	}
}
