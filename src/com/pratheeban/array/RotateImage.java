package com.pratheeban.array;

import java.util.Arrays;

public class RotateImage {

	static void printMatrix(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
	}

	static void rotate90(int[][] grid) {
		int n = grid.length;
		int[][] rotategrid = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				rotategrid[c][n - r - 1] = grid[r][c];
			}
		}
		printMatrix(rotategrid);
	}

	static void inplaceRotate(int[][] grid) {
		int n = grid.length;
		for (int layer = 0; layer < n / 2; layer++) {
			for (int i = layer; i < n - layer - 1; i++) {

				int top = grid[layer][i];
				// left -> top
				grid[layer][i] = grid[n - i - 1][layer];
				// bottom -> left
				grid[n - i - 1][layer] = grid[n - layer - 1][n - i - 1];
				// right -> bottom
				grid[n - layer - 1][n - i - 1] = grid[i][n - layer - 1];
				// top -> right
				grid[i][n - layer - 1] = top;
			}

		}
		printMatrix(grid);
	}

	public static int[] reverseAndInvert(int a[]) {
		int[] reverse = new int[a.length];
		int j = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			/*
			 * if(a[i]==0) { reverse[j++] = 1; } else { reverse[j++] = 0; }
			 */
			reverse[j++] = a[i] ^ 1;

		}
		return reverse;
	}

	public static int[][] flipImage(int grid[][]) {
		for (int r = 0; r < grid.length; r++) {
			grid[r] = reverseAndInvert(grid[r]);
		}
		return grid;
	}

	public static int[][] flipAndInvertImage(int[][] A) {
		int C = A[0].length;
		for (int[] row : A)
			for (int i = 0; i < (C + 1) / 2; ++i) {
				int tmp = row[i] ^ 1;
				row[i] = row[C - 1 - i] ^ 1;
				row[C - 1 - i] = tmp;
			}

		return A;
	}

	public static void main(String[] args) {
		int[][] grid = new int[4][4];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = (int) (Math.random() * 10);
			}
		}

		System.out.println("Before Rotation");
		printMatrix(grid);
		System.out.println("After Rotation");
		rotate90(grid);

		System.out.println("After Rotation");
		inplaceRotate(grid);

		int[][] grid1 = new int[4][4];
		for (int i = 0; i < grid1.length; i++) {
			for (int j = 0; j < grid1[i].length; j++) {
				grid1[i][j] = (int) (Math.random() * 2);
			}
		}
		System.out.println("Before Flip Image Horizonatally");
		printMatrix(grid1);
		System.out.println("After Flip Image Horizonatally");
		printMatrix(flipImage(grid1));
		System.out.println("After Flip Image Horizonatally");
		printMatrix(flipAndInvertImage(grid1));

	}
}
