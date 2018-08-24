package com.pratheeban.divideandconquire;

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

	public static void main(String[] args) {
		int a[] = { 2, 5, 8, 9, 11, 12, 13 };
		System.out.println(binarySearch(a, 13));
		System.out.println(binarySearch(a, 0, a.length - 1, 13));

		System.out.println(binarySearch(a, 15));
		System.out.println(binarySearch(a, 0, a.length - 1, 15));

		System.out.println(binarySearch(a, 5));
		System.out.println(binarySearch(a, 0, a.length - 1, 5));

	}
}
