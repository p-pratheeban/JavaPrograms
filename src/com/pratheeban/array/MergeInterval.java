package com.pratheeban.array;

import java.util.ArrayList;
import java.util.List;

class Interval {
	public int start, end;

	public Interval(int s, int e) {
		start = s;
		end = e;
	}

	public String toString() {
		return start + "," + end;
	}
}

public class MergeInterval {
	public static List<Interval> mergeIntervals(List<Interval> in) {
		if (in == null || in.size() == 0) {
			return null;
		}
		List<Interval> solution = new ArrayList<>();
		Interval first = in.get(0);
		solution.add(first);
		int start = in.get(1).start;
		int end = first.end;

		for (Interval inter : in) {
			if (inter.end > end) {
				end = inter.end;
			}
		}
		Interval interval = new Interval(start, end);
		solution.add(interval);
		return solution;
	}

	public static List<Interval> mergeIntervals1(List<Interval> in) {
		if (in == null || in.size() == 0) {
			return null;
		}
		List<Interval> solution = new ArrayList<Interval>();
		Interval last = in.get(0);
		solution.add(last);
		for (int i = 1; i < in.size(); i++) {
			Interval current = in.get(i);
			if (current.start > last.end) {
				solution.add(current);
				last = current;
			} else {
				last.end = Math.max(last.end, current.end);
			}
		}
		return solution;
	}

	public static void main(String[] args) {
		// (1,3), (5,10), (9,31), (12,30)
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 10));
		input.add(new Interval(9, 31));
		input.add(new Interval(12, 30));
		List<Interval> output = mergeIntervals(input);
		System.out.println(output);
		List<Interval> output1 = mergeIntervals1(input);
		System.out.println(output1);

	}
}
