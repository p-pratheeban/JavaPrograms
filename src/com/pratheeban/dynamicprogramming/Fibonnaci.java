package com.pratheeban.dynamicprogramming;

public class Fibonnaci {
	//bottom up aproach
	static int fibonacci(int n) {
		int fib[] = new int[n + 1];

		if (n == 0 || n == 1)
			return 1;
		for (int i = 0; i < fib.length; i++) {
			if (i == 0)
				fib[0] = 1;
			else if (i == 1)
				fib[1] = 1;
			else
				fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}
	//Top Down
	static int fibnacci(int n, int[] fib) {
		if(n==0||n==1) return 1;
		if(fib[n]!=0) return fib[n];
		return fib[n] =fibnacci(n-1, fib)+fibnacci(n-2, fib);
	}
	
	public static int fibonacci2(int n) {
		return fibonacci(n, new int[n + 1]);
	}
	
	public static int fibonacci(int i, int[] memo) {
		if (i == 0) return 0;
		else if (i == 1) return 1;
		
		if (memo[i] == 0) {
			memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
		}
		return memo[i];
	}
	public static void main(String[] args) {
		System.out.println(fibonacci(10));
		int n = 10;
		int [] fib = new int[n+1];
		System.out.println(fibnacci(n, fib));
		System.out.println(fibonacci2(10));
	}
}
