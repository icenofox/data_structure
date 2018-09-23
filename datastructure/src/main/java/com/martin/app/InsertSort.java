package com.pajk.DataStruct;

/**
 * Created by icenofox on 20/05/15.
 */
public class InsertSort {

    public void sort(int array[]) {
        if (null == array || array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] <= array[i]) {
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
            array[m + 1] = tmp;
        }
    }

    void insertSort2(int array[]){

        for (int i = 1; i < array.length - 1; i++){

            int j;
            for (j = i - 1; j >=0 ; j--){
                if (array[i] >= array[j]){
                    break;
                }
            }

            if (j == i - 1){
                continue;
            }

            int tmp = array[i];

            int m;
            for (m = i - 1; m > j; m--){
                array[m + 1] = array[m];
            }

            array[j + 1] = tmp;
        }

    }


    public static void main(String[] args) {

        InsertSort insertSort = new InsertSort();
        int[] array = {300, 298, 72, 10, 28, 3, 87, 78, 1000};
        insertSort.insertSort2(array);
        System.out.print(array.toString());

    }
}
