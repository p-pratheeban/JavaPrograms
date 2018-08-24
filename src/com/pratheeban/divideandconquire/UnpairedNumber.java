package com.pratheeban.divideandconquire;

public class UnpairedNumber {

	public static int getUnpairedNumber(int a[]) {
		for (int i = 0; i < a.length - 1; i += 2) {
			if (a[i] != a[i + 1]) {
				return a[i];
			}
		}
		return a[a.length - 1];
	}

	public static int getUnpairedNumber(int a[], int start, int end) {
		if (start > end)
			return 0;
		if (start == end) {
			return a[start];
		}
		int mid = (start + end) / 2;
		if (mid > 0 && a[mid] != a[mid - 1]) {
			mid = mid - 1;
		}
		if ((mid - start + 1) % 2 == 1) {
			return getUnpairedNumber(a, start, mid);
		} else {
			return getUnpairedNumber(a, mid + 1, end);
		}

	}

	public static void main(String[] args) {
		int a[] = { 2, 2, 3, 4, 4 };
		int b[] = { 2, 2, 3, 3, 4, 4, 5, 5, 6 };
		int c[] = { 1, 2, 2, 3, 3, 4, 4, 5, 5 };
		int d[] = { 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7 };

		System.out.println(getUnpairedNumber(a));
		System.out.println(getUnpairedNumber(a, 0, a.length - 1));

		System.out.println(getUnpairedNumber(b));
		System.out.println(getUnpairedNumber(b, 0, b.length - 1));

		System.out.println(getUnpairedNumber(c));
		System.out.println(getUnpairedNumber(c, 0, c.length - 1));

		System.out.println(getUnpairedNumber(d));
		System.out.println(getUnpairedNumber(d, 0, d.length - 1));

	}
}
