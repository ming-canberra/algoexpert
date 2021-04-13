package com.ming.canberra.hard;

public class SubarraySort {
    public static void main(String[] args) {
        int[] result = SubarraySort.subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
            System.out.println(result[0] + " " + result[1]);
    }

    public static int[] subarraySort(int[] array) {
        // Write your code here.

        int leftMostIndexSub = 0;
        for (int i = 1; i < array.length; i++){
            if (array[i - 1] > array[i]){
                leftMostIndexSub = i;
                break;
            }
        }
        if (leftMostIndexSub == 0){
            return new int[]{-1, -1};
        }

        int rightMostIndexSub = array.length - 1;
        for (int i = array.length - 2; i >= 0; i--){
            if (array[i + 1] < array[i]){
                rightMostIndexSub = i;
                break;
            }
        }
        if (rightMostIndexSub == array.length - 1){
            return new int[]{-1, -1};
        }

        int minSub = array[leftMostIndexSub];
        int maxSub = array[leftMostIndexSub];
        for (int i = Math.min(leftMostIndexSub - 1,rightMostIndexSub + 1);
             i <= Math.max(leftMostIndexSub - 1,rightMostIndexSub + 1); i++){
            minSub = Math.min(minSub, array[i]);
            maxSub = Math.max(maxSub, array[i]);
        }

        int resultLeftIndex = leftMostIndexSub;
        int resultRightIndex = rightMostIndexSub;

        for (int i = 0; i < leftMostIndexSub; i++){
            if (array[i] > minSub){
                resultLeftIndex = i;
                break;
            }
        }

        for (int i = array.length - 1; i > rightMostIndexSub; i--){
            if (array[i] < maxSub){
                resultRightIndex = i;
                break;
            }
        }

        return new int[] {resultLeftIndex, resultRightIndex};
    }
}

