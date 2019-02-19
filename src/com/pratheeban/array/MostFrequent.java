package com.pratheeban.array;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent {

	public static int mostFrquent(int[] arr) {
		Map<Integer, Integer> count = new HashMap<>();
		int maxCount = 0;
		int maxItem = 0;

		for (int a : arr) {
			count.merge(a, 1, Integer::sum);
			if (count.get(a) > maxCount) {
				maxCount = count.get(a);
				maxItem = a;
			}
		}
		return maxItem;
	}
	public static void main(String[] args) {
        int[] array1 = {1, 3, 1, 3, 2, 1};
        System.out.println(mostFrquent(array1));
	}

}
