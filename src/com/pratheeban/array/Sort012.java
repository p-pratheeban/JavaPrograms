package com.pratheeban.array;

import java.util.Arrays;

/*
 * Given an array that contains only 0, 1 or 2, sort it without using any sorting function.
 */
public class Sort012 {
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void sort012(int[] arr) {
		if (arr == null) {
			return;
		}
		int st = 0, mid = 0, end = arr.length - 1;
		while (mid <= end) {
			switch (arr[mid]) {
			case 0:
				swap(arr, st, mid);
				st++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, end);
				end--;
				break;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 2, 1 };
		sort012(arr);
		System.out.println(Arrays.toString(arr));

	}
}
