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

	public static void rotate1(int arr[], int k) {
		int n = arr.length;
		if (arr == null || k < 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < k; i++) {
			for (int j = n - 1; j > 0; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
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
		// length of first part
		int a = arr.length - order;
		reverse(arr, 0, a - 1);
		reverse(arr, a, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	public static void reverse(int[] arr, int left, int right) {
		if (arr == null || arr.length == 1)
			return;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(a, 3);
		int a1[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotate1(a1, 3);
		int a2[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotate2(a2, 3);

	}
}
