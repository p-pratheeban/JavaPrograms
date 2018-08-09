package com.pratheeban.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int result[] = new int[2];
		Set<Integer> s = new HashSet<>();
		for (int n : nums) {
			s.add(n);
		}
		for (int n : nums) {
			int k = target - n;
			if (s.contains(k) && k != n) {
				result[0] = n;
				result[1] = target - n;
				break;
			}
		}
		return result;

	}

	public static int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> s = new HashMap<>();
		int j = 0;
		for (int n : nums) {
			s.put(n, j++);
		}
		for (int i = 0; i < nums.length; i++) {
			int k = target - nums[i];
			if (s.containsKey(k) && s.get(k) != i) {
				return new int[] { i, s.get(k) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");

	}

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

	public static void main(String[] args) {
		int nums[] = { 2, 7, 11, 15 };

		System.out.println(Arrays.toString(twoSum(nums, 9)));
		System.out.println(Arrays.toString(twoSum1(nums, 9)));
		System.out.println(Arrays.toString(twoSum2(nums, 9)));
		System.out.println(Arrays.toString(twoSum3(nums, 9)));

		int nums1[] = { 3, 2, 4 };

		System.out.println(Arrays.toString(twoSum(nums1, 6)));
		System.out.println(Arrays.toString(twoSum1(nums1, 6)));
		System.out.println(Arrays.toString(twoSum2(nums1, 6)));
		System.out.println(Arrays.toString(twoSum3(nums1, 6)));

	}
}
