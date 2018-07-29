package com.pratheeban.string;

public class StringRotation {
	public static boolean isRotate(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		String s1s1= s1+s1;
		if(isSubstring(s1s1, s2)) {
			return true;
		}
		return false;
	}
	public static boolean isSubstring(String big, String small) {
		if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotate(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}
}
