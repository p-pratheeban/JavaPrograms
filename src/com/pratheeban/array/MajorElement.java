package com.pratheeban.array;

import java.util.HashMap;
import java.util.Map;

/*
 * Find the majority element. In this problem, majority element is defined as the number that
appears more than n/2 times in an array of numbers.
 */
public class MajorElement {
	public static int findMajElement(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		int count = 1, maj = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == maj) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				maj = arr[i];
				count = 1;
			}
		}
		return maj;
	}

	public static int findMajElement1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int maxcount = 1, maj = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int count = map.get(arr[i]) + 1;
				if (count > maxcount) {
					maxcount = count;
					maj = arr[i];
				}
				map.put(arr[i], count);
			}
			map.put(arr[i], 1);
		}
		return maj;
	}

	public static boolean verifyMajElement(int[] arr, int maj) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		int n = arr.length, count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == maj) {
				count++;
			}
			if (count > n / 2) {
				return true;
			}
		}
		return false;
	}

	public static int findMostPopular(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		int element = arr[0];
		int count = 1;
		int maxElement = arr[0];
		int maxCount = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == element) {
				count++;
			} else {
				count = 1;
				element = arr[i];
			}
			if (count > maxCount) {
				maxCount = count;
				maxElement = element;
			}
		}
		return maxElement;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 2, 1, 2, 2, 1 };
		System.out.println(findMajElement(arr));
		System.out.println(findMajElement1(arr));

		int arr1[] = { 2, 3, 3, 1, 3, 2, 4, 5, 6, 1};
		System.out.println(findMajElement(arr1));
		System.out.println(findMajElement1(arr1));

		int maj = findMajElement(arr);
		if (maj == Integer.MIN_VALUE || verifyMajElement(arr, maj) == false) {
			System.out.println("No majority element found.");
		} else {
			System.out.println("Majority element: " + maj);
		}
		
		int arr2[] = {1, 1, 1, 4, 4, 4, 4, 5, 6};
		System.out.println(findMostPopular(arr2));
	}
}
