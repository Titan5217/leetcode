//[18]四数之和
//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] ： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 918 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum{
  public static void main(String[] args) {
       Solution solution = new FourSum().new Solution();
       solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        if (null == nums || nums.length < 4){
            return retList;
        }

        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                break;
            }
            if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target){
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target){
                    continue;
                }
                int start = j + 1, end = length - 1;
                while (start < end){
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum > target){
                        end --;
                    } else if (sum < target){
                        start ++;
                    } else {
                        retList.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]){
                            start ++;
                        }
                        start ++;
                        while (start < end && nums[end] == nums[end - 1]){
                            end --;
                        }
                        end --;
                    }
                }
            }
        }

        return retList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}