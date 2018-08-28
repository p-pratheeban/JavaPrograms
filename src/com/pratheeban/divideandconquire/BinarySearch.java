package com.pratheeban.divideandconquire;

import java.util.Arrays;

public class BinarySearch {

	public static int binarySearch(int a[], int ele) {
		int leftStart = 0;
		int rightEnd = a.length - 1;
		while (leftStart <= rightEnd) {
			int middle = (leftStart + rightEnd) / 2;
			if (a[middle] == ele) {
				return middle;
			} else if (ele < a[middle]) {
				rightEnd = middle - 1;
			} else {
				leftStart = middle + 1;
			}
		}
		return -1;
	}

	public static int binarySearch(int a[], int leftStart, int rightEnd, int ele) {
		if (leftStart > rightEnd)
			return -1;
		int middle = (leftStart + rightEnd) / 2;
		if (a[middle] == ele) {
			return middle;
		} else if (ele < a[middle]) {
			return binarySearch(a, leftStart, middle - 1, ele);
		}
		return binarySearch(a, middle + 1, rightEnd, ele);
	}

	/*
	 * Given a sorted array of integers that contains each entry multiple times,
	 * find the start and end position of a target integer.
	 */
	public static int binarySearch1(int a[], int ele) {
		int leftStart = 0;
		int rightEnd = a.length - 1;
		while (leftStart <= rightEnd) {
			int middle = (leftStart + rightEnd) / 2;
			if (a[middle] == ele && (middle == 0 || a[middle - 1] != ele)) {
				System.out.println("Start position " + middle);
				leftStart = middle + 1;
			} else if (a[middle] == ele && (middle == a.length - 1 || a[middle + 1] != ele)) {
				System.out.println("End position " + middle);
				return middle;
			} else if (ele < a[middle]) {
				rightEnd = middle - 1;
			} else {
				leftStart = middle + 1;
			}
		}
		return -1;
	}

	public static int modifiedBinSearch(int[] arr, double target) {
		int st = 0, end = arr.length - 1;
		while (st <= end) {
			int mid = (st + end) / 2;
			if (target > arr[mid]) {
				st = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return st;
	}

	public static int[] findRange(int[] arr, int target) {
		int[] res = { -1, -1 };
		if (arr == null) {
			return res;
		}
		int lo = modifiedBinSearch(arr, target - 0.5);
		if (lo >= arr.length || arr[lo] != target) {
			return res;
		}
		int hi = modifiedBinSearch(arr, target + 0.5);
		res[0] = lo;
		res[1] = hi-1;
		return res;
	}

	public static void main(String[] args) {
		int a[] = { 2, 5, 8, 9, 11, 12, 13 };
		System.out.println(binarySearch(a, 13));
		System.out.println(binarySearch(a, 0, a.length - 1, 13));

		System.out.println(binarySearch(a, 15));
		System.out.println(binarySearch(a, 0, a.length - 1, 15));

		System.out.println(binarySearch(a, 5));
		System.out.println(binarySearch(a, 0, a.length - 1, 5));
		int a1[] = { 1, 2, 3, 7, 7, 7, 9, 9 };
		System.out.println(binarySearch1(a1, 7));
		System.out.println(binarySearch1(a1, 9));
		System.out.println(binarySearch1(a1, 1));
		System.out.println(Arrays.toString(findRange(a1,7)));
		System.out.println(Arrays.toString(findRange(a1,9)));
		System.out.println(Arrays.toString(findRange(a1,1)));

	}
}
