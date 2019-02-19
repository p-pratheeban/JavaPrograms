package com.pratheeban.array;

import java.util.Arrays;

public class RotateArray {
	public static void rotate(int arr[], int k) {
		int n = arr.length;
		if (k > n) {
			k = k % n;
		}
		int result[] = new int[n];
		for (int i = 0; i < k; i++) {
			result[i] = arr[n - k + i];
		}

		int j = 0;
		for (int i = k; i < n; i++) {
			result[i] = arr[j++];
		}
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(arr));
		System.arraycopy(result, 0, arr, 0, n);
		System.out.println(Arrays.toString(arr));

	}

	public static void rotateArray(int[] arr, int d) {
		int n = arr.length;

		// Create new array for rotated elements:
		int[] rotated = new int[n];

		// Copy segments of shifted elements to rotated array:
		System.arraycopy(arr, n - d, rotated, 0, d);
		System.arraycopy(arr, 0, rotated, n - d - 1, n - d);
		System.out.println(Arrays.toString(rotated));

	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void rotate1(int arr[], int k) {
		int n = arr.length;
		if (arr == null || k < 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < k; i++) {
			for (int j = n - 1; j > 0; j--) {
				swap(arr, j, j - 1);
			}
		}

		System.out.println(Arrays.toString(arr));

	}

	public static void rotate2(int[] arr, int order) {
		if (arr == null || arr.length == 0 || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
		if (order > arr.length) {
			order = order % arr.length;
		}
		// a = [1, 2, 3, 4, 5, 6, 7]
		// length of first part
		int a = arr.length - order;
		reverse(arr, 0, a - 1);// [4, 3, 2, 1, 5, 6, 7]
		reverse(arr, a, arr.length - 1);// [4, 3, 2, 1, 7, 6, 5]
		reverse(arr, 0, arr.length - 1);// [5, 6, 7, 1, 2, 3, 4]
		System.out.println(Arrays.toString(arr));

	}

	public static void reverse(int[] arr, int left, int right) {
		if (arr == null || arr.length == 1)
			return;
		while (left < right) {
			swap(arr, left, right);
			left++;
			right--;
		}
	}

	public static boolean isRotate(int[] array1, int[] array2) {
		if (array1.length != array2.length) {
			return false;
		}
		int key = array1[0];
		int index = -1;
		for (int i = 0; i < array2.length; i++) {
			if (array2[i] == key) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return false;
		}
		int j = -1;
		for (int i = 0; i < array1.length; i++) {
			j = (index+i) % array1.length;
			if (array1[i] != array2[j]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(a, 3);
		int a1[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotate1(a1, 3);
		int a2[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotate2(a2, 3);
		int a3[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotateArray(a3, 3);

		int[] array1 = { 1, 2, 3, 4, 5, 6, 7 };
		int[] array2 = { 4, 5, 6, 8, 1, 2, 3 };
		System.out.println(isRotate(array1, array2));
		int[] array3 = { 4, 5, 6, 7, 1, 2, 3 };
		System.out.println(isRotate(array1, array3));

	}
}
