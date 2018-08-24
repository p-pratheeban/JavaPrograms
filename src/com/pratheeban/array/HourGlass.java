package com.pratheeban.array;

public class HourGlass {
	public static boolean isValid(int[][] arr, int row, int col) {

		if (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length) {
			return true;
		}
		return false;
	}

	public static int hourglassSum(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length - 1; i++) {
			for (int j = 1; j < arr[0].length - 1; j++) {
				int sum = arr[i][j];
				for (int k = -1; k < 2; k++) {
					sum += arr[i - 1][j + k] + arr[i + 1][j + k];
				}
				max = Math.max(max, sum);
			}
		}
		return max;
	}
}
