package com.pratheeban.array;

public class MaxRevenue {
	public static int maxRevenue(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		int lowest = arr[0];
		int maxRev = 0;
		for (int i = 1; i < arr.length; i++) {
			maxRev = Math.max(maxRev, arr[i] - lowest);
			lowest = Math.min(lowest, arr[i]);
		}
		return maxRev;
	}
	public static void main(String[] args) {
		int arr[] = {2, 1, 6, 5, 9};
		System.out.println(maxRevenue(arr));
	}
}
