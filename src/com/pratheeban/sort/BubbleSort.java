package com.pratheeban.sort;

import java.util.Arrays;

public class BubbleSort {

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void bubbleSort(int arr[]) {
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j + 1] < arr[j]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	private static void bubbleSort1(int arr[]) {
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j + 1] > arr[j]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	private static void bubbleSort2(int arr[]) {
		for (int i = arr.length - 1; i >= 0; i--) {
			boolean swap = false;
			for (int j = 0; j < i; j++) {
				if (arr[j + 1] < arr[j]) {
					swap = true;
					swap(arr, j, j + 1);
				}
			}
			if (!swap) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		int[] input = { 10, 8, 1, 88, 64, 21, 19, 4, 3, 2 };
		bubbleSort(input);
		System.out.println(Arrays.toString(input));
		bubbleSort1(input);
		System.out.println(Arrays.toString(input));
	}
}
