package com.pratheeban.array;

import java.util.Arrays;

public class Pairs {
	
	static int pairs(int k, int[] arr) {
		
		int n = arr.length;
		int count = 0;
		
		Arrays.sort(arr);		
		int i = 0;
		int j = 1;
		while (j < n) {
			int diff = arr[j] - arr[i];
			if (diff == k) {
				count++;
				i++;
			} else if (diff > k) {
				i++;
			} else {
				j++;
			}
		}
		return count;

	}
	public static void main(String[] args) {
		System.out.println(pairs(2, new int[] {1, 2, 3, 4}));
	}
}
