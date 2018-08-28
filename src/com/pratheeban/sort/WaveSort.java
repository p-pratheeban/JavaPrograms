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
			swap(arr,i,i+1);
		}
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 4, 5, 6, 7 };
		waveSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
