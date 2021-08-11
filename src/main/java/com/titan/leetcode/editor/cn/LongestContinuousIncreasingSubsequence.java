//[674]最长连续递增序列
//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。 
//
// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那
//么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 
// 👍 202 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestContinuousIncreasingSubsequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            // 这个递增牛逼了，只要是上升就行，不用每个差都相同
            // 迭代
            return solution1(nums);
            // dp
//            return solution2(nums);
        }

        private int solution1(int[] nums) {
            int length = nums.length;
            int ans = 0;
            int startIndex = 0;
            for (int i = 0; i < length; i++) {
                if (i > 0 && nums[i] <= nums[i - 1]){
                    startIndex = i;
                }
                ans = Math.max(ans, i - startIndex + 1);
            }
            return ans;
        }

        private int solution2(int[] nums) {
            int length = nums.length;
            int[] dp = new int[length];
            Arrays.fill(dp, 1);
            int ans = 1;
            for (int i = 0; i < length - 1; i++) {
                if (nums[i] < nums[i + 1]){
                    dp[i + 1] = dp[i] + 1;
                }
                ans = Math.max(ans, dp[i + 1]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}