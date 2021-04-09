package com.ming.canberra.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveIslands {
    public static void main(String[] args) {
        RemoveIslands phoneNumberMnemonics = new RemoveIslands();
        phoneNumberMnemonics.removeIslands(null);
    }

    public int[][] removeIslands(int[][] matrix) {
        for (int i = 1; i < matrix.length - 1; i++){
            for (int j = 1; j < matrix[0].length - 1; j++){
                if (matrix[i][j] == 1){
                    boolean connected = isLandConnected(matrix, i, j);
                    if (!connected){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return matrix;
    }

    private boolean isLandConnected(int[][] matrix, int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{i, j});
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        boolean landConnected = false;
        while (!queue.isEmpty()) {
            int[] currentIndex = queue.poll();
            int m = currentIndex[0];
            int n = currentIndex[1];
            visited[m][n] = true;
            if (m == 0 || n == 0 || m == matrix.length - 1 || n == matrix[0].length - 1) {
                landConnected = true;
                break;
            }
            // LEFT
            if (n - 1 >= 0 && !visited[m][n - 1] && matrix[m][n - 1] == 1) {
                queue.add(new int[]{m, n - 1});
            }
            // RIGHT
            if (n + 1 < matrix[0].length && !visited[m][n + 1] && matrix[m][n + 1] == 1) {
                queue.add(new int[]{m, n + 1});
            }
            //up
            if (m - 1 >= 0 && !visited[m - 1][n] && matrix[m - 1][n] == 1) {
                queue.add(new int[]{m - 1, n});
            }
            //down
            if (m + 1 < matrix.length && !visited[m + 1][n] && matrix[m + 1][n] == 1) {
                queue.add(new int[]{m + 1, n});
            }
        }
        return landConnected;
    }

}

