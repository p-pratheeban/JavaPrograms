package com.pratheeban.recursive;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) { // Base case - add empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

	public static void populateSubsets(List<List<Integer>> subsetList, List<Integer> numberList) {
		if (numberList.isEmpty()) {
			subsetList.add(new ArrayList<>());
			return;
		}

		int currentNum = numberList.get(0);
		numberList.remove(0);

		populateSubsets(subsetList, numberList);

		List<List<Integer>> iteratingList = new ArrayList<>();
		iteratingList.addAll(subsetList);
		for (List<Integer> subset : iteratingList) {
			List<Integer> newSubset = new ArrayList<>();

			newSubset.addAll(subset);
			newSubset.add(currentNum);

			subsetList.add(newSubset);
		}
	}

	static ArrayList<ArrayList<Integer>> printPowerSet(List<Integer> set, int set_size) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();

		/*
		 * set_size of power set of a set with set_size n is (2**n -1)
		 */
		long pow_set_size = (long) Math.pow(2, set_size);
		int counter, j;

		/*
		 * Run from counter 000..0 to 111..1
		 */
		for (counter = 0; counter < pow_set_size; counter++) {
			ArrayList<Integer> subset = new ArrayList<Integer>();

			for (j = 0; j < set_size; j++) {
				/*
				 * Check if jth bit in the counter is set If set then pront jth element from set
				 */

				if ((counter & (1 << j)) > 0)
					subset.add(set.get(j));
			}
			allsubsets.add(subset);

		}
		return allsubsets;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
		System.out.println(subsets.toString());

		ArrayList<ArrayList<Integer>> subsets1 = printPowerSet(list, list.size());
		System.out.println(subsets1.toString());

		List<Integer> numberList = new ArrayList<>();
		numberList.add(1);
		numberList.add(2);
		numberList.add(3);
		numberList.add(4);

		List<List<Integer>> subsetList = new ArrayList<>();
		populateSubsets(subsetList, numberList);
		System.out.println(subsetList.toString());

	}
}
