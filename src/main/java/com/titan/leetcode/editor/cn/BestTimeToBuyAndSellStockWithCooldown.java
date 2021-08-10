//[309]最佳买卖股票时机含冷冻期
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 数组 动态规划 
// 👍 854 👎 0

package com.titan.leetcode.editor.cn;
public class BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            // dp
            return solution1(prices);
        }

        private int solution1(int[] prices) {
            int days = prices.length;
            if (days < 2){
                return 0;
            }

            // 0无，1买，2冻
            int[][] mom = new int[days][3];
            mom[0][0] = 0;
            mom[0][1] = -prices[0];
            mom[0][2] = 0;
            for (int i = 1; i < days; i++) {
                mom[i][0] = Math.max(mom[i - 1][0], mom[i - 1][2]);
                mom[i][1] = Math.max(mom[i - 1][1], mom[i - 1][0] - prices[i]);
                mom[i][2] = mom[i - 1][1] + prices[i];
            }

            return Math.max(mom[days - 1][0], mom[days - 1][2]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}