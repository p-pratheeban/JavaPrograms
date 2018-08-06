package com.pratheeban.recursive;

public class MagicIndex {
	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public static int magicFast(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return magicFast(array, start, mid - 1);
		} else {
			return magicFast(array, mid + 1, end);
		}
	}

	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}
	
	
	public static int magicFast1(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFast1(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}
		
		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast1(array, rightIndex, end);
		
		return right;
	}
	
	public static int magicFast1(int[] array) {
		return magicFast1(array, 0, array.length - 1);
	}
	public static void main(String[] args) {

		int[] array = { -3, -4, 1, 2, 4, 6, 8 };
		System.out.println(magicSlow(array));
		System.out.println(magicFast(array));
		System.out.println(magicFast1(array));


	}
}
