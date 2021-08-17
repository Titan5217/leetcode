//[41]缺失的第一个正数
//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 哈希表 
// 👍 1170 👎 0

package com.titan.leetcode.editor.cn;
public class FirstMissingPositive{
    public static void main(String[] args) {
       Solution solution = new FirstMissingPositive().new Solution();
        solution.firstMissingPositive(new int[]{3, 4, -1, 1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            // 排序迭代，取最小
            // 哈希？
            // 置换
            return solution1(nums);
        }

        private int solution1(int[] nums) {
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]){
                    // 此处置换顺序不能变
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
            for (int i = 0; i < length; i++) {
                if (i + 1 != nums[i]){
                    return i + 1;
                }
            }
            return length + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}