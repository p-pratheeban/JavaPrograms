package com.pratheeban.dynamicprogramming;

import java.util.Arrays;

public class Knapsack01 {
	public int bottomUpDP(int val[], int wt[], int W) {
		int K[][] = new int[val.length + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (int i = 0; i <= val.length; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
			System.out.println(Arrays.toString(K[i]));
		}
		return K[val.length][W];
	}

	static int knapSack(int W, int wt[], int val[], int n) {
		// Base Case
		if (n == 0 || W == 0)
			return 0;

		// If weight of the nth item is more than Knapsack capacity W, then
		// this item cannot be included in the optimal solution
		if (wt[n - 1] > W)
			return knapSack(W, wt, val, n - 1);

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		else
			return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
	}

	public static void main(String args[]) {
		Knapsack01 k = new Knapsack01();
		int val[] = { 22, 20, 15, 30, 24, 54, 21, 32, 18, 25 };
		int wt[] = { 4, 2, 3, 5, 5, 6, 9, 7, 8, 10 };
		int r = k.bottomUpDP(val, wt, 30);
		System.out.println(r);
		int r1 = k.knapSack(30, wt, val, val.length);
		System.out.println(r1);

	}

}
