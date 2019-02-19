package com.pratheeban.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

	public static boolean isAnagram1(String s, String t) {
		if (s.length() != t.length())
			return false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			if (map.containsKey(c1)) {
				map.put(c1, map.get(c1) + 1);
			} else {
				map.put(c1, 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			char c2 = t.charAt(i);
			if (map.containsKey(c2)) {
				if (map.get(c2) == 1) {
					map.remove(c2);
				} else {
					map.put(c2, map.get(c2) - 1);
				}
			} else {
				return false;
			}
		}
		if (map.size() > 0)
			return false;
		return true;
	}
	
	 static boolean isAnagram2(String a, String b) {
	        if (a == null || b == null || a.length() != b.length()) {
	            return false;
	        }
	        a = a.toLowerCase();
	        b = b.toLowerCase();
	        Map<Character, Integer> map = new HashMap<>();
	        
	        /* Fill HashMap with 1st String */
	        for (int i = 0; i < a.length(); i++) {
	            char ch = a.charAt(i);
	            map.merge(ch, 1, Integer::sum);
	        }
	        
	        /* Compare 2nd String to 1st String's HashMap */
	        for (int i = 0; i < b.length(); i++) {
	            char ch = b.charAt(i);
	            if (map.containsKey(ch) && map.get(ch) > 0) {
	                map.put(ch, map.get(ch) - 1);
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }

	public static void bucketAnagram(List<String> input) {
		Map<String, List<String>> hm = new HashMap<>();
		for (String word : input) {
			char[] wordArr = word.toCharArray();
			Arrays.sort(wordArr);
			String key = new String(wordArr);
			List<String> list;
			if (!hm.containsKey(key)) {
				list = new LinkedList<String>();
			} else {
				list = hm.get(key);
			}
			list.add(word);
			hm.put(key, list);
		}
		for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
			for (String word : entry.getValue()) {
				System.out.print(word + " ");
			}
			System.out.println();
		}
	}

	public static void sort(String[] array) {
		Map<String, List<String>> mapList = new HashMap<>();

		/* Group words by anagram */
		for (String s : array) {
			String key = sortChars(s);
			List<String> list;
			if (!mapList.containsKey(key)) {
				list = new ArrayList<String>();
			} else {
				list = mapList.get(key);
			}
			list.add(s);
			mapList.put(key, list);
		}

		/* Convert hash table to array */
		int index = 0;
		for (String key : mapList.keySet()) {
			List<String> list = mapList.get(key);
			for (String t : list) {
				array[index] = t;
				index++;
			}
		}
	}

	public static String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	private static int numberNeeded(String first, String second) {
		/* For each string, create an array of the count of each character */
		int[] array1 = createFilledArray(first);
		int[] array2 = createFilledArray(second);

		/*
		 * Count number of deletions we need to make the Strings anagrams of each other
		 */
		int deletions = 0;
		for (int i = 0; i < 26; i++) {
			deletions += Math.abs(array1[i] - array2[i]);
		}
		return deletions;
	}

	/* Creates an array with the count of each character */
	private static int[] createFilledArray(String str) {
		int[] array = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			array[ch - 'a']++;
		}
		return array;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("word", "wrdo"));
		System.out.println(isAnagrams("word", "wrdo"));
		System.out.println(checkAnagram("word", "wrdo"));
		System.out.println(anagram("word", "wrdo"));
		System.out.println(anagram("worod", "wrodo"));
		System.out.println(areAnagram("worod".toCharArray(), "wrodo".toCharArray()));
		System.out.println(isAnagram("worod".toCharArray(), "wrodo".toCharArray()));
		System.out.println(isAnagram1("word", "wrdo"));
		bucketAnagram(Arrays.asList("abc", "hello", "cba"));

		String[] array = { "apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee" };
		sort(array);
		System.out.println(Arrays.toString(array));
		Arrays.sort(array, new AnagramComparator());
		System.out.println(Arrays.toString(array));
	}
}

class AnagramComparator implements Comparator<String> {
	private String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
}