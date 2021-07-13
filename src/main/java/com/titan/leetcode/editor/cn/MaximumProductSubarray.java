//[152]乘积最大子数组
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1162 👎 0

package com.titan.leetcode.editor.cn;
public class MaximumProductSubarray{
    public static void main(String[] args) {
       Solution solution = new MaximumProductSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 1){
                return nums[0];
            }
            int preMin = nums[0];
            int preMax = nums[0];
            int max = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                if (num < 0){
                    int tmp = preMax;
                    preMax = preMin;
                    preMin = tmp;
                }
                preMax = Math.max(preMax * num, num);
                preMin = Math.min(preMin * num, num);

                max = Math.max(preMax, max);
            }

            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}