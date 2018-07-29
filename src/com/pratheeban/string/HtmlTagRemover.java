package com.pratheeban.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagRemover {
	
	public static String removeHtmlTag(String text){
		if(text == null || text == ""){
			return text;
		}
		text = text.replaceAll("\\<.*?\\>", "");
		return text;
	}
	
	public static String removeHtmlTags(String text){
		if(text == null || text == ""){
			return text;
		}
		Pattern pattern = Pattern.compile("\\<.*?\\>");
		Matcher match = pattern.matcher(text);
		return match.replaceAll("");
	}
	
	public static void main(String[] args) {
		System.out.println(removeHtmlTag("<H1>Hello world</H1>"));
		System.out.println(removeHtmlTags("<H1>Hello world</H1>"));

	}
}
