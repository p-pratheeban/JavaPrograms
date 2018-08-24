package com.pratheeban.heap;

import java.util.Arrays;

public class MinHeap {

	private int size;
	private int capacity;
	private int items[];

	public MinHeap() {
		capacity = 10;
		size = 0;
		items = new int[capacity];
	}

	private int getLeftIndex(int index) {
		return 2 * index + 1;
	}

	private int getRightIndex(int index) {
		return 2 * index + 2;
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[getLeftIndex(index)];
	}

	private int rightChild(int index) {
		return items[getRightIndex(index)];
	}

	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	private void changeLength() {
		if (size == capacity) {
			Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	public int peek() {
		if (size == 0)
			throw new IllegalStateException();
		return items[0];
	}

	public int poll() {
		if (size == 0)
			throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		items[size - 1] = 0;
		size--;
		heapifyDown();
		return item;
	}

	public void add(int item) {
		changeLength();
		items[size] = item;
		size++;
		heapifyUp();
	}

	public int size() {
		return size;
	}

	public void displayHeap() {
		System.out.println(Arrays.toString(items));
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerIndex = getLeftIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerIndex = getRightIndex(index);
			}
			if (items[index] < items[smallerIndex]) {
				break;
			} else {
				swap(index, smallerIndex);
			}
			index = smallerIndex;
		}
	}

	private void swap(int i, int j) {
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	public static void main(String[] args) {
		MinHeap heap = new MinHeap();
		heap.add(10);
		heap.add(15);
		heap.add(20);
		heap.add(17);
		heap.displayHeap();
		heap.add(8);
		heap.displayHeap();
		heap.poll();
		heap.displayHeap();
		System.out.println(heap.size());
	}
}
