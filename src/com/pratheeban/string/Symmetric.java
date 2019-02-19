package com.pratheeban.string;

import java.util.HashMap;
import java.util.Map;

public class Symmetric {
	Map<Character, Character> map = new HashMap<>();
	{
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');

	}

	public boolean isRotationalSymmetric(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		int i = 0;
		int j = str.length() - 1;
		while (i <= j) {
			if (map.get(str.charAt(i)) == null || map.get(str.charAt(i)) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	public static void main(String[] args) {
		Symmetric s = new Symmetric();
		System.out.println(s.isRotationalSymmetric("0880"));
	}
}
