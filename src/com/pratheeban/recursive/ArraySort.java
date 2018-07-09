package com.pratheeban.recursive;

public class ArraySort {

	public static boolean isSorted(int a[], int index) {
		if (index == 1 || index == 0) {
			return true;
		}
		return (a[index - 1] < a[index - 2] )? false : isSorted(a, index - 1);
	}

	public static void main(String[] args) {
		int a[] = { 4, 5, 6, 9, 10 };
		System.out.println(isSorted(a, a.length));
		int b[] = { 7, 5, 6, 9, 10 };
		System.out.println(isSorted(b, b.length));
	}

}
