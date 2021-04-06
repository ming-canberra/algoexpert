package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskAssignment {
    public static void main(String[] args) {
        TaskAssignment phoneNumberMnemonics = new TaskAssignment();
        phoneNumberMnemonics.taskAssignment(1, null);
    }
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        int[][] arrays = new int[tasks.size()][2];
        for (int i = 0; i < tasks.size(); i++){
            arrays[i] = new int[]{tasks.get(i), i};
        }
        Arrays.sort(arrays, (a,b)->Integer.compare(a[0], b[0]));
        ArrayList<ArrayList<Integer>> result =  new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < k ; i++){
            ArrayList<Integer> newList = new ArrayList<Integer>();
            newList.add(arrays[i][1]);
            newList.add(arrays[2 * k - 1 - i][1]);
            result.add(newList);
        }
        return result;
    }
}

