//[322]零钱兑换
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1356 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CoinChange{
    public static void main(String[] args) {
       Solution solution = new CoinChange().new Solution();
        solution.coinChange(new int[]{1,2,5}, 11);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> tmpMap = new HashMap<>();
        public int coinChange(int[] coins, int amount) {
            // 暴力
            // [超时]递归， 需要将coins倒序排列
//            return dfs(coins, amount, 0);
            // DP， dp[i]:存储amount对应的最小组合个数； dp[i] = min(dp[i], dp[j in (1~n)] + 1)
            return dp(coins, amount);

        }

        private int dp(int[] coins, int amount) {
            int dp[] = new int[amount + 1];
            for (int i = 0; i <= amount; i++) {
                dp[i] = amount + 1;
            }

            dp[0] = 0;
            
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i >= coin){
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }

            return dp[amount] > amount ? -1 : dp[amount];
        }

        private int dfs(int[] coins, int amount, int depth) {
            if (0 == amount){
                return depth;
            }
            if (0 > amount){
                return -1;
            }

            if (tmpMap.containsKey(amount)){
                return tmpMap.get(amount);
            }

            int value = -1;
            for (int coin : coins) {
                int dfsValue = dfs(coins, amount - coin, depth + 1);

                if (dfsValue > 0){
                    value = value == -1 ? dfsValue : Math.min(dfsValue, value);

                }
            }

            tmpMap.put(amount, value);
            return value;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}