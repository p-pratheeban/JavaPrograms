package com.pratheeban.string.examples;

public class StringReverse {
	public static String reverseString(String input){
		if(input == null || input ==""){
			return input;
		}
		String reverseStr = new StringBuffer(input).reverse().toString();
		return reverseStr;
	}
}
