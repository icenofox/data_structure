package com.martin.app;

public class RotateArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(array, -8);
		Helper.printArray(array);

		int[] array1 = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(array1, 2);
		Helper.printArray(array1);

	}

	// rotate method
	private static void rotate(int[] array, int n) {
		int currIndex = 0;
		int newIndex = 0;
		int backupVal;
		int newVal = array[currIndex];
		int i = 0, arrLen = array.length;
		while (i < arrLen) {
			currIndex = newIndex;

			// compute the new index for current value
			newIndex = (arrLen - (n % arrLen) + currIndex) % arrLen;

			// take backup of new index value
			backupVal = array[newIndex];

			// assign the value to the new index
			array[newIndex] = newVal;

			newVal = backupVal;
			i++;
		}
	}

}
