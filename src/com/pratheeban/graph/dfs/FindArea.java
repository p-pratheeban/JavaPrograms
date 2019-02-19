package com.pratheeban.graph.dfs;

/*
 * Given a 2D array of integers and a starting point, find the continuous area covered with the
same value as the starting point.
 */
public class FindArea {
	static int mArea = 0;

	public static void findArea(int[][] arr, int x, int y) {
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		mArea = 0;
		findAreaHelper(arr, visited, arr[x][y], x, y);
	}

	public static void findAreaHelper(int[][] arr, boolean[][] visited, int value, int x, int y) {
		if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
			return;
		}
		if (visited[x][y] == true) {
			return;
		}
		visited[x][y] = true;
		if (arr[x][y] == value) {
			mArea++;
			findAreaHelper(arr, visited, value, x + 1, y);
			findAreaHelper(arr, visited, value, x, y + 1);
			findAreaHelper(arr, visited, value, x - 1, y);
			findAreaHelper(arr, visited, value, x, y - 1);
		}
	}

	public static int findAreaHelper1(int[][] arr, boolean[][] visited, int value, int x, int y) {
		if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
			return 0;
		}
		if (visited[x][y] == true) {
			return 0;
		}
		visited[x][y] = true;
		int count = 0;
		if (arr[x][y] == value) {
			count = 1;
			count += findAreaHelper1(arr, visited, value, x + 1, y);
			count += findAreaHelper1(arr, visited, value, x, y + 1);
			count += findAreaHelper1(arr, visited, value, x - 1, y);
			count += findAreaHelper1(arr, visited, value, x, y - 1);
		}
		return count;
	}

	public static int findArea1(int[][] arr, int x, int y) {
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		return findAreaHelper1(arr, visited, arr[x][y], x, y);
	}

	public static int findArea2(int[][] arr, int x, int y) {
		return findAreaHelper2(arr, arr[x][y], x, y);

	}

	public static int findAreaHelper2(int[][] arr, int value, int x, int y) {
		if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] != value) {
			return 0;
		}
		arr[x][y] = -value;
		int count = 1;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (!(i == x & j == y)) {
					count += findAreaHelper2(arr, value, i, j);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 1, 2 }, { 1, 1, 2 }, { 1, 2, 1 } };
		findArea(arr, 0, 0);
		System.out.println(mArea);
		int arr1[][] = { { 1, 1, 2 }, { 1, 1, 2 }, { 1, 2, 1 } };
		System.out.println(findArea1(arr1, 0, 0));
		int arr2[][] = { { 1, 1, 2 }, { 1, 1, 2 }, { 1, 2, 1 } };
		System.out.println(findArea1(arr2, 0, 0));
	}
}
