//[剑指 Offer 39]数组中出现次数超过一半的数字
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 196 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof{
    public static void main(String[] args) {
       Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // 哈希记录
//            // 排序，取中位数
//            Arrays.sort(nums);
//            return nums[nums.length / 2];

            // 记录个数与值
            int ans = nums[0];
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == 0){
                    ans = nums[i];
                    count ++;
                } else if (ans == nums[i]){
                    count ++;
                } else {
                    count --;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}