package com.pratheeban.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sherlock {
	static String isValid(String input) {
		int[] counts = new int[26];
		for (int i = 0; i < input.length(); i++) {
			counts[input.charAt(i) - 'a']++;
		}
		System.out.println(Arrays.toString(counts));
		for (int i = 0; i < counts.length; i++) {
			int d = 0;
			if (counts[i] != 0) {
				counts[i] = counts[i] - 1;
			}
			Set<Integer> set = new HashSet<>();

			for (int j = 0; j < counts.length; j++) {
				if (counts[j] >0)
					set.add(counts[j]);

			}
			if (set.size() == 1) {
				return "YES";
			}
			counts[i] = counts[i] +1;

		}
		return "NO";

	}

	public static void main(String[] args) {
		System.out.println(isValid("aabbcd"));
	}

}
