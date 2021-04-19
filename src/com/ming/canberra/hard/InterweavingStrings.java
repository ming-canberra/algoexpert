package com.ming.canberra.hard;

public class InterweavingStrings {
    public static void main(String[] args) {
        String one = "algoexpert";
        String two = "your-dream-job";
        String three = "your-algodream-expertjob";
        System.out.println(InterweavingStrings.interweavingStrings(one, two, three));
    }

    public static boolean interweavingStrings(String one, String two, String three) {
        if (one.length() + two.length() != three.length())
        {
            return false;
        }
        if (one.length() == 0 && two.length() == 0 && three.length() == 0){
            return true;
        }
        if (one.length() == 0){
            if  (two.charAt(0) != three.charAt(0)){
                return false;
            }
            else{
                return interweavingStrings(one, two.substring(1, two.length()), three.substring(1, three.length()));
            }
        }
        if (two.length() == 0){
            if  (one.charAt(0) != three.charAt(0)){
                return false;
            }
            else{
                return interweavingStrings(one.substring(1, one.length()), two, three.substring(1, three.length()));
            }
        }
        if (one.length() != 0 && two.length() != 0
                && one.charAt(0) != three.charAt(0)
                && two.charAt(0) != three.charAt(0)){
            return false;
        }
        if (one.charAt(0) == three.charAt(0) && two.charAt(0) == three.charAt(0)){
            return interweavingStrings(one.substring(1, one.length()), two, three.substring(1, three.length()))
                    || interweavingStrings(one, two.substring(1, two.length()), three.substring(1, three.length()));
        }
        else if (one.charAt(0) == three.charAt(0)){
            return interweavingStrings(one.substring(1, one.length()), two, three.substring(1, three.length()));
        }
        else if (two.charAt(0) == three.charAt(0)){
            return interweavingStrings(one, two.substring(1, two.length()), three.substring(1, three.length()));
        }

        return false;
    }



}

