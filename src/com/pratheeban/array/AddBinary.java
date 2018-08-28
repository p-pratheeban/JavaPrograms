package com.pratheeban.array;

/*
 * Calculate the sum of two binary numbers that are given as arrays of characters. Return it as a
string.
 */
public class AddBinary {

	public static String addBinary(char[] num1, char[] num2) {
		int p1 = num1.length - 1;
		int p2 = num2.length - 1;
		int carry = 0;
		String res = "";
		while (p1 >= 0 || p2 >= 0 || carry != 0) {
			int curSum = carry;
			curSum += (p1 >= 0) ? (num1[p1] - '0') : 0;
			curSum += (p2 >= 0) ? (num2[p2] - '0') : 0;
			p1--;
			p2--;
			carry = (curSum >= 2) ? 1 : 0;
			int newDigit = curSum % 2;
			res = newDigit + res;
		}
		return res;
	}

	public static void main(String[] args) {
		String num1 = "001";
		String num2 = "101";
		System.out.println(addBinary(num1.toCharArray(), num2.toCharArray()));
	}
}
