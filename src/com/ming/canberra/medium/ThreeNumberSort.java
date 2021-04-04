package com.ming.canberra.medium;

public class ThreeNumberSort {
    public static void main(String[] args) {
        int aa[] = new int[]{3, 4, -6, 7, 8};
        ThreeNumberSort threeNumberSort = new ThreeNumberSort();
        System.out.println (threeNumberSort.threeNumberSort(null, null));
    }

    public int[] threeNumberSort(int[] array, int[] order) {

        if (array ==null || array.length == 1){
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == order[0]){
                continue;
            }
            else{
                int j = i + 1;
                while (j < array.length){
                    if (array[j] == order[0]){
                        break;
                    }
                    else{
                        j++;
                    }
                }
                if (j == array.length){
                    break;
                }
                else{
                    swap(array, i, j);
                }
            }
        }

        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == order[2]){
                continue;
            }
            else{
                int j = i - 1;
                while (j >= 0){
                    if (array[j] == order[2]){
                        break;
                    }
                    else{
                        j--;
                    }
                }
                if (j == -1){
                    break;
                }
                else{
                    swap(array, i, j);
                }
            }
        }

        return array;
    }

    private void swap(int[] array, int first, int second){
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}

