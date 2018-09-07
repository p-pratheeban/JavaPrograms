package com.pratheeban.divideandconquire;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int left, int right) {
		if (left >= right)
			return;
		int pivot = array[(left + right) / 2];// Pick a pivot point. Can be an element
		int index = partion(array, left, right, pivot);
		quickSort(array, left, index - 1);// Sort left half
		quickSort(array, index, right);// Sort right half
	}

	private static int partion(int[] array, int left, int right, int pivot) {
		while (left <= right) { // Until we've gone through the whole array
			// Find element on left that should be on right
			while (array[left] < pivot) {
				left++;
			}
			// Find element on right that should be on left
			while (array[right] > pivot) {
				right--;
			}
			// Swap elements, and move left and right indices
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;

	}

	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 34, 23, 45, 13, 56, 7, 34, 67, 44 };
		System.out.println(Arrays.toString(array));
		quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
