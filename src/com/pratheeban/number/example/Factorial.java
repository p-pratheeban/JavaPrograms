package com.pratheeban.number.example;

import java.math.BigInteger;

class Factorial {

	public static long calculateFactorial(int n) {
		long fact = 1;
		if (n < 0)
			throw new IllegalArgumentException("n must be >= 0");
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

	public static long factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException("n must be >= 0");
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static BigInteger factor(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++)
			fact = fact.multiply(new BigInteger(i + ""));
		return fact;
	}

	public static void main(String args[]) {
		System.out.println(calculateFactorial(0));
		System.out.println(calculateFactorial(6));
		System.out.println(calculateFactorial(25));
		System.out.println(calculateFactorial(26));
		// System.out.println(calculateFactorial(-5));

		System.out.println(factorial(0));
		System.out.println(factorial(6));
		System.out.println(factorial(25));
		System.out.println(factorial(26));

		System.out.println(factor(632));
		System.out.println(factor(1224));
	}
}
