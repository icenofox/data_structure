package com.martin.app;

/**
 * Created by icenofox on 20/05/15.
 */
public class InsertSort {

	void sort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static void main(String[] args) {

		InsertSort insertSort = new InsertSort();
		int[] array = { 300, 298, 72, 10, 28, 3, 87, 78, 1000 };
		insertSort.sort(array);
		PrintHelper.printArray(array);

	}
}
