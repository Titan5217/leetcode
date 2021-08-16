//[34]在排序数组中查找元素的第一个和最后一个位置
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1144 👎 0

package com.titan.leetcode.editor.cn;
public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
       Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        solution.searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            // 二分查找
            return solution1(nums, target);
        }

        private int[] solution1(int[] nums, int target) {
            int length = nums.length;
            int left = 0, right = length - 1;
            int start = -2, end = 0;
            while (left <= right){
                int mid = (left + right) / 2;
                if (nums[mid] < target){
                    left = mid + 1;
                } else if (nums[mid] > target){
                    right = mid - 1;
                } else {
                    start = mid;
                    end = mid;
                    while (start >= 0 && nums[start] == target){
                        start --;
                    }
                    while (end <= length - 1 && nums[end] == target){
                        end ++;
                    }
                    break;
                }
            }

            return new int[]{start + 1, end - 1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}