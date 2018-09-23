package com.martin.app;

import java.util.Queue;

/**
 * Created by icenofox on 20/05/15.
 */
public class BubbleSort {


    public void sort(int[] array) {

        if (null == array || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }

            }

        }

    }
}


interface Function2<T, U, R> {
    R apply(T t, U u);
}

interface Folder<T, U> {
    U fold(U u, Queue<T> list, Function2<T, U, U> function);
}

class MyFolder<T, U> implements Folder<T, U> {
    public U fold(U u, Queue<T> ts, Function2<T, U, U> function) {
        if (u == null || ts == null || function == null)
            throw new IllegalArgumentException();

        if (ts.isEmpty()) {
            return u;
        }


        U ret = u;
        while (!ts.isEmpty()) {

            ret = function.apply(ts.poll(), ret);

        }

        // The recursive implementation will overflow the stack for
        // any data set of real size, your job is to implement a
        // non-recursive solution
        // return fold(function.apply(ts.poll(), u), ts, function);
        return ret;
    }
}

