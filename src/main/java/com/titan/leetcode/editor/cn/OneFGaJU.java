//[剑指 Offer II 007]数组中和为 0 的三个数
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 
//不重复 的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
// Related Topics 数组 双指针 排序 
// 👍 4 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OneFGaJU{
    public static void main(String[] args) {
       Solution solution = new OneFGaJU().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int len = nums.length;
            List<List<Integer>> retList = new ArrayList<List<Integer>>();
            if(nums == null || len < 3){
                return retList;
            }

            Arrays.sort(nums);

            for (int i = 0; i < len - 2; i++) {
                if (nums[i] > 0){
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }

                int j = i + 1, k = len - 1;
                while (j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0){
                        while (j < k && nums[k] == nums[--k]);
                    } else if (sum < 0){
                        while (j < k && nums[j] == nums[++j]);
                    } else {
                        retList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[k] == nums[--k]);
                        while (j < k && nums[j] == nums[++j]);
                    }
                }
            }
            return retList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}