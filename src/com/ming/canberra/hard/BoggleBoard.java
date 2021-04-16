package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BoggleBoard {
    public static void main(String[] args) {
        BoggleBoard.boggleBoard(null, null);
    }

    public static List<String> boggleBoard(char[][] board, String[] words) {
        HashMap<Character, List<Integer>> charWordsIndexMap = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < words.length; i++){
            if (charWordsIndexMap.containsKey(words[i].charAt(0))){
                charWordsIndexMap.get(words[i].charAt(0)).add(i);
            }
            else{
                List<Integer> value = new ArrayList<Integer>();
                value.add(i);
                charWordsIndexMap.put(words[i].charAt(0), value);
            }
        }
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (charWordsIndexMap.keySet().contains(board[i][j])){
                    for (Integer wordsIndex : charWordsIndexMap.get(board[i][j])){
                        String stringToFind = words[wordsIndex];
                        if (matchFound(i, j, board, stringToFind)){
                            result.add(stringToFind);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean matchFound(int i, int j, char[][] board, String stringToMatch){
        return true;
    }
}

