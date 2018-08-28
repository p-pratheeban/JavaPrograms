package com.pratheeban.graph.dfs;

public class ConnectedGrid {
	/* Returns the size of the largest region */
	public static int largestRegion(int[][] grid) {
		int maxRegion = 0;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				/* Find the largest region from the current cell */
				if (grid[row][col] == 1) {
					int size = findLargestRegion(grid, row, col);
					maxRegion = Math.max(maxRegion, size);
				}
			}
		}
		return maxRegion;
	}

	private static int findLargestRegion(int[][] grid, int row, int col) {
		/*
		 * Put boundary checks here (at top of recursive call), instead of before doing
		 * recursive call
		 */
		if (row < 0 || row >= grid.length|| col < 0 || col >= grid[0].length || grid == null
				|| grid[row][col] == 0) {
			return 0;
		}

		grid[row][col] = 0; // we alter the original matrix here
		int size = 1; // 1 accounts for our size

		/* Recursively search neighbors */
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (!(r == row && c == col)) {
					size += findLargestRegion(grid, r, c);
				}
			}
		}

		return size;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 0 } };

		System.out.println(largestRegion(arr));

		int arr1[][] = { { 0, 0, 1, 1 }, { 0, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(largestRegion(arr1));

	}
}
