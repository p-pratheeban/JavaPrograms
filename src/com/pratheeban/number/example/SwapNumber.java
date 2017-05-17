package com.pratheeban.number.example;
/**
 * Java program to swap two numbers in different ways
 * @author Pratheepan
 *
 */
class SwapNumber {
	// Swap two numbers with using third variable(temp)
	public static void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
		System.out.println("After swap\nx= " + x + " y= " + y);
	}

	// Swap two numbers without using third variable
	public static void swapWithoutTemp(int x, int y) {
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("After swap\nx= " + x + " y= " + y);
	}

	public static void swapNumbers(int x, int y) {
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("After swap\nx= " + x + " y= " + y);
	}

	public static void swapNum(int x, int y) {
		x = x * y;
		y = x / y;
		x = x / y;
		System.out.println("After swap\nx= " + x + " y= " + y);
	}

	public static void main(String args[]) {
		int x = 10;
		int y = 30;
		System.out.println("Before swap\nx= " + x + " y= " + y);
		swapWithoutTemp(x, y);
		System.out.println("\nBefore swap\nx= " + x + " y= " + y);
		swap(x, y);
		System.out.println("\nBefore swap\nx= " + x + " y= " + y);
		swapNumbers(x, y);
		System.out.println("\nBefore swap\nx= " + x + " y= " + y);
		swapNum(x, y);

	}
}
