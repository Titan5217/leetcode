//[46]全排列
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1495 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
       Solution solution = new Permutations().new Solution();
        solution.solution1(new int[]{1,2,3});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            // 回溯
            return solution1(nums);
        }

        List<List<Integer>> retList;
        List<Integer> path;
        private List<List<Integer>> solution1(int[] nums) {
            retList = new ArrayList<>();
            int length = nums.length;
            if (length == 0){
                return retList;
            }
            path = new ArrayList<>();
            dfs(0, length, nums, path);
            return retList;
        }

        private void dfs(int i, int length, int[] nums, List<Integer> path) {
            if (i == length){
                List<Integer> tmpList = new ArrayList<>(path);
                retList.add(tmpList);
                return;
            }

            for (int j = 0; j < length; j++) {
                if (!path.contains(nums[j])){
                    path.add(nums[j]);
                    dfs(i + 1, length, nums, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}