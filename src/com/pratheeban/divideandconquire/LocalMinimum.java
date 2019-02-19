package com.pratheeban.divideandconquire;

public class LocalMinimum {
	public static int findLocalMin(int[] arr, int st, int end) {
		int mid = (st + end) / 2;
		if ((mid - 1 < 0) || (mid + 1 >= arr.length)) {
			return -1;
		}
		if ((arr[mid - 1] > arr[mid]) && (arr[mid + 1] > arr[mid])) {
			return mid;
		} else if (arr[mid - 1] < arr[mid]) {
			return findLocalMin(arr, st, mid);
		} else {
			return findLocalMin(arr, mid, end);
		}
	}

	public static int findLocalMin1(int[] arr, int st, int end) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i] && arr[i + 1] > arr[i]) {
				return arr[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 9, 7, 8, 8, 5, 6, 3, 4 };
		System.out.println(findLocalMin(arr, 0, arr.length - 1));
		System.out.println(findLocalMin1(arr, 0, arr.length - 1));
	}
}
