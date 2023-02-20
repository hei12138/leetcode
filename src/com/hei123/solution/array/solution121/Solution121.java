package com.hei123.solution.array.solution121;

public class Solution121 {

    /**
     * 假设在第i天卖出股票的话，最大利润应为在第0->i-1天的价格最低点买入，for循环遍历的同时，可以更新价格最低点
     * 这题也可以用动态规划来解
     * res[i]=Math.max(res[i-1]+(prices[i]-prices[i-1]),0);
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            //计算当天卖出的最大利润
            if ((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int length = prices.length;
        int[] res = new int[length];
        int max=0;
        res[0]=0;
        for (int i=1;i<length;i++){
            if(prices[i]>prices[i-1]){
                res[i]=res[i-1]+(prices[i]-prices[i-1]);
            }else{
                if(res[i-1]<0){
                    res[i]=0;
                }else{
                    res[i]=Math.max(res[i-1]+(prices[i]-prices[i-1]),0);
                }
            }
            max=Math.max(res[i],max);
        }
        return max;
    }
}
