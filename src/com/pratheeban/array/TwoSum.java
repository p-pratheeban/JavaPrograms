package com.pratheeban.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

	private static Map<Integer, Integer> table = new HashMap<>();

	// O(n) runtime, O(n) space
	public static int[] twoSum(int[] nums, int target) {
		int result[] = new int[2];
		Set<Integer> s = new HashSet<>();

		for (int n : nums) {
			int k = target - n;
			if (s.contains(k) && k != n) {
				result[0] = n;
				result[1] = target - n;
				break;
			} else {
				s.add(n);
			}

		}
		return result;

	}

	// O(n) runtime, O(n) space
	public static int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> s = new HashMap<>();
		int j = 0;

		for (int i = 0; i < nums.length; i++) {
			int k = target - nums[i];
			if (s.containsKey(k) && s.get(k) != i) {
				return new int[] { i, s.get(k) };
			} else {
				s.put(nums[i], i);

			}
		}
		throw new IllegalArgumentException("No two sum solution");

	}

	// O(n) runtime, O(n) space
	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> s = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (s.containsKey(nums[i])) {
				return new int[] { s.get(nums[i]), i };
			} else {
				s.put(target - nums[i], i);
			}
		}
		throw new IllegalArgumentException("No two sum solution");

	}

	// O(n2) runtime, O(1) space
	public static int[] twoSum3(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// Two Sum II – Input array is sorted
	public static int[] twoSum4(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int j = Arrays.binarySearch(nums, target - nums[i]);
			if (j != -1) {
				return new int[] { i, j };
			}
		}

		throw new IllegalArgumentException("No two sum solution");
	}

	public static int[] twoSum5(int[] numbers, int target) {
		// Assume input is already sorted.
		for (int i = 0; i < numbers.length; i++) {
			int j = bsearch(numbers, target - numbers[i], i + 1);
			if (j != -1) {
				return new int[] { i, j };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	private static int bsearch(int[] A, int key, int start) {
		int l = start, r = A.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (A[m] < key) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return (l == l && A[l] == key) ? l : -1;
	}

	// O(n) runtime, O(1) space – Two pointers
	public static int[] twoSum6(int[] numbers, int target) {
		// Assume input is already sorted.
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				return new int[] { i, j };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// add – O(1) runtime, find – O(n) runtime, O(n) space – Store input in hash
	// table
	public void add(int input) {
		int count = table.containsKey(input) ? table.get(input) : 0;
		table.put(input, count + 1);
	}

	public boolean find(int val) {
		for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
			int num = entry.getKey();
			int y = val - num;
			if (y == num) {
				// For duplicates, ensure there are at least two individual numbers.
				if (entry.getValue() >= 2)
					return true;
			} else if (table.containsKey(y)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int nums[] = { 2, 7, 11, 15 };

		System.out.println(Arrays.toString(twoSum(nums, 9)));
		System.out.println(Arrays.toString(twoSum1(nums, 9)));
		System.out.println(Arrays.toString(twoSum2(nums, 9)));
		System.out.println(Arrays.toString(twoSum3(nums, 9)));
		System.out.println(Arrays.toString(twoSum4(nums, 9)));
		System.out.println(Arrays.toString(twoSum5(nums, 9)));
		System.out.println(Arrays.toString(twoSum6(nums, 9)));

		int nums1[] = { 3, 2, 4 };

		System.out.println(Arrays.toString(twoSum(nums1, 6)));
		System.out.println(Arrays.toString(twoSum1(nums1, 6)));
		System.out.println(Arrays.toString(twoSum2(nums1, 6)));
		System.out.println(Arrays.toString(twoSum3(nums1, 6)));

	}
}
