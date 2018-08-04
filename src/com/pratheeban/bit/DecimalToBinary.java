package com.pratheeban.bit;

public class DecimalToBinary {
	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}

		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}

	public static String printBinary1(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		double frac = 0.5;

		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() > 32) {
				return "ERROR";
			}
			if (num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	}
	public static boolean isPower2(int n) {
		return (n&(n-1))==0;
	}
	public static void main(String[] args) {
		double d = 0.625;
		System.out.println(printBinary(d));
		System.out.println(printBinary(.125));
		System.out.println(printBinary1(d));
		System.out.println(printBinary1(.125));
		System.out.println(isPower2(64));
		System.out.println(isPower2(66));


	}
}
