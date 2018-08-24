package com.pratheeban.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Country {
	private String name;
	private int size;
	private String continent;

	public Country(String n, String c, int sz) {
		name = n;
		size = sz;
		continent = c;
	}

	public String getName() {
		return name;
	}

	public String getContinent() {
		return continent;
	}

	public int getPopulation() {
		return size;
	}
}

public class LambdaExpression {
	public static int getPopulation(List<Country> countries, String continent) {
		int sum = 0;
		for (Country c : countries) {
			if (c.getContinent().equals(continent)) {
				sum += c.getPopulation();
			}
		}
		return sum;
	}
	public static int getPopulation1(List<Country> countries, String continent) {
 		Stream<Country> sublist = countries.stream().filter( country -> {
 			return country.getContinent().equals(continent);
 		});
 		
 		Stream<Integer> populations = sublist.map(c -> c.getPopulation());
 		int population = populations.reduce(0, (a, b) -> a + b);
 		return population;
	}
	
	public static int getPopulation2(List<Country> countries, String continent) {
 		Stream<Integer> populations = countries.stream().map(c -> 
 			c.getContinent().equals(continent) ? c.getPopulation() : 0);
 		return populations.reduce(0, (a, b) -> a + b);
	}
	public static void main(String... args) {
		List<Country> countries = new ArrayList<>();
		countries.add(new Country("United States", "North America", 1));
		countries.add(new Country("Canada", "North America", 5));
		countries.add(new Country("India", "Asia", 9));
		countries.add(new Country("India", "Asia", 19));

		System.out.println(getPopulation(countries, "Asia"));
		System.out.println(getPopulation1(countries, "Asia"));
		System.out.println(getPopulation2(countries, "Asia"));


	}
}
