package com.pratheeban.array;

import java.util.Arrays;

public class ArraySum {
	static int simpleArraySum(int[] ar) {
		int sum = Arrays.stream(ar).reduce(0, (x, y) -> x + y);
		return sum;
	}
	public static void main(String[] args) {
		int a[] = {7,8,3,4,51,3};
		System.out.println(simpleArraySum(a));
	}
}
