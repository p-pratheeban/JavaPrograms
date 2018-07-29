package com.pratheeban.string.examples;

import java.util.Arrays;

public class ReplaceForFun {
	public static void replaceFun(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		char[] str1 = new char[newLength];
		//str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str1[newLength - 1] = '0';
				str1[newLength - 2] = '2';
				str1[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str1[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		System.out.println(new String(str));
		System.out.println(new String(str1));
	}
	public static void main(String[] args) {
		String str="Hello Word Java";
		replaceFun(str.toCharArray(), 15);
	}
}
