package com.pratheeban.dynamicprogramming;

import java.util.Arrays;

public class TripleSteps {
	public static int countWays(int n) {
		if(n<0) {
			return 0;
		}else if (n==0) {
			return 1;
		}else {
			return countWays(n-3)+countWays(n-2)+countWays(n-1);
		}
	}
	public static int countWays1(int n) {
		int[] map = new int[n + 1];
		Arrays.fill(map, -1);
		return countWays(n, map);
	}
	
	public static int countWays(int n, int[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
			return memo[n];
		}
	}
	public static void main(String[] args) {
		System.out.println(countWays(4));
		System.out.println(countWays1(4));

	}
}
/*n=7
 * 0-1-2-3-4
 * 0-2-4
 * 0-3-4
 * 0-1-3-4
 * 0-2-3-4
 * 0-1-2-4
 * 0-1-4
 * 
 * n=3
 * 0-1-2-3
 * 0-2-3
 * 0-3
 * 0-1-3
 */
