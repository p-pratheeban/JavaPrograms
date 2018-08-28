package com.pratheeban.sort;

import java.util.Arrays;

public class SelectionSort {
	private static void swap(int arr[],int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static void selectionSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int indexOfSmallest = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<arr[indexOfSmallest]) {
					indexOfSmallest=j;
				}
			}
			swap(arr,i,indexOfSmallest);
		}

	}
	private static void selectionSort1(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int indexOfLargest = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]>arr[indexOfLargest]) {
					indexOfLargest=j;
				}
			}
			swap(arr,i,indexOfLargest);
		}

	}
	public static void main(String[] args) {
        int[] input = {10, 8, 1, 88, 64, 21, 19, 4, 3, 2};
        selectionSort(input);
        System.out.println(Arrays.toString(input));
        selectionSort1(input);
        System.out.println(Arrays.toString(input));

	}
}
