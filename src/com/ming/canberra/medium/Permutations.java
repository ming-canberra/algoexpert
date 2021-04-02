package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations Permutations = new Permutations();
        List<Integer> i = new ArrayList<Integer>();
        i.add(1);


        Permutations.getPermutations(i);
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        return recursiveFun(new ArrayList<List<Integer>>() , 1, array);
    }

    private static List<List<Integer>> recursiveFun(List<List<Integer>> current , int kth, List<Integer> array)
    {
        if (kth == array.size() + 1){
            return current;
        }
        int currentInt = array.get(kth - 1);

        List<List<Integer>> newOverallContainer = new ArrayList<List<Integer>>();

        if (kth == 1){
            List<Integer> newOne = new ArrayList<Integer>();
            newOne.add(currentInt);
            newOverallContainer.add(newOne);
        }
        else{
            for (int i = 0; i < current.size(); i++){
                List<Integer> toClone = current.get(i);
                for (int j = 0;j < kth; j++){
                    List<Integer> cloned = new ArrayList<Integer>();
                    cloned.addAll(toClone);
                    cloned.add(j, currentInt);
                    newOverallContainer.add(cloned);
                }
            }
        }

        return recursiveFun(newOverallContainer , kth + 1, array);
    }
}

