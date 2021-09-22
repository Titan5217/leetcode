//[剑指 Offer II 083]没有重复元素集合的全排列
//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
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
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 
// 👍 2 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VvJkup{
    public static void main(String[] args) {
       Solution solution = new VvJkup().new Solution();
        solution.permute(new int[]{1,2,3});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            dfs(nums, 0, new LinkedList<Integer>(), new boolean[nums.length]);
            return ans;
        }

        private void dfs(int[] nums, int index, LinkedList path, boolean[] visited) {
            if (index == nums.length){
                ans.add(new ArrayList<>(path));
                return ;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]){
                    visited[i] = true;
                    path.addLast(nums[i]);
                    dfs(nums, index + 1, path, visited);
                    path.removeLast();
                    visited[i] = false;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}