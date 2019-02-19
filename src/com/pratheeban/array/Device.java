package com.pratheeban.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Device {
	static class Pair {
		int foregroudId;
		int backgroudId;

		public Pair(int foregroudId, int backgroudId) {
			super();
			this.foregroudId = foregroudId;
			this.backgroudId = backgroudId;
		}

		@Override
		public String toString() {
			return "Pair [foregroudId=" + foregroudId + ", backgroudId=" + backgroudId + "]";
		}

	}

	public static List<Pair> findAppPairs(List<Integer> foreground, List<Integer> background, int k) {
		List<Pair> pairs = new ArrayList<>();
		Collections.sort(foreground);
		Collections.sort(background);
		System.out.println(foreground);
		System.out.println(background);
		int f = 0;
		int b = 0;
		Pair maxPair = null;
		for (int i = 0; i < foreground.size(); i++) {
			f = foreground.get(i);
			b = Collections.binarySearch(background, k - f);
			if (b >= 0) {
				pairs.add(new Pair(f, k - f));
			}

		}
		return pairs;

	}

	public static List<Pair> findAppPairs1(List<Integer> foreground, List<Integer> background, int k) {
		List<Pair> pairs = new ArrayList<>();
		Collections.sort(foreground);
		Collections.sort(background);
		System.out.println(foreground);
		System.out.println(background);
		int len = foreground.size();
		int i = len - 1;
		int j = len - 1;
		int sum =0;
		while (sum >k) {
			sum = foreground.get(i) + background.get(j);
			if (sum < k) {
				i++;
			} else if (sum > k) {
				j--;
			} else {
				pairs.add(new Pair(foreground.get(i), background.get(j)));
				i--;
				j--;

			}

		}
		System.out.println(i+""+j);
		if (pairs.isEmpty()) {
			pairs.add(new Pair(foreground.get(i), background.get(j)));

		}
		return pairs;

	}

	public static void main(String[] args) {
		List<Integer> foreground = Arrays.asList(2, 1, 5, 3, 6);
		List<Integer> background = Arrays.asList(2, 1, 3, 3, 2);
		System.out.println(findAppPairs(foreground, background, 9));
		System.out.println(findAppPairs1(foreground, background, 8));

	}
}
