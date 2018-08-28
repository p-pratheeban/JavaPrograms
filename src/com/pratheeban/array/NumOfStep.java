package com.pratheeban.array;

/*
 * Given an array that at each place represents how many steps forward you can make in the
array, find the minimum number of steps needed to reach the end of the array.
 */
public class NumOfStep {
	public static int minNumOfSteps(int[] arr) {
		if (arr == null) {
			return Integer.MIN_VALUE;
		}
		int[] opt = new int[arr.length];
		opt[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			int min = arr.length;
			for (int k = 0; k < i; k++) {
				if (i - k <= arr[k]) {
					min = Math.min(min, opt[k] + 1);
				}
			}
			opt[i] = min;
		}
		return opt[arr.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(minNumOfSteps(new int[] { 2, 1, 1, 8, 1, 1, 1 }));
	}
}
