package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TounamentWinner {
    public static void main(String[] args) {
        TounamentWinner sortedSquaredArray = new TounamentWinner();
        String res = sortedSquaredArray.tournamentWinner(null, null);

        System.out.println(res);

    }

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < competitions.size(); i++){
            String winningTeam;
            if (results.get(i) == 1){
                winningTeam = competitions.get(i).get(0);
            }
            else{
                winningTeam = competitions.get(i).get(1);
            }
            map.put(winningTeam, map.getOrDefault(winningTeam, 0) + 3);
        }

        String result = null;
        int max = 0;
        for (String team : map.keySet()){
            if (max < map.get(team)){
                max = map.get(team);
                result = team;
            }
        }

        return result;
    }
}
