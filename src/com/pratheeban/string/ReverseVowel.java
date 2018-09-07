package com.pratheeban.string;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowel {
	public static boolean isVowel(char ch) {
		List<Character> vowList = new ArrayList<Character>();
		vowList.add('a');
		vowList.add('e');
		vowList.add('i');
		vowList.add('o');
		vowList.add('u');
		vowList.add('A');
		vowList.add('E');
		vowList.add('I');
		vowList.add('O');
		vowList.add('U');
		if (vowList.contains(ch)) {
			return true;
		}
		return false;
	}

	public static String reverseVowels(String s) {

		char[] arr = s.toCharArray();

		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			if (!isVowel(arr[i])) {
				i++;
				continue;
			}

			if (!isVowel(arr[j])) {
				j--;
				continue;
			}

			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;

			i++;
			j--;
		}

		return new String(arr);
	}

	public static void main(String[] args) {
		System.out.println(reverseVowels("apple"));
		System.out.println(reverseVowels("cdpaple"));

	}
}
