package com.pratheeban.sort;

import java.util.Arrays;

/*
 * Given an array of integers, rearrange the array into a wave-like array (a1 >= a2 <= a3 >= a4
<= a5 >= …).
 */
public class WaveSort {
	
	public static void waveSort(int[] arr) {
		if (arr == null) {
			return;
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i += 2) {
			swap(arr, i, i + 1);
		}
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void sortValleyPeak(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			int biggestIndex = maxIndex(array, i - 1, i, i + 1);
			if (i != biggestIndex) {
				swap(array, i, biggestIndex);
			}
		}
	}

	public static int maxIndex(int[] array, int a, int b, int c) {
		int len = array.length;
		int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
		int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
		int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

		int max = Math.max(aValue, Math.max(bValue, cValue));

		if (aValue == max) {
			return a;
		} else if (bValue == max) {
			return b;
		} else {
			return c;
		}

	}

	public static void sortValleyPeak1(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			if (array[i - 1] < array[i]) {
				swap(array, i - 1, i);
			}
			if (i + 1 < array.length && array[i + 1] < array[i]) {
				swap(array, i + 1, i);
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 4, 5, 6, 7 };
		waveSort(arr);
		System.out.println(Arrays.toString(arr));
		int[] array = { 5, 3, 1, 2, 3 };
		sortValleyPeak(array);
		System.out.println(Arrays.toString(array));

	}
}
