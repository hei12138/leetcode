package com.hei123.solution.array.solution1779;

public class Solution1779 {

    public static void main(String[] args) {

    }

    public static int nearestValidPoint(int x, int y, int[][] points) {
        int maxDestince = Integer.MAX_VALUE;
        int result = -1;

        //返回下标
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int pointx = point[0];
            int pointy = point[1];
            if (x == pointx) {
                //计算举例
                int destince = Math.abs(pointy - y);
                if (destince < maxDestince) {
                    maxDestince = destince;
                    result = i;
                }
            }
            if (y == pointy) {
                //计算陆离
                int destince = Math.abs(pointx - x);
                if (destince < maxDestince) {
                    maxDestince = destince;
                    result = i;
                }
            }
        }
        return result;
    }
}
