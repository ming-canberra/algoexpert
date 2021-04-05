package com.ming.canberra.medium;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        SearchInSortedMatrix StaircaseTraversal = new SearchInSortedMatrix();

        int[] target = new int[]{44, 1, 2,4,15,12,32,99,100,40,128,106,45,24,43,-1,1000,1004};

        System.out.println(target.length + " @@@@@@@@@@@@@@@@@@@@@@@");

            int[] a = StaircaseTraversal.searchInSortedMatrix(matrix,1000);
            System.out.println (a[0] + " " + a[1]);
            System.out.println ("///////////////");

    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {

        int i = 0;
        int j = 0;

        int iLast = -1;
        int jLast = -1;
        if (target < matrix[0][0]){
            return new int[] {-1, -1};
        }
        while (i >=0 && i< matrix.length && j >=0 && j < matrix[0].length){
            if (matrix[i][j] == target){
                return new int[] {i, j};
            }
            else  if (matrix[i][j] < target){
                if (j + 1 < matrix[0].length && matrix[i][j+1] == target)
                {
                    return new int[]{i, j + 1};
                }
                if (i + 1 < matrix.length && matrix[i + 1][j] == target)
                {
                    return new int[]{i + 1, j};
                }

                if (j + 1 < matrix[0].length && matrix[i][j+1] < target && !(i == iLast && j + 1 == jLast)){
                    iLast = i;
                    jLast = j;
                    j++;
                    continue;
                }
                else if (i + 1 < matrix.length && matrix[i + 1][j] < target && !(i + 1 == iLast && j == jLast)){
                    iLast = i;
                    jLast = j;
                    i++;
                    continue;
                }
                else{
                    if (j - 1 <0){
                        return new int[] {-1, -1};
                    }
                    else{
                        iLast = i;
                        jLast = j;
                        j--;
                        continue;
                    }
                }
            }
        }

        return new int[] {-1, -1};
    }
}

