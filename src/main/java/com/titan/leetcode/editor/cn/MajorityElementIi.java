//[229]求众数 II
//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：[1,1,1,3,3,2,2,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 
// 👍 375 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MajorityElementIi{
    public static void main(String[] args) {
       Solution solution = new MajorityElementIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            Set<Integer> retSet = new HashSet<>();

            // 求大于1/3的，最多只有两项
            int count1 = 0;
            int count2 = 0;
            int value1 = nums[0];
            int value2 = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (value1 == nums[i]){
                    count1 ++;
                    continue;
                }
                if (value2 == nums[i]){
                    count2 ++;
                    continue;
                }

                if (count1 == 0){
                    value1 = nums[i];
                    count1 ++;
                    continue;
                }

                if (count2 == 0){
                    value2 = nums[i];
                    count2 ++;
                    continue;
                }

                count1 --;
                count2 --;
            }

//            retList.add(value1);
//            retList.add(value2);
            count1 = 0;
            count2 = 0;
            for (int num: nums){
                if (num == value1){
                    count1 ++;
                    if (count1 > nums.length/3){
                        retSet.add(value1);
                        count1 = Integer.MIN_VALUE;
                    }
                }
                if (num == value2){
                    count2 ++;
                    if (count2 > nums.length/3){
                        retSet.add(value2);
                        count2 = Integer.MIN_VALUE;
                    }
                }
            }

            return new ArrayList<>(retSet);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}