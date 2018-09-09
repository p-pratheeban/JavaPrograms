package com.pratheeban.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Duplicate {

	/*
	 * Given an array of integers, find if the array contains any duplicates. Your
	 * function should return true if any value appears at least twice in the array,
	 * and it should return false if every element is distinct.
	 */
	public static boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (!set.add(i)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Given an array of integers and an integer k, return true if and only if there
	 * are two distinct indices i and j in the array such that nums[i] = nums[j] and
	 * the difference between i and j is at most k.
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int preIndex = map.get(nums[i]);
				int gap = i - preIndex;
				min = Math.min(min, gap);
			}
			map.put(nums[i], i);
		}
		System.out.println(min);
		if (min <= k) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean containsNearbyDuplicate1(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int pre = map.get(nums[i]);
				if (i - pre <= k)
					return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}

	/*
	 * Given an array of integers, find out whether there are two distinct indices i
	 * and j in the array such that the difference between nums[i] and nums[j] is at
	 * most t and the difference between i and j is at most k.
	 */
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			int c = nums[i];
			if ((set.floor(c) != null && c <= set.floor(c) + t) || (set.ceiling(c) != null && c >= set.ceiling(c) - t))
				return true;
			set.add(c);
			if (i >= k)
				set.remove(nums[i - k]);
		}
		return false;
	}

	public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		SortedSet<Integer> set = new TreeSet<>();
		for (int j = 0; j < nums.length; j++) {
			int leftBoundary = nums[j] - t;
			int rightBoundary = nums[j] + t + 1;
			SortedSet<Integer> subSet = set.subSet(leftBoundary, rightBoundary);
			if (!subSet.isEmpty())
				return true;
			set.add(nums[j]);
			if (j >= k) {
				set.remove(nums[j - k]);
			}
		}
		return false;
	}

	/*
	 * Given a sorted array, remove the duplicates in place such that each element
	 * appear only once and return the new length. Do not allocate extra space for
	 * another array, you must do this in place with constant memory.
	 */
	public static int removeDuplicates(int[] A) {
		if (A.length < 2)
			return A.length;
		int j = 0;
		int i = 1;
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		System.out.println(Arrays.toString(A));
		return j + 1;
	}

	public static int removeDuplicates1(int[] A) {
		if (A.length < 2)
			return A.length;
		int j = 1;
		for (int i = 1; i <= A.length - 1; i++) {
			if (A[i - 1] != A[i]) {
				A[j++] = A[i];
			}
		}
		System.out.println(Arrays.toString(A));
		return j;
	}

	// Create an array with all unique elements
	public static int[] removeDuplicates2(int[] A) {
		if (A.length < 2)
			return A;
		int j = 0;
		int i = 1;
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		int[] B = Arrays.copyOf(A, j + 1);
		return B;
	}

	// Count the number of unique elements
	public static int countUnique(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] == A[i + 1]) {
				count++;
			}
		}
		return (A.length - count);
	}

	public static void main(String[] args) {
		int a[] = { 3, 5, 6, 3, 4 };
		System.out.println(containsDuplicate(a));

		int a1[] = { 3, 5, 6, 3, 4, 3 };
		System.out.println(containsNearbyDuplicate(a1, 3));
		System.out.println(containsNearbyDuplicate(a1, 2));

		System.out.println(containsNearbyDuplicate1(a1, 3));
		System.out.println(containsNearbyDuplicate1(a1, 2));
		int a2[] = { 4, 1, 6, 3, 4, 3 };

		System.out.println(containsNearbyAlmostDuplicate(a2, 3, 2));
		System.out.println(containsNearbyAlmostDuplicate1(a2, 1, 1));
		int a3[] = { 0, 1, 1, 2, 3, 3, 3, 4 };

		System.out.println(removeDuplicates(a3));
		int a4[] = { 1, 1, 2, 3, 3, 3 };

		int a5[] = removeDuplicates2(a4);
		System.out.println(Arrays.toString(a5));
		System.out.println(countUnique(a4));

		int a6[] = { 0, 1, 1, 2, 3, 3, 3, 4, 5 };
		System.out.println(removeDuplicates1(a6));

	}

}
