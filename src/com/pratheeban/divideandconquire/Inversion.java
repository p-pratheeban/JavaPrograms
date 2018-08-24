package com.pratheeban.divideandconquire;

import java.util.Arrays;

public class Inversion {
	static long countInversions(int[] arr) {
		long count = 0;
		int i = 0;
		// 2,1,3,1,2 i=0 j=0; i=0 j=1; 1,2,3,1,2
		while (i < arr.length) {
			int j = i + 1;
			while (j < arr.length) {
				if (arr[j] < arr[i]) {
					swap(arr, i, j);
					count++;
				}
				j++;
			}
			i++;
		}
		return count;

	}

	static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int getInvCount(int arr[]) {
		int n = arr.length;
		int inv_count = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (arr[i] > arr[j])
					inv_count++;
		return inv_count;
	}

	public static int countInversion(int[] array) {
		return countInversion(array, new int[array.length], 0, array.length - 1);
	}

	private static int countInversion(int[] array, int[] temp, int leftStart, int rightEnd) {
		int inv_count = 0;
		if (rightEnd > leftStart) {

			int middle = (leftStart + rightEnd) / 2;

			inv_count = countInversion(array, temp, leftStart, middle);
			inv_count += countInversion(array, temp, middle + 1, rightEnd);
			inv_count += mergeHalves(array, temp, middle, leftStart, rightEnd);
		}
		return inv_count;
	}

	private static int mergeHalves(int[] array, int[] temp, int middle, int leftStart, int rightEnd) {
		int leftEnd = middle;
		int rightStart = middle + 1;
		int size = rightEnd - leftStart + 1;
		int inv_count = 0;
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
				inv_count += middle - left+1;
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
		return inv_count;
	}

	public static void main(String[] args) {
		// int arr[] = { 2, 1, 3, 1, 2 };
		int arr[] = { 7, 5, 3, 1 }; // 5,7,3,1=3,7,5,1=1,7,5,3=1,5,7,3=1,3,7,5=1,3,5,7
		// System.out.println(countInversions(arr));
		System.out.println(Arrays.toString(arr));
		//System.out.println(getInvCount(arr));
		System.out.println(countInversion(arr));

	}

}
