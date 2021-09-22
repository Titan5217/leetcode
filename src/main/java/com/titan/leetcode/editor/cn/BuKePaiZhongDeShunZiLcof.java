//[剑指 Offer 61]扑克牌中的顺子
//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 
// 👍 160 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
//            return solution1(nums);
            return solution2(nums);
        }

        private boolean solution2(int[] nums) {
            int jokerCount = 0;
            Arrays.sort(nums);
            for (int i = 0; i < 4; i++) {
                if (nums[i] == 0){
                    jokerCount ++;
                } else if (nums[i] == nums[i + 1]){
                    return false;
                }
            }
            return nums[4] - nums[jokerCount] < 5;
        }

        private boolean solution1(int[] nums) {
            Set<Integer> tmpSet = new HashSet<>();
            int min = 14, max = 0;
            for (int num : nums) {
                if (num == 0){
                    continue;
                }
                if (tmpSet.contains(num)){
                    return false;
                }
                tmpSet.add(num);
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            return max - min < 5;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}