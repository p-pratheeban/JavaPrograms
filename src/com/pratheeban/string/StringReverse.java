package com.pratheeban.string.examples;

public class StringReverse {
	public static String reverseString(String input){
		if(input == null || input ==""){
			return input;
		}
		String reverseStr = new StringBuffer(input).reverse().toString();
		return reverseStr;
	}
	
	public static String reverse(String input) {
		String reverseStr="";
		for(int i=input.length()-1;i>=0;i--) {
			reverseStr+=input.charAt(i);
		}
		return reverseStr;
	}
	
	public static void main(String[] args) {
		String str = "Hellow World";
		System.out.println(reverse(str));
		System.out.println(reverseString(str));

	}
}
