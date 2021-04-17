package com.ming.canberra.hard;

public class MaximizeExpression {
    public static void main(String[] args) {
        MaximizeExpression maximizeExpression = new MaximizeExpression();
        int res = maximizeExpression.maximizeExpression(null);
        System.out.println(res);
    }

    public int maximizeExpression(int[] array) {
        if (array.length < 4){
            return 0;
        }

        int[] dp1 = new int[array.length];// stores the max value of array before the current index, inclusive
        {
            dp1[0] = array[0];
            for (int i = 1; i < array.length; i++) {
                dp1[i] = Math.max(dp1[i - 1], array[i]);
            }
        }

        int[] dp2 = new int[array.length];// stores the max value of(array[i - 1] - array[i]) for index i, inclusive
        {
            dp2[1] = array[0] - array[1];
            for (int i = 2; i < array.length; i++) {
                dp2[i] = Math.max(dp2[i - 1], dp1[i - 1] - array[i]);
            }
        }

        int[] dp3 = new int[array.length];
        {
            dp3[2] = array[0] - array[1] + array[2];
            for (int i = 3; i < array.length; i++) {
                dp3[i] = Math.max(dp3[i - 1], dp2[i - 1] + array[i]);
            }
        }

        int[] dp4 = new int[array.length];
        {
            dp4[3] = array[0] - array[1] + array[2] - array[3];
            for (int i = 4; i < array.length; i++) {
                dp4[i] = Math.max(dp4[i - 1], dp3[i - 1] - array[i]);
            }
        }

        return dp4[dp4.length - 1];
    }
}
