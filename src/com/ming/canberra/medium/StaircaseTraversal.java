package com.ming.canberra.medium;

public class StaircaseTraversal {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        StaircaseTraversal StaircaseTraversal = new StaircaseTraversal();
        System.out.println (StaircaseTraversal.staircaseTraversal(4,2));
    }

    public int staircaseTraversal(int height, int maxSteps) {
        int[] previousSteps = new int[maxSteps];
        previousSteps[0] = 1;
        int sum = previousSteps[0];
        for (int j = 1; j < maxSteps; j++){
            previousSteps[j] = sum + 1;
            sum = sum + previousSteps[j];
        }

        for (int i = maxSteps + 1; i <= height; i++){
            int temp = 0;
            for (int j = 0; j < maxSteps; j++){
                temp+=previousSteps[j];
            }
            for (int j = 0; j < maxSteps -1; j++) {
                previousSteps[j] = previousSteps [j + 1];
            }
            previousSteps[maxSteps -1] = temp;
        }

        return previousSteps[maxSteps - 1];
    }
}

