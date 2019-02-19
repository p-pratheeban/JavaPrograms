package com.pratheeban.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MineSweeper {

	public static boolean isValid(int row, int col, int[][] field) {
		if (0 <= row && row < field.length && 0 <= col && col < field[0].length && field[row][col] != -1) {
			return true;
		}
		return false;
	}

	public static boolean isValid1(int row, int col, int[][] field) {
		if (0 <= row && row < field.length && 0 <= col && col < field[0].length && field[row][col] == 0) {
			return true;
		}
		return false;
	}

	public static void mineSweeper(int[][] bombs, int[][] field) {
		for (int[] bomb : bombs) {
			int rowIndex = bomb[0];
			int colIndex = bomb[1];
			field[rowIndex][colIndex] = -1;
			for (int row = rowIndex - 1; row < rowIndex + 2; row++) {
				for (int col = colIndex - 1; col < colIndex + 2; col++) {
					if (isValid(row, col, field)) {
						field[row][col] += 1;
					}
				}
			}
		}
	}

	public static int[][] click(int[][] field, int givenI, int givenJ) {
		Queue<int[]> toCheck = new ArrayDeque<int[]>();
		if (field[givenI][givenJ] == 0) {
			field[givenI][givenJ] = -2;
			int[] coordinates = { givenI, givenJ };
			toCheck.add(coordinates);
		} else {
			return field;
		}
		while (!toCheck.isEmpty()) {
			int[] currentCoordinates = toCheck.remove();
			int currentI = currentCoordinates[0];
			int currentJ = currentCoordinates[1];
			for (int row = currentI - 1; row < currentI + 2; row++) {
				for (int col = currentJ - 1; col < currentJ + 2; col++) {
					if (isValid1(row, col, field)) {
						field[row][col] = -2;
						int[] coordinates = { row, col };
						toCheck.add(coordinates);
					}
				}
			}
		}
		return field;
	}

	public static int[][] click1(int[][] field, int givenI, int givenJ) {
		Queue<Pair> toCheck = new ArrayDeque<Pair>();
		if (field[givenI][givenJ] == 0) {
			field[givenI][givenJ] = -2;
			Pair coordinates = new Pair(givenI, givenJ);
			toCheck.add(coordinates);
		} else {
			return field;
		}
		while (!toCheck.isEmpty()) {
			Pair currentCoordinates = toCheck.remove();
			int currentI = currentCoordinates.x;
			int currentJ = currentCoordinates.y;
			for (int row = currentI - 1; row < currentI + 2; row++) {
				for (int col = currentJ - 1; col < currentJ + 2; col++) {
					if (isValid1(row, col, field)) {
						field[row][col] = -2;
						Pair coordinates = new Pair(row, col);
						toCheck.add(coordinates);
					}
				}
			}
		}
		return field;
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int[][] bombs = { { 0, 2 }, { 2, 0 } };
		int[][] field = { { 0, 1, 1 }, { 1, 20, 1 }, { 2, 1, 0 } };
		for (int i = 0; i < field.length; i++) {
			System.out.println(Arrays.toString(field[i]));
		}
		System.out.println("After");
		mineSweeper(bombs, field);
		for (int i = 0; i < field.length; i++) {
			System.out.println(Arrays.toString(field[i]));
		}
		int[][] field1 = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 1, -1, 1, 0 } };
		for (int i = 0; i < field1.length; i++) {
			System.out.println(Arrays.toString(field1[i]));
		}
		System.out.println("After");
		click(field1, 1, 4);
		for (int i = 0; i < field1.length; i++) {
			System.out.println(Arrays.toString(field1[i]));
		}
		int[][] field2 = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 1, -1, 1, 0 } };
		System.out.println("After");
		click1(field2, 1, 4);
		for (int i = 0; i < field2.length; i++) {
			System.out.println(Arrays.toString(field2[i]));
		}
	}

}
