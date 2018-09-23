package com.pajk.DataStruct;

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

        int newIndex = adjust(array, begin, end);
        subSort(array, begin, newIndex - 1);
        subSort(array, newIndex + 1, end);

    }

    private int adjust2(int array[], int begin, int end) {
        int base = array[begin];
        int i = begin;
        int j = end;

        while (i < j) {
            while (i < j && array[j] >= base) {
                j--;
            }

            if (i < j) {
                array[i] = array[j];
                i++;
            }

            while (i < j && array[i] < base) {
                i++;
            }

            if (i < j) {
                array[j] = array[i];
                j--;
            }

        }

        array[i] = base;
        return i;
    }

    private int adjust(int[] array, int begin, int end) {

        int base = array[begin];
        int i = begin;
        int j = end;



        while (i < j) {

            while (i < j && array[j] >= base) {
                j--;
            }

            if (i < j) {
                array[i] = array[j];
                i++;
            }

            while (i < j && array[i] < base) {
                i++;
            }

            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }

        array[i] = base;
        return i;
    }


}

public class FastSortTest {

    public static void main(String[] args) {
        FastSort fastSort = new FastSort();

        int[] array = {10, 298, 72, 10, 28, 3, 87, 78, 1000};

        fastSort.sort(array);

        System.out.print(array.toString());
    }
}
