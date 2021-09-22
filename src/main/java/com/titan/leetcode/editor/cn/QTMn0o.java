//[剑指 Offer II 010]和为 k 的子数组
//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2 : 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// 
// -107 <= k <= 107 
// 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
// Related Topics 数组 哈希表 前缀和 
// 👍 9 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashMap;

public class QTMn0o{
    public static void main(String[] args) {
       Solution solution = new QTMn0o().new Solution();
        solution.subarraySum(new int[]{1,2,3,-1,10,9,-7}, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // 哈希表 前缀和
            int pre_sum = 0;
            int ret = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i : nums) {
                pre_sum += i;
                ret += map.getOrDefault(pre_sum - k, 0);
                map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
            }
            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}