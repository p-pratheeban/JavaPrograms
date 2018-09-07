package com.pratheeban.sort;

import java.util.Arrays;

public class InsertionSort {
	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
				} else {
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
