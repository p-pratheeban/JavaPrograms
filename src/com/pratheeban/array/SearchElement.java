package com.pratheeban.array;

import java.util.HashSet;
import java.util.Set;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " , " + y;
	}
}

public class SearchElement {
	/*
	 * Find the position of a number in a 2D array of integers where its columns and
	 * rows are sorted.
	 */
	public static Point findNum(int[][] arr, int num) {
		int x = 0;
		int y = arr[0].length - 1;
		while (y >= 0 && x < arr[0].length) {
			if (arr[x][y] == num) {
				return new Point(x, y);
			} else if (num > arr[x][y]) {
				x++;
			} else {
				y--;
			}
		}
		return new Point(-1, -1);
	}

	/*
	 * Given an array of integers that all integers appear twice except one that
	 * appears once, find that single integer.
	 */
	public static int findSingle(int[] arr) {
		if (arr == null) {
			return Integer.MIN_VALUE;
		}
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int cur = arr[i];
			if (set.contains(cur) == true) {
				sum -= cur;
			} else {
				set.add(cur);
				sum += cur;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
		System.out.println(findNum(arr, 3));

		int arr1[] = { 2, 4, 2, 3, 5, 3, 4 };
		System.out.println(findSingle(arr1));
	}
}
