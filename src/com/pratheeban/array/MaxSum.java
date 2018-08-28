package com.pratheeban.array;

public class MaxSum {
	/*
	 * Find the maximum sum of a continuous subsequence in an array of integers.
	 */
	public static int maxSubSequence(int[] arr) {
		int max = arr[0];
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {
			while (i < arr.length && arr[i] > 0) {
				sum += arr[i];
				i++;
			}
			if (sum > max) {
				max = sum;
				sum = 0;
			}
		}
		return max;
	}

	public static int maxSubSequence1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		int maxSoFar = arr[0], curMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			curMax = Math.max(curMax + arr[i], arr[i]);
			maxSoFar = Math.max(curMax, maxSoFar);
		}
		return maxSoFar;
	}

	/*
	 * Given an array of numbers that is first strictly increasing and then strictly
	 * decreasing, find the maximum number.
	 */
	public static int findMax(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i + 1] < arr[i]) {
				return arr[i];
			}
		}
		return -1;
	}

	public static int findMax1(int[] arr) {

		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
				return arr[mid];
			} else if (arr[mid - 1] < arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, -3, 2, 5, -8 };
		System.out.println(maxSubSequence(arr));
		System.out.println(maxSubSequence1(arr));

		int arr1[] = { 1, -3, 2, 5, -8, 7, 8, 10 };
		System.out.println(maxSubSequence(arr1));
		System.out.println(maxSubSequence1(arr1));

		int arr2[] = { 1, 2, 3, 4, 5, 4, 3, 2 };
		System.out.println(findMax(arr2));
		System.out.println(findMax1(arr2));

	}
}
