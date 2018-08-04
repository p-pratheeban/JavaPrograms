package com.pratheeban.bit;

public class BitFlip {
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		for (int c = a ^ b; c != 0; c = c >>> 1) {
			System.out.println(Integer.toBinaryString(c));

			count += c & 1;
		}
		return count;
	}

	public static int bitSwapRequired1(int a, int b) {
		int count = 0;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			System.out.println(Integer.toBinaryString(c));

			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		//System.out.println(bitSwapRequired(29, 15));
		System.out.println(bitSwapRequired1(29, 15));

	}
}
