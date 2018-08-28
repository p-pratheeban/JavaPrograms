package com.pratheeban.divideandconquire;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] array) {
		mergeSort(array, new int[array.length], 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd)
			return;
		int middle = (leftStart + rightEnd) / 2;

		mergeSort(array, temp, leftStart, middle);
		mergeSort(array, temp, middle + 1, rightEnd);
		mergeHalves(array, temp, middle, leftStart, rightEnd);
	}

	private static void mergeHalves(int[] array, int[] temp, int middle, int leftStart, int rightEnd) {
		int leftEnd = middle;
		int rightStart = middle + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		// This is for temp array
		int index = leftStart;
		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		/*
		 * Copy the remaining elements of array if there are any either one of them will
		 * execute
		 */
		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		// Copy the elements from temp array into original array
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}

	public static void main(String[] args) {
		// int[] array = { 34, 23, 45, 13, 56, 7, 34, 67, 44 };
		int[] array = { 34, 23, 45, 13 };
		System.out.println(Arrays.toString(array));
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
}
