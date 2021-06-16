//[15]三数之和
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
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
// Related Topics 数组 双指针 
// 👍 3422 👎 0

package com.titan.leetcode.editor.cn;

import java.util.*;

public class ThreeSum{
    public static void main(String[] args) {
       Solution solution = new ThreeSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            //暴力法[超时了]
//            Arrays.sort(nums);
//            Set<List<Integer>> retSet = new HashSet<List<Integer>>();
//
//            int length = nums.length;
//            for (int i = 0; i < length - 2; i++) {
//                for (int j = i + 1; j < length - 1; j++) {
//                    for (int k = j + 1; k < length; k++) {
//                        if (nums[i] + nums[j] + nums[k] == 0){
//                            retSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                        }
//                    }
//                }
//            }
//
//            return new ArrayList(retSet);
            int len = nums.length;
            List<List<Integer>> retList = new ArrayList<List<Integer>>();

            if(nums == null || len < 3){
                return retList;
            }

            Arrays.sort(nums);

            //排序，降维成两数之和法
            for (int i = 0; i < len; i++) {
                if (nums[i] > 0){
                    break;
                }
                int j = i + 1;
                int k = len - 1;
                while (j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0){
                        k --;
                    } else if (sum < 0){
                        j ++;
                    } else {
                        retList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[k] == nums[k -1]){
                            k --;
                        }
                        while (j < k && nums[j] == nums[j + 1]){
                            j ++;
                        }
                    }
                }
            }

            return retList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}