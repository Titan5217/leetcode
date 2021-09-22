//[713]乘积小于K的子数组
//给定一个正整数数组 nums和整数 k 。 
//
// 请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 104 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 106 
// 
// Related Topics 数组 滑动窗口 
// 👍 290 👎 0

package com.titan.leetcode.editor.cn;
public class SubarrayProductLessThanK{
    public static void main(String[] args) {
       Solution solution = new SubarrayProductLessThanK().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k <= 1) return 0;
            int length = nums.length;
            int left = 0, ans = 0, mulValue = 1;
            for (int right = 0; right < length; right++) {
                mulValue *= nums[right];
                while (mulValue >= k){
                    mulValue /= nums[left ++];
                }
                ans += right - left + 1;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}