package com.pratheeban.array;

/*
 * Given an array of integers of length K where the last element in the array is empty and all the
other values (from 1 to k) are present in the array, find the missing number.
 */
public class MissingNumber {
	public static int missingNumber(int[] arr) {
		if (arr == null) {
			return Integer.MIN_VALUE;
		}
		int sumFrom1toK = arr.length + 1;
		int sumOfArray = 0;
		for (int i = 0; i < arr.length; i++) {
			sumOfArray += arr[i];
			sumFrom1toK += i + 1;
		}
		return sumFrom1toK - sumOfArray;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 5, 1, 3 };
		System.out.println(missingNumber(arr));
	}
}
