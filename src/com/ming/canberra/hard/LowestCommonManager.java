package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {
    public static void main(String[] args) {

    }

    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        TreeInfo node = recursiveFun(topManager, reportOne, reportTwo);
        return node.lcm;
    }

    private static TreeInfo recursiveFun(OrgChart root, OrgChart node1, OrgChart node2){
        if (root == null){
            return null;
        }
        else{
            int childrenNumReports = 0;
            for (OrgChart child : root.directReports){
                TreeInfo childTreeInfo = recursiveFun(child, node1, node2);
                if (childTreeInfo != null){
                    if (childTreeInfo.numReportsFound == 2){
                        return childTreeInfo;
                    }
                    childrenNumReports += childTreeInfo.numReportsFound;
                    if (childrenNumReports == 2){
                        return new TreeInfo(root, 2);
                    }
                }
            }
            int myNumReports = root == node1 || root == node2? 1 : 0;
            if (myNumReports == 1 && childrenNumReports == 1){
                return new TreeInfo(root, 2);
            }
            else{
                return new TreeInfo(null, myNumReports + childrenNumReports);
            }
        }
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    static class TreeInfo{
        public OrgChart lcm = null;
        public Integer numReportsFound = 0;
        TreeInfo(OrgChart treeNode, int num){
            lcm = treeNode;
            numReportsFound = num;
        }
    }
}

