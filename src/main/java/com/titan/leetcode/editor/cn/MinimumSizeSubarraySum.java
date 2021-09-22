//[209]长度最小的子数组
//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 764 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;

public class MinimumSizeSubarraySum{
    public static void main(String[] args) {
       Solution solution = new MinimumSizeSubarraySum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            // 暴力
            // 滑动窗口
//            return solution1(target, nums);
            // 二分，前缀和
            return solution2(target, nums);
        }

        private int solution2(int target, int[] nums) {
            int length = nums.length;

            int[] sum = new int[length + 1];
            for (int i = 0; i < length; i++) {
                sum[i + 1] += sum[i] + nums[i];
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                int sumValue = target + sum[i];
                int index = Arrays.binarySearch(sum, sumValue);
                if (index < 0){
                    index = -index - 1;
                }
                if (index <= length){
                    ans = Math.min(ans, index - i);
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }

//        private int solution1(int target, int[] nums) {
//            int length = nums.length;
//
//            int start = 0, end = 0;
//            int sum = 0, ans = Integer.MAX_VALUE;
//            while (end < length){
//                sum += nums[end];
//                while (sum >= target){
//                    ans = Math.min(ans, end - start + 1);
//                    sum -= nums[start ++];
//                }
//                end ++;
//            }
//            return ans == Integer.MAX_VALUE ? 0 : ans;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}