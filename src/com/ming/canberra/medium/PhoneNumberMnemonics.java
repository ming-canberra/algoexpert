package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberMnemonics {
    public static void main(String[] args) {
        PhoneNumberMnemonics phoneNumberMnemonics = new PhoneNumberMnemonics();
        ArrayList<String> result = phoneNumberMnemonics.phoneNumberMnemonics("1905");
        for (String s : result){
            System.out.println(s);
        }
    }
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<String>();
        fun(phoneNumber, "", result);
        return result;
    }

    private void fun(String phoneNumber, String prefix, ArrayList<String> result){
        if ("".equals(phoneNumber)){
            if (!"".equals(prefix))
            {
                result.add(prefix);
            }
        }
        else{
            String current = phoneNumber.substring(0, 1);

            HashMap<String, String[]> map = new HashMap<String, String[]>();
            map.put("0", new String[]{"0"});
            map.put("1", new String[]{"1"});
            map.put("2", new String[]{"a","b","c"});
            map.put("3", new String[]{"d","e","f"});
            map.put("4", new String[]{"g","h","i"});
            map.put("5", new String[]{"j","k","l"});
            map.put("6", new String[]{"m","n","o"});
            map.put("7", new String[]{"p","q","r","s"});
            map.put("8", new String[]{"t","u","v"});
            map.put("9", new String[]{"w","x","y","z"});

            for (String s : map.get(current)){
                fun(phoneNumber.substring(1, phoneNumber.length()), prefix + s, result);
            }
        }
    }
}

