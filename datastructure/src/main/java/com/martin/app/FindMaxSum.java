package com.martin.app;

import java.util.List;

public class FindMaxSum {

    public int findMaxSum(List<Integer> list) {

        if (null == list || 0 == list.size()) {
            return 0;
        }

        Integer max = list.get(0);
        Integer secondMax = 0;

        for (Integer value : list) {
            if (value > max) {
                max = value;
                secondMax = max;
            }
        }

        return max + secondMax;
    }

}
