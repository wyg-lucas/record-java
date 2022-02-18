package com.lucas.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date:   2022/2/17
 * @version V1.0
 */



public class Solution452 {

    public static void main(String[] args) {
        Solution452 solution = new Solution452();
        int[][] points = new int[][]{{2147483646,2147483647},{-2147483646,-2147483645},};
        int ans = solution.findMinArrowShots(points);
        System.out.println(ans);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        //Stream.of(points).forEach((a) -> System.out.println(a[0]));
        int count = 1;
        int len = points.length;
        for (int i = 1; i < len; ++i) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i - 1][1], points[i][0]);
            }
        }
        return count;
    }
}
