//[剑指 Offer II 084]含有重复元素集合的全排列 
//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 
// 👍 2 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SevenP8L0Z{
    public static void main(String[] args) {
       Solution solution = new SevenP8L0Z().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            int length = nums.length;
            Arrays.sort(nums);
            dfs(nums, 0, length, new LinkedList<>(), new boolean[length]);
            return ans;
        }

        private void dfs(int[] nums, int index, int length, LinkedList<Integer> path, boolean[] visited) {
            if (index == length){
                ans.add(new ArrayList<Integer>(path));
                return;
            }

            for (int i = 0; i < length; i++) {
                if (visited[i]){
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false){
                    continue;
                }
                visited[i] = true;
                path.addLast(nums[i]);
                dfs(nums, index + 1, length, path, visited);
                path.removeLast();
                visited[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}