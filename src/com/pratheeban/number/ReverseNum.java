package com.pratheeban.number;

public class ReverseNum {
	public static int revInt(int x) {
		boolean negative = false;
		if (x < 0) {
			x = x * -1;
			negative = true;
		}
		int res = 0;
		while (x > 0) {
			int mod = x % 10;
			x = x / 10;
			res = res * 10 + mod;
		}
		if (negative == true) {
			res = res * -1;
		}
		return res;
	}

	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return rev;
	}

	public static void main(String[] args) {
		System.out.println(revInt(123));
		System.out.println(revInt(-123));
		System.out.println(reverse(123));
		System.out.println(reverse(-123));

	}
}
