package com.pratheeban.array;

import java.util.Arrays;

public class Machine {
	// Return the minimum time required to
	// produce m items with given machines.
	static int minTime(int[] arr, int n, int m) {

		// Intialise time, items equal to 0.
		int t = 0;

		while (true) {
			int items = 0;

			// Calculating items at each second
			for (int i = 0; i < n; i++)
				items += (t / arr[i]);

			// If items equal to m return time.
			if (items >= m)
				return t;

			t++; // Increment time
		}
	}

	// Return the minimum time required to
	// produce m items with given machine.
	static int minTime1(int[] arr, int n, int m) {
		Arrays.sort(arr);

		return binarySearch(arr, n, m, arr[n - 1] * m);
	}

	// Binary search to find minimum time
	// required to produce M items.
	static int binarySearch(int[] arr, int n, int m, int high)

	{
		int low = 1;

		// Doing binary search to
		// find minimum time.
		while (low < high) {
			// Finding the middle value.
			int mid = (low + high) >> 1;

			// Calculate number of items to
			// be produce in mid sec.
			int itm = findItems(arr, n, mid);

			// If items produce is less than
			// required, set low = mid + 1.
			if (itm < m)
				low = mid + 1;
			else
				high = mid;
		}

		return high;
	}

	// be produced in temp sec.
	static int findItems(int[] arr, int n, int temp) {
		int ans = 0;
		for (int i = 0; i < n; i++)
			ans += (temp / arr[i]);
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int n = arr.length;
		int m = 11;

		System.out.println(minTime(arr, n, m));
		System.out.println(minTime1(arr, n, m));

	}
}
