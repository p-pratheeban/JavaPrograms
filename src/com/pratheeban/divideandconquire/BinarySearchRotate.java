package com.pratheeban.divideandconquire;

/*
 * Given an array that was sorted but was rotated an unknown number of times, find the position
of a target element. If the input array contains duplicate entries, the target can only be found with linear search in O(N)
running time.
 */
public class BinarySearchRotate {

	public static int binaryRoatedSearch(int a[], int ele) {
		int leftStart = 0;
		int rightEnd = a.length - 1;
		while (leftStart <= rightEnd) {
			int middle = (leftStart + rightEnd) / 2;
			if (a[middle] == ele) {
				return middle;
			} else if (ele < a[middle] && ele >= a[leftStart]) {
				rightEnd = middle - 1;
			} else {
				leftStart = middle + 1;
			}
		}
		return -1;
	}

	public static int binaryRoatedSearch1(int a[], int leftStart, int rightEnd, int ele) {
		if (leftStart > rightEnd)
			return -1;
		int middle = (leftStart + rightEnd) / 2;
		if (a[middle] == ele) {
			return middle;
		} else if (ele < a[middle] && ele >= a[leftStart]) {
			return binaryRoatedSearch1(a, leftStart, middle - 1, ele);
		}
		return binaryRoatedSearch1(a, middle + 1, rightEnd, ele);
	}

	public static int binaryRoatedSearch2(int[] arr, int target) {
		if (arr == null) {
			return Integer.MIN_VALUE;
		}
		int st = 0;
		int end = arr.length - 1;
		while (st <= end) {
			int mid = (st + end) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			// at least one part must be sorted
			if (arr[st] <= arr[mid]) { // left part is sorted
				if (arr[st] < target && target <= arr[mid]) {
					end = mid - 1;
				} else {
					st = mid + 1;
				}
			} else { // right part is sorted
				if (arr[mid] < target && target <= arr[end]) {
					st = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int a[] = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(binaryRoatedSearch(a, 2));
		System.out.println(binaryRoatedSearch(a, 6));
		System.out.println(binaryRoatedSearch(a, 0));

		System.out.println(binaryRoatedSearch1(a, 0, a.length - 1, 2));
		System.out.println(binaryRoatedSearch2(a, 2));

	}
}
