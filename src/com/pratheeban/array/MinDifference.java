package com.pratheeban.array;

import java.util.Arrays;

public class MinDifference {
	public static int findSmallestDifference(int[] array1, int[] array2) {
		if (array1.length == 0 || array2.length == 0) {
			return -1;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (Math.abs(array1[i] - array2[j]) < min) {
					min = Math.abs(array1[i] - array2[j]);
				}
			}
		}
		return min;
	}

	public static int findSmallestDifference1(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		int a = 0;
		int b = 0;
		int difference = Integer.MAX_VALUE;
		while (a < array1.length && b < array2.length) {
			if (Math.abs(array1[a] - array2[b]) < difference) {
				difference = Math.abs(array1[a] - array2[b]);
				if (difference == 0)
					return difference;
			}
			if (array1[a] < array2[b]) {
				a++;
			} else {
				b++;
			}
		}
		return difference;
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 3, 15, 11, 2 };
		int[] array2 = { 23, 127, 234, 19, 8 };
		int difference = findSmallestDifference(array1, array2);
		System.out.println(difference);
		int difference1 = findSmallestDifference1(array1, array2);
		System.out.println(difference1);

	}
}
