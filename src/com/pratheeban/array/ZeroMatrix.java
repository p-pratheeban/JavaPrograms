package com.pratheeban.array;

import java.util.Arrays;

public class ZeroMatrix {

	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}

	public static void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	public static void setZeros(int[][] matrix) {
		int rows[] = new int[matrix.length];
		int cols[] = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] == 1) {
				nullifyRow(matrix, i);
			}
		}
		for (int i = 0; i < cols.length; i++) {
			if (cols[i] == 1) {
				nullifyColumn(matrix, i);
			}
		}

	}

	public static void setZeros1(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;

		// Check if first row has a zero
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}

		// Check if first column has a zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}

		// Check for zeros in the rest of the array
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// Nullify rows based on values in first column
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}

		// Nullify columns based on values in first row
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}

		// Nullify first row
		if (rowHasZero) {
			nullifyRow(matrix, 0);
		}

		// Nullify first column
		if (colHasZero) {
			nullifyColumn(matrix, 0);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * 10);
			}
		}
		System.out.println("Before");
		printMatrix(matrix);
		System.out.println("After");
		setZeros(matrix);
		printMatrix(matrix);
		
		int[][] matrix1 = new int[3][4];
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[i].length; j++) {
				matrix1[i][j] = (int) (Math.random() * 10);
			}
		}
		System.out.println("Before");
		printMatrix(matrix1);
		System.out.println("After");
		setZeros1(matrix1);
		printMatrix(matrix1);
	}
}
