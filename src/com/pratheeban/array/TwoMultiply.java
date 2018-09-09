package com.pratheeban.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoMultiply {

	public static List<Integer> twoMultiply(int arr[], int target) {
		Set<Integer> nums = new HashSet<>();
		List<Integer> result = new ArrayList<>();

		for (int num : arr) {
			if ((target % num == 0) && nums.contains(target / num)) {
				result.add(num);
				result.add(target / num);
				return result;
			} else {
				nums.add(num);
			}
		}
		return null;
	}

	public static List<Integer> threeMultiply(int arr[], int target) {
		Set<Integer> nums = new HashSet<>();
		List<Integer> result = null;

		for (int num : arr) {
			result = twoMultiply(arr, target / num);
			if (result != null) {
				result.add(num);
				return result;
			} else {
				nums.add(num);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 6, 5 };
		System.out.println(twoMultiply(arr, 20));
		System.out.println(threeMultiply(arr, 40));

	}
}
