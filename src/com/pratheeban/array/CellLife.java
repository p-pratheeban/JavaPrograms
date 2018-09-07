package com.pratheeban.array;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class CellLife {

	public static int N = 4;

	/**
	 * Gets the next generation in the cell life game. A cell can be 0 == dead or 1
	 * == alive at any point in time. A cell dies of loneliness if it has 1 or fewer
	 * neighbours who are alive. A cell comes alive if it has 2 live neighbours and
	 * dies of overcrowding if it has 3 or more live neighbours.
	 */
	public static int[][] getNextGeneration(int[][] current) {
		int[][] next = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				next[i][j] = getCellState1(i, j, current);
			}
		}

		return next;
	}

	public static int getCellState(int row, int col, int[][] current) {
		int liveCount = 0;
		int lastCellIndex = N - 1;
		if (row > 0 && col > 0) {
			liveCount += current[row - 1][col - 1];
		}
		if (row > 0) {
			liveCount += current[row - 1][col];
			if (col < lastCellIndex) {
				liveCount += current[row - 1][col + 1];
			}
		}
		if (col < lastCellIndex) {
			liveCount += current[row][col + 1];
		}
		if (col > 0) {
			liveCount += current[row][col - 1];
			if (row < lastCellIndex) {
				liveCount += current[row + 1][col - 1];
			}
		}
		if (row < lastCellIndex) {
			liveCount += current[row + 1][col];
		}
		if (row < lastCellIndex && col < lastCellIndex) {
			liveCount += current[row + 1][col + 1];
		}

		return liveCount == 2 ? 1 : 0;
	}

	public static boolean isValid(int row, int col, int[][] arr) {
		if (row < 0 || row >= arr.length || col < 0 || col >= arr.length) {
			return false;
		}
		return true;
	}

	public static int getCellState1(int row, int col, int[][] current) {
		int liveCount = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (isValid(i, j, current) && !(row == i && col == j)) {
					liveCount += current[i][j];
				}
			}
		}
		return liveCount == 2 ? 1 : 0;

	}

	public static void print(int[][] generation) {
		System.out.println("Generation ");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(generation[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] current = { { 0, 0, 0, 0 }, { 0, 0, 0, 1 }, { 1, 1, 1, 0 }, { 0, 0, 0, 0 } };
		print(current);
		print(getNextGeneration(current));

	}

}
