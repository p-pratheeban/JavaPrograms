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
	}
}
