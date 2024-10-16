package com.hei123.solution;

public class Solution322 {

    //零钱兑换
    public static int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        int length = coins.length;
        result[0] = 0;

        for (int i = 0; i <= amount; i++) {
            int minn = amount + 1;
            for (int j = 0; j < length; j++) {
                //这一次加一个j对应的硬币
                if (coins[j] <= i) {
                    minn = Math.min(minn, result[i - coins[j]] + 1);
                }
            }
            result[i] = minn;
        }
        if (result[amount] > amount) {
            return -1;
        }
        return result[amount];
    }
}
