package com.pratheeban.array;

import java.util.HashMap;
import java.util.Map;

public class IceCreamParlor {
	
	public static void buyIceCream(int[] costs, int money) {
		Map<Integer, Integer> map = new HashMap<>(); // key = cost, value = ice cream ID
		for (int i = 0; i < costs.length; i++) {
			int icecreamID = i + 1;
			int cost = costs[i];
			/* Find 2 flavors to buy that sum to "money" */
			int otherCost = money - cost;
			if (map.containsKey(otherCost)) {
				System.out.println(map.get(otherCost) + " " + icecreamID);
			}
			map.putIfAbsent(cost, icecreamID);

		}
	}

	public static void main(String[] args) {
		buyIceCream(new int[] { 1, 4, 5, 3, 2 }, 4);
	}
}
