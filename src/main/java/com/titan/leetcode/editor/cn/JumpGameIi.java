//[45]跳跃游戏 II
//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1073 👎 0

package com.titan.leetcode.editor.cn;
public class JumpGameIi{
    public static void main(String[] args) {
       Solution solution = new JumpGameIi().new Solution();
       solution.jump(new int[]{2,0,0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            // dp
//            return dp(nums);
            // other
            return other(nums);
        }

        private int other(int[] nums) {
            int jumps = 0, curEnd = 0, curFarthest = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                curFarthest = Math.max(curFarthest, i + nums[i]);
                if (i == curEnd) {
                    jumps++;
                    curEnd = curFarthest;
                }
            }
            return jumps;
        }

        private int dp(int[] nums) {
            // dp
            int length = nums.length;

            int[] dp = new int[length];
            dp[length - 1] = 0;
            for (int i = length - 2; i >= 0; i--) {
                dp[i] = Integer.MAX_VALUE - i;
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j < length) {
                        dp[i] = Math.min(dp[i], dp[i + j] + 1);
                    }
                }
            }
            return dp[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}