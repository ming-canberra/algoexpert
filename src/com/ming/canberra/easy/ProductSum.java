package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {
    public static void main(String[] args) {
        int res = ProductSum.productSum(null);


    }

    public static int productSum(List<Object> array) {
        return recursiveFun(array, 1);
    }

    private static int recursiveFun(List<Object> array, int level){
        int sum = 0;
        for (Object ob : array){
            if (ob instanceof Integer){
                sum += (Integer)ob;
            }
            else if (ob instanceof ArrayList){
                sum += (level + 1) * recursiveFun((List<Object>)ob, level + 1);
            }
        }
        return sum;
    }
}
