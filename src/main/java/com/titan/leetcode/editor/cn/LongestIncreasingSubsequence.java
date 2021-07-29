//[300]最长递增子序列
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 1739 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
       Solution solution = new LongestIncreasingSubsequence().new Solution();
        solution.lengthOfLIS(new int[]{7,7,7,7,7});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            // 暴力循环
            // DP
//            return dp(nums);
            // 二分，贪心
            // 偷懒，不记所有长度，只记变更
            return erfen(nums);
        }

        private int erfen(int[] nums) {
            int length = nums.length;
            List<Integer> tmpList = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                int left = 0;
                int right = tmpList.size();
                while (left < right){
                    int mid = left + right >> 1;
                    if (tmpList.get(mid) >= nums[i]){
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                if (left == tmpList.size()){
                    tmpList.add(nums[i]);
                } else {
                    tmpList.set(left, nums[i]);
                }
            }

            return tmpList.size();
        }

        private int dp(int[] nums) {
            int length = nums.length;
            int[] dp = new int[length];
            dp[0] = 1;

            int maxLength = 1;
            for (int i = 1; i < length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                maxLength = Math.max(dp[i], maxLength);
            }

            return maxLength;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}