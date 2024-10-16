package com.hei123.solution.backpack;

/**
 * 01背包
 * ij数组，i为原始数组下标，j为bagWeight
 * Dp[i][j]=Math.max(dp[i-1][j],dp[i-i][j-v[i]]+w[i])
 * 循环顺序为
 * 外层 物品数组，内层bagWeight
 *
 * 只用一维数组存储数据的时候，内层循环要倒序循环，避免覆盖之前的数据
 * Dp[j]=max(dp[j],dp[j-weight[i]+value[i]])
 */
public class S01背包 {
}
