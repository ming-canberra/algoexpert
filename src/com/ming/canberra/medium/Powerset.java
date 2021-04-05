package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Powerset {
    public static void main(String[] args) {
        Powerset phoneNumberMnemonics = new Powerset();
        Powerset.powerset(null);
    }
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if (array.size() == 0){
            return result;
        }
        return fun(array, 0, result);
    }

    private static List<List<Integer>> fun(List<Integer> array, int index, List<List<Integer>> lastResult){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> itemLastResult : lastResult){
            List<Integer> newList = new ArrayList<Integer>();
            newList.addAll(itemLastResult);
            result.add(newList);
        }

        for (List<Integer> itemLastResult : lastResult){
            itemLastResult.add(array.get(index));
            result.add(itemLastResult);
        }
        if (index == array.size() - 1){
            return result;
        }
        else{
            return fun(array, index + 1, result);
        }
    }
}

