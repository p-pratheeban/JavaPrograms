package com.pratheeban.string;

public class Haystack {

	public static int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}

	public static int strStr1(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public static int strStr2(String haystack, String needle, int nthoccur) {
		int numberOfOccurences = 0;
		int len1 = needle.length();
		int index = haystack.indexOf(needle);
		int index1 = -len1;
		int i = 0;
		while (haystack.length()>len1) {
			if (numberOfOccurences == nthoccur) {
				break;
			}
			if (index != -1) {
				numberOfOccurences++;
				index1+=len1;
				haystack = haystack.substring(len1);
			}
			
			index = haystack.indexOf(needle);
			i++;
		}
		return index1;
	}

	//O(nm) runtime, O(1) space – Brute force
	public static int strStr3(String haystack, String needle, int nthoccur) {
		int count=0;
		for (int i = 0;; i++) {
			for (int j = 0;j<needle.length(); j++) {
				if (j == needle.length()-1) {
					count++;
				}
				if(count==nthoccur) {
					return i;
				}
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}

	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issi";
		System.out.println(strStr(haystack, needle));
		System.out.println(strStr1(haystack, needle));
		System.out.println(strStr2(haystack, needle, 2));
		System.out.println(strStr3(haystack, needle, 2));

	}
}
