package com.pratheeban.divideandconquire;

//Implement square root function (sqrt) only with integers.
public class SquareRoot {
	public static int sqrt(int num) {
		int i = 1;
		do {
			i++;
		} while (i * i <= num);
		return i - 1;
	}

	public static int sqrt(int num, int start, int end) {
		if (start >= end) {
			return Math.min(start, end);
		}
		int mid = (start + end) / 2;
		if (mid * mid == num) {
			return mid;
		}
		if (mid * mid > num) {
			return sqrt(num, start, mid - 1);
		} else {
			return sqrt(num, mid + 1, end);
		}

	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(sqrt(n));
		System.out.println(sqrt(n, 1, n));
	}
}
