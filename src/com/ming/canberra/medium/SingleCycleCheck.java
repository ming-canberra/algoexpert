package com.ming.canberra.medium;

public class SingleCycleCheck {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 4, -2, 3, 7, 8, -26};
        System.out.println (SingleCycleCheck.hasSingleCycle(aa));
    }

    public static boolean hasSingleCycle(int[] array) {
        int currentIndex = 0;
        for (int i = 0;i < array.length;i++)
        {
            if (i >0 && currentIndex == 0){
                return false;
            }
            currentIndex = getIndex(currentIndex, array);
        }
        return currentIndex == 0;
    }
    private static int getIndex(int currentIndex, int[] array){
        int temp = currentIndex + array[currentIndex];
        if (temp >=0){
            return temp%array.length;
        }
        else{
            return (temp%array.length + array.length)%array.length;
        }
    }
}

