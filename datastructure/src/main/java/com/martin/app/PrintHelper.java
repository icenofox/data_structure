package com.martin.app;

public class PrintHelper {
	/* A utility function to print array of size n*/
	public static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
}
