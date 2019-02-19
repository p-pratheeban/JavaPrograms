package com.pratheeban.array;

import java.util.Arrays;

public class Triplets {
	static long triplets(int[] a, int[] b, int[] c) {

		int[] arr = Arrays.stream(a).sorted().distinct().toArray();
		int[] brr = Arrays.stream(b).sorted().distinct().toArray();
		int[] crr = Arrays.stream(c).sorted().distinct().toArray();

		int x, y, z;
		x = y = z = 0;
		long count = 0;
		while (y < brr.length) {
			while (x < arr.length && arr[x] <= brr[y])
				x++;

			while (z < crr.length && crr[z] <= brr[y])
				z++;

			count += x * z;
			y++;
		}
		return count;
	}

	public static void main(String[] args) {
		int a[] = { 3, 5, 7 };
		int b[] = { 3, 6 };
		int c[] = { 4, 6, 9 };
		System.out.println(triplets(a, b, c));
	}
}
