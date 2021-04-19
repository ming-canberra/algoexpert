package com.ming.canberra.hard;

import java.util.ArrayList;

public class GenerateDivTags {
    public static void main(String[] args) {
        GenerateDivTags generateDivTags = new GenerateDivTags();
        ArrayList<String> result = generateDivTags.generateDivTags(1);
            System.out.println(result);
    }

    public ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<String>();
        recursiveFun(result, "", numberOfTags, numberOfTags);
        return result;
    }
    private static String OPENING = "<div>";
    private static String CLOSING = "</div>";
    private void recursiveFun(ArrayList<String> result, String prefix, int numberOfOpenings, int numberOfClosings){
        if (numberOfOpenings < 0 || numberOfClosings < 0){
            return;
        }
        if (numberOfOpenings == 0 && numberOfClosings == 0){
            result.add(prefix);
            return;
        }
        if (numberOfClosings > 0 || numberOfOpenings > 0) {
            if (numberOfOpenings == numberOfClosings) {
                //opening only
                recursiveFun(result, prefix + OPENING, numberOfOpenings - 1, numberOfClosings);
            }

            if (numberOfOpenings < numberOfClosings) {
                // either is ok
                recursiveFun(result, prefix + OPENING, numberOfOpenings - 1, numberOfClosings);
                recursiveFun(result, prefix + CLOSING, numberOfOpenings , numberOfClosings - 1);
            }

            if (numberOfOpenings > numberOfClosings) {
                // neither
                return;
            }
        }
        return;
    }
}

