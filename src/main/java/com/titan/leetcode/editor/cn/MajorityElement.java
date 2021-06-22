//[169]多数元素
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 1030 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;

public class MajorityElement{
    public static void main(String[] args) {
       Solution solution = new MajorityElement().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // 分治

            // 位运算
            int ret = 0;
            for (int i = 0; i < 32; i++) {
                int ones = 0, zeros = 0;
                for (int j = 0; j < nums.length; j++) {
                    if ((nums[j] & (1 << i)) != 0) {
                        ++ones;
                    }
                    else
                        ++zeros;
                }
                if (ones > zeros)
                    ret |= (1 << i);
            }
            return ret;

//            // 最牛逼写法
//            Arrays.sort(nums);
//            return nums[nums.length/2];

//            // 单节点存储
//            int retValue = nums[0];
//            int count = 1;
//            for (int i = 1; i < nums.length; i++) {
//                if (count == 0){
//                    count ++;
//                    retValue = nums[i];
//                } else if (retValue == nums[i]){
//                    count ++;
//                } else {
//                    count --;
//                }
//            }
//            return retValue;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}