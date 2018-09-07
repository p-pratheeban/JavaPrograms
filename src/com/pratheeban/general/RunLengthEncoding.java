package com.pratheeban.general;

public class RunLengthEncoding {

	public static String decode(String encodedString) {
		if (encodedString == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		int numIndex = 0;
		int charIndex = numIndex + 1;
		while (charIndex < encodedString.length()) {
			int num = Integer.valueOf(Character.toString(encodedString.charAt(numIndex)));
			for (int i = 0; i < num; i++) {
				sb.append(encodedString.charAt(charIndex));
			}
			numIndex = charIndex + 1;
			charIndex = numIndex + 1;
		}

		return sb.toString();
	}

	public static String decode1(String encodedString) {
		if (encodedString == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		int numIndex = 0;
		int numEndIndex = 1;
		while (numEndIndex < encodedString.length()) {
			while (Character.isDigit(encodedString.charAt(numEndIndex))) {
				numEndIndex++;
			}
			int charIndex = numEndIndex;
			String numString = encodedString.substring(numIndex, numEndIndex);
			int num = Integer.valueOf(numString);
			for (int i = 0; i < num; i++) {
				sb.append(encodedString.charAt(charIndex));
			}
			numIndex = charIndex + 1;
			numEndIndex = numIndex + 1;
		}

		return sb.toString();
	}

	public static String encode(String originalString) {
		if (originalString == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		int currIndex = 0;
		while (currIndex < originalString.length()) {
			char currChar = originalString.charAt(currIndex);

			int num = 0;
			int compareIndex = currIndex;
			while (compareIndex < originalString.length() && currChar == originalString.charAt(compareIndex)) {
				compareIndex++;
				num++;
			}
			sb.append(num);
			sb.append(currChar);

			currIndex = compareIndex;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(String.format("Original string is: %s code is: %s", "aaabbbccc", encode("aaabbbccc")));
		System.out.println(String.format("Original string is: %s code is: %s", "abbccc", decode("3a3b2c")));
		System.out.println(String.format("Original string is: %s code is: %s", "abbccc", decode1 ("3a13b2c")));
		System.out.println(String.format("Original string is: %s code is: %s", "sadasdasdrrrt", decode(encode("sadasdasdrrrt"))));
	}
}
