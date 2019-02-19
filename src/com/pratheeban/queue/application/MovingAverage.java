package com.pratheeban.queue.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverage {

	public static List<Double> computeMovingAverage(List<Integer> numbers, int k) {
		Queue<Integer> data = new LinkedList<>();
		List<Double> avg = new ArrayList<>();
		double sum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
			data.add(numbers.get(i));
			if (i < k) {
				avg.add(sum / (i + 1));
			}
			else {
				sum-=data.remove();
				avg.add(sum/k);
			}
		}
		return avg;
	}
	
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(3,2,4,5,7,6,8,9);
		System.out.println(computeMovingAverage(a,3));
	}

}
