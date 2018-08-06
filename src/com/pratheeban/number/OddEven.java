package com.pratheeban.number.example;
/**
 * Check whether given number is odd or even
 * @author Pratheepan
 *
 */
class OddEven {
	/*
	 * isOddEven(n) that accepts non integer number and return Even if the
	 * number is divisible by 2(that means remainder is 0) otherwise return
	 * Odd((that means remainder is 1)
	 */
	public static String isOddEven(int n) {
		if (n < 0)
			return "Invalid Number";
		if (n % 2 == 0) {
			return "Even Number";
		} else {
			return "Odd Number";
		}
	}
	
	/*
	 isOddEven(n) that accepts non integer number and return Even 
	 if the number is divisible by 2(that means remainder is 0,so array index is 0)
	 otherwise return Odd(that means remainder is 1,so array index is 1)
	 */
	 private static String checkOddEven(int n){
	  String[] s={"Even","Odd"};
	  return s[n%2];
	 }

	public static void main(String args[]) {
		System.out.println(isOddEven(23));
		System.out.println(isOddEven(66));
		System.out.println(isOddEven(-23));
		
		System.out.println(checkOddEven(23));
		System.out.println(checkOddEven(66));
	}
}