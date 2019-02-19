package com.pratheeban.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {
	public static Integer[] commonElements(int[] array1, int[] array2) {
		int p1 = 0;
		int p2 = 0;
		List<Integer> result = new ArrayList<>();
		while (p1 < array1.length && p2 < array2.length) {
			if (array1[p1] == array2[p2]) {
				result.add(array1[p1]);
				p1 += 1;
				p2 += 1;
			} else if (array1[p1] > array2[p2]) {
				p2 += 1;
			} else {
				p1 += 1;
			}
		}
		// Convert the result to a regular array.
		Integer[] resultInArray = new Integer[result.size()];
		return result.toArray(resultInArray);
	}
	
	public static Integer[] commonElements1(Integer[] array1, Integer[] array2) {
		Set<Integer> set1 = new HashSet<>();
		Collections.addAll(set1, array1);
		Set<Integer> set2 = new HashSet<>();
		Collections.addAll(set2, array2);
		set1.retainAll(set2);
	
		// Convert the result to a regular array.
		Integer[] resultInArray = new Integer[set1.size()];
		return set1.toArray(resultInArray);
	}
	public static void main(String[] args) {
		int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        System.out.println(Arrays.toString(commonElements(array1A, array2A)));
        
        Integer[] array1 = {1, 3, 4, 6, 7, 9};
        Integer[] array2 = {1, 2, 4, 5, 9, 10};
        System.out.println(Arrays.toString(commonElements1(array1, array2)));

	}
}
