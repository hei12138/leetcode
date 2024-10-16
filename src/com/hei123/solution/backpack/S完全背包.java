package com.hei123.solution.backpack;

/**
 * 完全背包
 * 三层循环，最内层循环为第i个物品取k次
 *
 * 或者用两层循环，直接用这个式子
 * dp[i][j] = max(dp[i-1][j], dp[i][j - v[i]] + w[i])
 * //代表的含义为 放这个物品，实际上这个物品被放多次的话，之前的次数在前面的背包重量中已经计算过一次
 *
 *
 * 完全背包问题可以衍生出组合问题和排列问题
 * 组合时先遍历物品，再遍历背包，这样dp只记录某一结果的某一情况
 * 排列问题是先遍历背包，再遍历物品
 */
public class S完全背包 {
}
