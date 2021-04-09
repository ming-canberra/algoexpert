package com.ming.canberra.medium;

import java.util.*;

public class RiverSizes {
    public static void main(String[] args) {
        RiverSizes.riverSizes(new int[][]{new int[]{1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0} });
    }

    /**
     * graph traversal
     * */
    public static List<Integer> riverSizes(int[][] matrix) {
        boolean [][]visited = new boolean[matrix.length][matrix[0].length];

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++){
                if (!visited[i][j])
                {
                    if (matrix[i][j] == 0){
                        visited[i][j] = true;
                        continue;
                    }
                    else{
                        // start counting river size
                        int currentRiverSize = calculateRiverSizeUsingQueue(matrix, visited, i, j);
                        result.add(currentRiverSize);
                    }
                }
            }
        }

        return result;
    }

    /**
     * calculate using queue
     * */
    private static int calculateRiverSizeUsingQueue(int[][] matrix, boolean[][] visited, int i, int j)
    {
        int[] index = new int[]{i, j};
        Queue<int[]> queue = new LinkedList<int[]>();
        int length = 0;
        queue.add(index);
        while (!queue.isEmpty())
        {
            int[] current = queue.poll();
            if (!visited[current[0]][current[1]]){
                visited[current[0]][current[1]] = true;
                if(matrix[current[0]] [current[1]] == 1){
                    length++;
                    // check the neighbors
                    //left
                    int m = current[1] - 1;
                    if (m >= 0 && m < matrix[0].length && !visited[current[0]][m]){
                        queue.add(new int[]{current[0], m});
                    }

                    //right
                    m = current[1] + 1;
                    if (m >= 0 && m < matrix[0].length && !visited[current[0]][m]){
                        queue.add(new int[]{current[0], m});
                    }

                    // up
                    m = current[0] - 1;
                    if (m >= 0 && m < matrix.length && !visited[m][current[1]]){
                        queue.add(new int[]{m, current[1]});
                    }

                    // down
                    m = current[0] + 1;
                    if (m >= 0 && m < matrix.length && !visited[m][current[1]]){
                        queue.add(new int[]{m, current[1]});
                    }
                }
            }
        }

        return length;
    }

        /**
         * iteratively calculate
         * */
    private static int calculateRiverSize(int[][] matrix, boolean[][] visited, int i, int j){
        visited[i][j] = true;
        if (matrix[i][j] == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;

        int m = j - 1;
        if (m >= 0 && m < matrix[0].length && !visited[i][m]){
            left = calculateRiverSize(matrix, visited, i, m);
        }

        m = j + 1;
        if (m >= 0 && m < matrix[0].length && !visited[i][m]){
            right = calculateRiverSize(matrix, visited, i, m);
        }

        m = i - 1;
        if (m >= 0 && m < matrix.length && !visited[m][j]){
            up = calculateRiverSize(matrix, visited, m, j);
        }

        m = i + 1;
        if (m >= 0 && m < matrix.length && !visited[m][j]){
            down = calculateRiverSize(matrix, visited, m, j);
        }

        return 1 + left + right + up + down;
    }

        /**
         * this is nasty
        * */
    public static List<Integer> riverSizes1(int[][] matrix) {
        // Write your code here.
        int riverIndex = 1;
        HashMap<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (i == 0 && j ==0){
                    if (matrix[i][j] == 1){
                        // put new river into map
                        List<int[]> tempList = new ArrayList<int[]>();
                        tempList.add(new int[]{i, j});
                        riverIndex++;
                        map.put(riverIndex, tempList);
                        matrix[i][j] = riverIndex;
                    }
                }
                else{
                    if (matrix[i][j] == 1){
                        if (i == 0){
                            if (matrix[i][j-1] != 0){
                                matrix[i][j] = matrix[i][j-1];
                                map.get(matrix[i][j-1]).add(new int[]{i, j});
                            }
                            else{
                                // put new river into map
                                List<int[]> tempList = new ArrayList<int[]>();
                                tempList.add(new int[]{i, j});
                                riverIndex++;
                                map.put(riverIndex, tempList);
                                matrix[i][j] = riverIndex;
                            }
                        }
                        else if (j == 0){
                            if (matrix[i-1][j] != 0){
                                matrix[i][j] = matrix[i-1][j];
                                map.get(matrix[i-1][j]).add(new int[]{i, j});
                            }
                            else{
                                // put new river into map
                                List<int[]> tempList = new ArrayList<int[]>();
                                tempList.add(new int[]{i, j});
                                riverIndex++;
                                map.put(riverIndex, tempList);
                                matrix[i][j] = riverIndex;
                            }
                        }
                        else if (i != 0 && j != 0){
                            if (matrix[i-1][j] != 0 && matrix[i][j-1] != 0){
                                int a = matrix[i-1][j];
                                int b = matrix[i][j-1];
                                // a != b,always merge b to a
                                if (a != b) {
                                    List<int[]> listA = map.get(a);
                                    List<int[]> listB = map.get(b);
                                    map.remove(b);
                                    for (int[] currentElement : listB){
                                        matrix[currentElement[0]][currentElement[1]] = a;
                                        listA.add(currentElement);
                                    }
                                }
                                map.get(a).add(new int[]{i, j});
                                matrix[i][j] = a;
                            }
                            else if (matrix[i-1][j] != 0 || matrix[i][j-1] != 0){
                                int a = Math.max(matrix[i-1][j], matrix[i][j-1]);
                                map.get(a).add(new int[]{i, j});
                                matrix[i][j] = a;
                            }
                            else{
                                // put new river into map
                                List<int[]> tempList = new ArrayList<int[]>();
                                tempList.add(new int[]{i, j});
                                riverIndex++;
                                map.put(riverIndex, tempList);
                                matrix[i][j] = riverIndex;
                            }
                        }
                    }
                }
            }
        }
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        for (List<int[]> list : map.values()){
            toReturn.add(list.size());
        }
        return toReturn;
    }
}

