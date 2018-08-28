package com.pratheeban.recursive;

public class Factorial {

	public static long factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException("n must be >= 0");
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static int factorialVisualization(int n) {
		System.out.println("Computing Factorial of " + n);
		if (n <= 1) {
			System.out.println("Result of Factorial " + n + " = 1");
			return 1;
		} else {
			int result = factorialVisualization(n - 1);
			System.out.println("Result of Factorial " + n + " = " + (n * result));
			return n * result;
		}
	}

	public static void main(String[] args) {
		System.out.println(factorial(0));
		System.out.println(factorial(6));
		System.out.println(factorial(25));
		System.out.println(factorial(26));
		System.out.println(factorialVisualization(8));


	}

}
