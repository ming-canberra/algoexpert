package com.ming.canberra.hard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiscStacking {
    public static void main(String[] args) {

        List<Integer[]> input = new ArrayList<Integer[]>();
        input.add(new Integer[] {2, 1, 2});
        input.add(new Integer[] {3, 2, 3});
        input.add(new Integer[] {2, 2, 8});
        input.add(new Integer[] {2, 3, 4});
        input.add(new Integer[] {2, 2, 1});
        input.add(new Integer[] {4, 4, 5});

        List<Integer[]> result = DiscStacking.diskStacking(input);
        System.out.println(result);
    }
    private final static int NO_MORE_DISK_ON_TOP = -1;
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // first element stores the max height of plates where the index disk is at the bottom
        // second element is a link, pointing to the disk right on top of the current disk. -1 if it is there is none.
        int[][]dp = new int[disks.size()][2];

        Collections.sort(disks, (a,b)->a[2] - b[2]);

        dp[0] = new int[]{disks.get(0)[2], NO_MORE_DISK_ON_TOP};
        int bottomDiskIndex = 0;
        int overallHeight = 0;
        for (int i = 1; i < disks.size(); i++){
            int maxHeightIndex = NO_MORE_DISK_ON_TOP;
            int maxHeight = 0;
            for (int j = 0; j < i; j++){
                if (disks.get(i)[0] > disks.get(j)[0] &&
                        disks.get(i)[1] > disks.get(j)[1] &&
                        disks.get(i)[2] > disks.get(j)[2]){
                    if (dp[j][0] > maxHeight){
                        maxHeight = dp[j][0];
                        maxHeightIndex = j;
                    }
                }
            }
            dp[i] = new int[]{maxHeight + disks.get(i)[2], maxHeightIndex};
            if (dp[i][0] > overallHeight){
                overallHeight = dp[i][0];
                bottomDiskIndex = i;
            }
        }
        List<Integer[]> result = new ArrayList<Integer[]>();
        while (bottomDiskIndex != NO_MORE_DISK_ON_TOP){
            result.add(0, disks.get(bottomDiskIndex));
            bottomDiskIndex = dp[bottomDiskIndex][1];
        }
        return result;
    }
}

