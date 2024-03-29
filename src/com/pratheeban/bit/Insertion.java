package com.pratheeban.bit;

public class Insertion {
	public static int updateBits(int n, int m, int i, int j) {
		// Validation
		if (i >= 32 || j < i) {
			return 0;
		}

		/*
		 * Create a mask to clear bits i through j in n /* EXAMPLE: i = 2, j = 4. Result
		 * should be 11100011. (Using 8 bits for this example. This is obviously not
		 * actually 8 bits.)
		 */
		int allOnes = ~0; // allOnes = 11111111

		int left = allOnes << (j + 1); // 1s through position j, then 0s. left = 11100000
		System.out.println(Integer.toBinaryString(left));

		int right = ((1 << i) - 1); // 1�s after position i. right = 00000011
		System.out.println(Integer.toBinaryString(right));

		int mask = left | right; // All 1s, except for 0s between i and j. mask = 11100011
		System.out.println(Integer.toBinaryString(mask));

		/* Clear i through j, then put m in there */
		int n_cleared = n & mask; // Clear bits j through i.
		System.out.println(Integer.toBinaryString(n_cleared));

		int m_shifted = m << i; // Move m into correct position.
		System.out.println(Integer.toBinaryString(m_shifted));

		/* OR them, and we're done! */
		return n_cleared | m_shifted;
	}

	public static void main(String[] args) {
		int a = 103217;
		System.out.println(Integer.toBinaryString(a));

		int b = 13;
		System.out.println(Integer.toBinaryString(b));

		int c = updateBits(a, b, 4, 12);
		System.out.println(Integer.toBinaryString(c));

	}
}
