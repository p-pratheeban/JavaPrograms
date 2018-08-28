package com.pratheeban.dynamicprogramming;

public class Power {

	public static long pow1(int a, int b) {
		if (a == 0)
			return 0;
		if (b == 0)
			return 1;
		if (b % 2 == 0) {
			return pow1(a, b / 2) * pow1(a, b / 2);
		} else {
			return pow1(a, (b - 1) / 2) * pow1(a, (b - 1) / 2) * a;
		}
	}

	public static long pow(int a, int b) {
		long[] M = new long[b + 1];
		M[0] = 1;
		M[1] = a;
		return powHelper(a, b, M);
	}

	public static long powHelper(int a, int b, long[] M) {
		if (M[b] == 0) {
			if (b % 2 == 0) {
				M[b] = powHelper(a, b / 2, M) * powHelper(a, b / 2, M);
			} else {
				M[b] = powHelper(a, (b - 1) / 2, M) * powHelper(a, (b - 1) / 2, M) * a;
			}
		}
		return M[b];
	}

	public static void main(String[] args) {
		System.out.println(pow1(2, 5));
		System.out.println(pow(2, 5));

	}

}
