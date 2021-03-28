package com.ming.canberra.easy;

public class NthFibonacci {
    public static void main(String[] args) {
        int res = NthFibonacci.getNthFib(2);


    }

    public static int getNthFib(int n) {
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        return (getNthFib(n - 2) + getNthFib(n - 1));
    }
}
