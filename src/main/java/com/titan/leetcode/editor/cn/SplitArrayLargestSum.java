//[410]分割数组的最大值
//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。 
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], m = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 106 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics 贪心 数组 二分查找 动态规划 
// 👍 508 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;

public class SplitArrayLargestSum{
    public static void main(String[] args) {
       Solution solution = new SplitArrayLargestSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int m) {
            // dp
            return dp(nums, m);
            // 二分，贪心
        }

        private int dp(int[] nums, int m) {
            // dp[i][m] 切到第i个位置，分成m段的最大值
            // dp[i][m] = max(dp[j][m - 1], sum(j + 1, i));
            int n = nums.length;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            int[] sub = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sub[i + 1] = sub[i] + nums[i];
            }

            dp[0][0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= Math.min(i, m); j++) {
                    for (int k = 0; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                    }
                }
            }

            return dp[n][m];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}