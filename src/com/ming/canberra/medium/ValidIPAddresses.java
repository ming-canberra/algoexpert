package com.ming.canberra.medium;

import java.util.ArrayList;

public class ValidIPAddresses {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        ValidIPAddresses arrayOfProducts = new ValidIPAddresses();
        System.out.println (arrayOfProducts.validIPAddresses(""));
    }
    public ArrayList<String> validIPAddresses(String string) {
        ArrayList <String> result = new ArrayList<String>();
        combine("", string, 0, result);
        return result;
    }

    private void combine(String prefix, String string, int timer, ArrayList <String> result){
        if (timer == 3){
            int length = string.length();
            if (length >=1 && length <=3){
                if (length == 1){
                    result.add(prefix + string);
                }
                else if (length == 2){
                    if (!"0".equals(string.substring(0, 1)) && !"00".equals(string.substring(0, 2)))
                    {
                        result.add(prefix + string);
                    }
                }
                else{
                    if (!"0".equals(string.substring(0, 1))
                            && !"00".equals(string.substring(0, 2))
                            && !"000".equals(string.substring(0, 3))
                            && Integer.parseInt(string.substring(0, 3)) < 256 ){
                        result.add(prefix + string);
                    }
                }
            }
        }
        else{
            if (string.length() >= 2){
                combine(prefix + string.substring(0, 1) + "." , string.substring(1, string.length()), timer + 1, result);
            }
            if (string.length() >= 3 && !"0".equals(string.substring(0, 1))
                    && !"00".equals(string.substring(0, 2)))
            {
                combine(prefix + string.substring(0, 2) + "." , string.substring(2, string.length()), timer + 1, result);
            }
            if (string.length() >= 4 && !"0".equals(string.substring(0, 1))
                    && !"00".equals(string.substring(0, 2))
                    && !"000".equals(string.substring(0, 3))
                    && Integer.parseInt(string.substring(0, 3)) < 256 )
            {
                combine(prefix + string.substring(0, 3) + "." , string.substring(3, string.length()), timer + 1, result);
            }
        }
    }
}

