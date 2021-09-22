//[剑指 Offer 63]股票的最大利润
//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 10^5 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-s
//tock/ 
// Related Topics 数组 动态规划 
// 👍 156 👎 0

package com.titan.leetcode.editor.cn;
public class GuPiaoDeZuiDaLiRunLcof{
    public static void main(String[] args) {
       Solution solution = new GuPiaoDeZuiDaLiRunLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
//            return solution1(1, prices);
            return solution2(prices);
        }

        private int solution2(int[] prices) {
            int ans = 0;
            int days = prices.length;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < days; i++) {
                if (minValue > prices[i]){
                    minValue = prices[i];
                } else {
                    ans = Math.max(ans, prices[i] - minValue);
                }
            }
            return ans;
        }

        private int solution1(int times, int[] prices) {
            int days = prices.length;
            if (days < 2){
                return 0;
            }
            if (times > days) {
                times = days;
            }
            // 第几天，是否持有[0未持，1持有],交易次数
            int[][][] dp = new int[days][2][times + 1];
            for (int i = 0; i <= times ; i++) {
                dp[0][0][i] = 0;
                dp[0][1][i] = -prices[0];
            }
            for (int i = 1; i < days; i++) {
                for (int k = 1; k <= times; k++) {
                    dp[i][0][k] = Math.max(dp[i - 1][0][k], dp[i - 1][1][k] + prices[i]);
                    dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k - 1] - prices[i]);
                }
            }
            return dp[days - 1][0][times];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}