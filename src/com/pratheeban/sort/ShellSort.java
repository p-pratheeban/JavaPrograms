package com.pratheeban.sort;

import java.util.Arrays;

public class ShellSort {
	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void insertionSort(int[] arr, int startIndex, int increment) {
		for (int i = startIndex; i < arr.length; i = i + increment) {
			for (int j = Math.min(i + increment, arr.length - 1); j - increment >= 0; j = j - increment) {
				if (arr[j] < arr[j - increment]) {
					swap(arr, j, j - increment);
				} else {
					break;
				}
			}
		}
	}

	public static void shellSort(int[] arr) {
		int increment = arr.length / 2;
		while (increment >= 1) {
			for (int startIndex = 0; startIndex < increment; startIndex++) {
				insertionSort(arr, startIndex, increment);
			}

			increment = increment / 2;
		}
	}
	public static void main(String[] args) {
		int arr[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
