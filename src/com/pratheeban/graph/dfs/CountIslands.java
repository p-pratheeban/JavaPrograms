package com.pratheeban.graph.dfs;

import java.util.Arrays;

class CountIslands {
	public static int getNumberOfIsland(char[][] grid) {
		int numOfIslnads = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 'x') {
					visitIsland(r,c,grid);
					System.out.println(Arrays.deepToString(grid));
					numOfIslnads++;
				}
			}
		}
		return numOfIslnads;
	}

	public static void visitIsland(int r, int c, char[][] grid) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 'x') {
			grid[r][c] = 'm';
			visitIsland(r+1,c,grid);
			visitIsland(r-1, c, grid);
			visitIsland(r, c+1, grid);
			visitIsland(r, c-1, grid);
		}

	}

	public static void main(String args[]) {
		char grid[][] = { { '0', '0', '0', '0', '0', '0' }, { '0', '0', 'x', 'x', '0', '0' },
				{ '0', '0', '0', '0', 'x', '0' }, { '0', '0', '0', '0', '0', 'x' } };
		System.out.println(Arrays.deepToString(grid));
		System.out.println(getNumberOfIsland(grid));

	}
}
