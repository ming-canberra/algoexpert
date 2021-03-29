package com.ming.canberra.easy;

public class RunLengthEncoding {
    public static void main(String[] args) {
        RunLengthEncoding RunLengthEncoding = new RunLengthEncoding();
        String res = RunLengthEncoding.runLengthEncoding("abcz");
        System.out.println(res);
    }

    public String runLengthEncoding(String string) {
        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char currentChar = 0;
        for (int i = 0; i < chars.length; i++){
            if (i == 0){
                currentChar = chars[i];
                count++;
            }
            else{
                if (chars[i] == currentChar){
                    count++;
                }
                else{
                    // append
                    append(sb, count, currentChar);
                    count = 1;
                    currentChar = chars[i];
                }
            }
            if (i == chars.length - 1){
                //append
                append(sb, count, currentChar);
            }
        }
        return sb.toString();
    }

    private void append(StringBuilder sb, int count, char currentChar){
            int countOfNine = count / 9 ;
            int remainder = count % 9;
            for (int i = 1; i <= countOfNine; i++){
                sb.append(9).append(currentChar);
            }
            if (remainder >0){
                sb.append(remainder).append(currentChar);
            }
    }
}
