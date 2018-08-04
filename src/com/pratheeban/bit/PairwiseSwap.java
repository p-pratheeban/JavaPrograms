package com.pratheeban.bit;

public class PairwiseSwap {
	public static int swapOddEvenBits(int x) {
		return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
	}

	public static void main(String[] args) {
		int a = 234321;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(0xaaaaaaaa));

		System.out.println(Integer.toBinaryString(a & 0xaaaaaaaa));
		System.out.println(Integer.toBinaryString((a & 0xaaaaaaaa)>>>1));
		System.out.println("Result");
		System.out.println(Integer.toBinaryString(swapOddEvenBits(a)));
	}
}
