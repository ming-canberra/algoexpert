package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int aa[] = new int[]{1,2,4,5,6};
        List<Integer> input = new ArrayList<>();
        for (int n : aa){
            input.add(n);
        }
        MergeOverlappingIntervals MergeOverlappingIntervals = new MergeOverlappingIntervals();
        MergeOverlappingIntervals.mergeOverlappingIntervals(null);
    }

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));

        int[] currentInterval = null;

        List<int[]> resultList = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++){
            if (i == 0){
                currentInterval = new int[]{intervals[0][0], intervals[0][1]};
            }
            else {
                if (currentInterval[1] < intervals[i][0]) {
                    resultList.add(currentInterval);
                    currentInterval = intervals[i];
                } else {
                    currentInterval = new int[]{currentInterval[0], Math.max(currentInterval[1], intervals[i][1])};
                }
            }

            if (i == intervals.length - 1){
                resultList.add(currentInterval);
            }
        }

        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++)
        {
            result[i] = resultList.get(i);
        }

        return result;
    }
}

