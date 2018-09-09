package com.pratheeban.string;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
	public static int getFrequency(String[] book, String word) {
		word = word.trim().toLowerCase();
		int count = 0;
		for (String w : book) {
			if (w.trim().toLowerCase().equals(word)) {
				count++;
			}
		}
		return count;
	}

	public static Map<String, Integer> setupDictionary(String[] book) {
		Map<String, Integer> table = new HashMap<String, Integer>();
		for (String word : book) {
			word = word.toLowerCase();
			if (word.trim() != "") {
				if (!table.containsKey(word)) {
					table.put(word, 0);
				}
				table.put(word, table.get(word) + 1);
			}
		}
		return table;
	}

	public static int getFrequency(Map<String, Integer> table, String word) {
		if (table == null || word == null) {
			return -1;
		}
		word = word.toLowerCase();
		if (table.containsKey(word)) {
			return table.get(word);
		}
		return 0;
	}

	public static boolean canBuildRandomNote(String[] magazine, String[] note) {
		Map<String, Integer> magaFreq = new HashMap<>();
		Map<String, Integer> noteFreq = new HashMap<>();
		for (String m : magazine) {
			magaFreq.merge(m, 1, Integer::sum);
		}
		for (String n : note) {
			noteFreq.merge(n, 1, Integer::sum);
		}
		for (Map.Entry<String, Integer> entry : noteFreq.entrySet()) {
			String word = entry.getKey();
			if (!magaFreq.containsKey(word) || magaFreq.get(word) < entry.getValue()) {
				return false;
			}

		}
		return true;

	}

	public static void main(String[] args) {
		String[] book = { "the", "Lara", "and", "outcropping", "career", "it", "the", "and", "is" };
		System.out.println(getFrequency(book, "and"));
		System.out.println(getFrequency(setupDictionary(book), "the"));

		String magazine[] = { "give", "me", "one", "grand", "today", "night" };
		String note[] = {"give", "one", "grand", "today"};
		System.out.println(canBuildRandomNote(magazine, note));

	}
}
