package com.hei123.solution.leetcode;

/**
 * 加油站
 */
public class S134加油站 {

    public static void main(String[] args) {
        //[1,2,3,4,5], cost = [3,4,5,1,2]
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        S134加油站 s134加油站 = new S134加油站();
        int i = s134加油站.canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    /**
     * 暴力解法
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int reverseGas = 0;
        //从第i个位置开始尝试
        for (int i = 0; i < length; i++) {
            int pos = i;
            reverseGas = 0;
            //到达的加油站的数量
            for (int j = 0; j <= length; j++) {
                if (j == length) {
                    //可以达到
                    return i;
                }
                reverseGas = reverseGas + gas[pos] - cost[pos];
                if (reverseGas < 0) {
                    //无法达到
                    break;
                }
                pos++;
                if (pos > length - 1) {
                    pos = 0;
                }
            }
        }
        return -1;
    }
}
