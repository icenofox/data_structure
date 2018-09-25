package com.martin.app;

/**
 * Created by icenofox on 19/05/15.
 */

class FastSort {

	private volatile int haha = 0;

	public void sort(int[] array) {
		if (null == array || array.length == 0) {
			return;
		}

		subSort(array, 0, array.length - 1);
	}

	private void subSort(int[] array, int begin, int end) {

		if (begin >= end) {
			return;
		}

		int newIndex = partition(array, begin, end);
		subSort(array, begin, newIndex - 1);
		subSort(array, newIndex + 1, end);

	}

	private void swap(int[] array, int firstIndex, int secondIndex){
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	private int partition(int[] array, int begin, int end) {
		int lowerIndex = begin - 1;
		int pivot = array[end];

		for (int i = begin; i < end; i++) {
			if (array[i] <= pivot) {
				lowerIndex ++;

				swap(array, lowerIndex, i);
			}
		}

		swap(array, lowerIndex + 1, end);

		return lowerIndex + 1;
	}
}

public class FastSortTest {

	public static void main(String[] args) {
		FastSort fastSort = new FastSort();

		int[] array = { 10, 298, 72, 10, 28, 3, 87, 78, 1000 };

		fastSort.sort(array);

		System.out.print(array.toString());
	}
}
