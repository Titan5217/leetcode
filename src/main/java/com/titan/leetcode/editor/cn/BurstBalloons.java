//[312]戳气球
//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 761 👎 0

package com.titan.leetcode.editor.cn;
public class BurstBalloons{
    public static void main(String[] args) {
       Solution solution = new BurstBalloons().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            // dp
            return dp(nums);
        }

        private int dp(int[] nums) {
            // dp[i][j] i到j的最大值
            // dp[i][j] = Max(v[i]*v[k]*v[j] + dp[i][k] + dp[k][j])
            int length = nums.length;
            int[][] dp = new int[length + 2][length + 2];
            int[] newNum = new int[length + 2];
            newNum[0] = newNum[length + 1] = 1;
            for (int i = 1; i <= length; i++) {
                newNum[i] = nums[i - 1];
            }
            for (int i = length - 1; i >= 0; i--) {
                for (int j = i + 2; j <= length + 1; j++) {
                    for (int k = i + 1; k < j; k++) {
                        int tmpSum = newNum[i] * newNum[k] * newNum[j];
                        tmpSum += dp[i][k] + dp[k][j];
                        dp[i][j] = Math.max(tmpSum, dp[i][j]);
                    }
                }
            }

            return dp[0][length + 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}