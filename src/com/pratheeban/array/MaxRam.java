package com.pratheeban.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Triple {

	int startTime, endTime, ramNeeded;

	public Triple(int start, int end, int ram) {
		startTime = start;
		endTime = end;
		ramNeeded = ram;
	}
}

/*
 * Given an array of Triples that represent the the amount of RAM needed for an
 * app and the start and termination times of the app, find the maximum amount
 * of RAM needed.
 */
public class MaxRam {
	public static int maxRamNeeded(List<Triple> in) {
		if (in == null) {
			return Integer.MIN_VALUE;
		}
		Map<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		for (Triple t : in) {
			tm.put(t.startTime, t.ramNeeded);
			tm.put(t.endTime, -t.ramNeeded);
		}
		int curRam = 0, maxRam = 0;
		for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
			curRam += entry.getValue();
			maxRam = Math.max(curRam, maxRam);
		}
		return maxRam;
	}

	public static void main(String[] args) {
		List<Triple> list = new ArrayList<>();
		list.add(new Triple(2, 4, 1));
		list.add(new Triple(3, 6, 2));
		list.add(new Triple(3, 9, 3));
		System.out.println(maxRamNeeded(list));

	}
}
