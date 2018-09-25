package com.martin.app;

/**
 * Created by icenofox on 20/05/15.
 */
public class InsertSort {


    void insertSort2(int array[]) {

        for (int i = 1; i < array.length - 1; i++) {

            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array[i] >= array[j]) {
                    break;
                }
            }

            if (j == i - 1) {
                continue;
            }

            int tmp = array[i];

            int m;
            for (m = i - 1; m > j; m--) {
                array[m + 1] = array[m];
            }

            array[j + 1] = tmp;
        }

    }

    public void insertSort(int array[]) {


        for (int i = 1; i < array.length - 1; i++) {

            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }

    }


    public static void main(String[] args) {

        InsertSort insertSort = new InsertSort();
        int[] array = {300, 298, 72, 10, 28, 3, 87, 78, 1000};
        insertSort.insertSort(array);
        System.out.print(array.toString());

    }
}
