package com.pratheeban.number;

/**
 * Java Program to print 1 to 100 without using loop
 * 
 * @author Pratheepan
 *
 */
public class PrintNumbers {
	public static void printNumbers(int n) {
		if (n > 1)
			printNumbers(n - 1);
		System.out.print(n+"\t");
	}

	public static void main(String[] args) {
		printNumbers(100);
	}
}
