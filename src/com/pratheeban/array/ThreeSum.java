package com.pratheeban.array;

import java.util.Arrays;

public class ThreeSum {
	public static int[] threeSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum == target) {
					return new int[] { i, start, end };
				} else if (sum > target) {
					end--;
				} else {
					start++;
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		int arr[] = {1, 2, 5, 7, 8, 9};
		System.out.println(Arrays.toString(threeSum(arr, 17)));
	}
}
