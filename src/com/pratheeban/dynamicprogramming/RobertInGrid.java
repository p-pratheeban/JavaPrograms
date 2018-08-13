package com.pratheeban.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class Point {
	public int row, column;

	public Point(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Point) && (((Point) o).row == this.row) && (((Point) o).column == this.column)) {
			return true;
		} else {
			return false;
		}
	}
}

public class RobertInGrid {
	public static ArrayList<Point> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0)
			return null;
		ArrayList<Point> path = new ArrayList<Point>();
		if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
			return path;
		}
		return null;
	}

	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		// If out of bounds or not available, return.
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}

		boolean isAtOrigin = (row == 0) && (col == 0);

		// If there's a path from the start to my current location, add my location.
		if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}

		return false;
	}

	public static ArrayList<Point> getPath1(boolean[][] maze) {
		if (maze == null || maze.length == 0)
			return null;
		ArrayList<Point> path = new ArrayList<Point>();
		if (getPath1(maze, 0, 0, path)) {
			return path;
		}
		return null;
	}

	public static boolean getPath1(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		// If out of bounds or not available, return.
		if (col >= maze[0].length || row >= maze.length || !maze[row][col]) {
			return false;
		}

		boolean isAtEnd = (row == maze.length - 1) && (col == maze[0].length - 1);

		// If there's a path from the start to my current location, add my location.
		if (isAtEnd || getPath1(maze, row, col + 1, path) || getPath1(maze, row + 1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}

		return false;
	}

	public static ArrayList<Point> getPath2(boolean[][] maze) {
		if (maze == null || maze.length == 0)
			return null;
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		if (getPath2(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
			return path;
		}
		return null;
	}

	public static boolean getPath2(boolean[][] maze, int row, int col, ArrayList<Point> path,
			HashSet<Point> failedPoints) {
		/* If out of bounds or not available, return. */
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}

		Point p = new Point(row, col);

		/* If we've already visited this cell, return. */
		if (failedPoints.contains(p)) {
			return false;
		}

		boolean isAtOrigin = (row == 0) && (col == 0);

		/* If there's a path from the start to my current location, add my location. */
		if (isAtOrigin || getPath2(maze, row, col - 1, path, failedPoints)
				|| getPath2(maze, row - 1, col, path, failedPoints)) {
			path.add(p);
			return true;
		}

		failedPoints.add(p); // Cache result
		return false;
	}

	private static int backtrack(int r, int c, int m, int n) {
		if (r == m - 1 && c == n - 1)
			return 1;
		if (r >= m || c >= n)
			return 0;
		return backtrack(r + 1, c, m, n) + backtrack(r, c + 1, m, n);
	}

	public static int uniquePaths(int m, int n) {
		return backtrack(0, 0, m, n);
	}

	public static boolean[][] randomBooleanMatrix(int M, int N) {
		boolean[][] matrix = new boolean[M][N];
		Random random = new Random();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = random.nextBoolean();

			}
			System.out.println(Arrays.toString(matrix[i]));
		}
		return matrix;
	}

	public static void main(String[] args) {
		int size = 3;
		// boolean[][] maze = randomBooleanMatrix(size, size);
		boolean[][] maze = { { true, true, true }, { false, true, false }, { false, true, true } };

		ArrayList<Point> path = getPath(maze);
		if (path != null) {
			System.out.println(path.toString());
		} else {
			System.out.println("No path found.");
		}

		ArrayList<Point> path1 = getPath1(maze);
		if (path1 != null) {
			System.out.println(path1.toString());
		} else {
			System.out.println("No path found.");
		}

		ArrayList<Point> path2 = getPath1(maze);
		if (path2 != null) {
			System.out.println(path2.toString());
		} else {
			System.out.println("No path found.");
		}
		System.out.println(uniquePaths(3, 3));

	}

}
