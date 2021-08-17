//[47]全排列 II
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
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
// Related Topics 数组 回溯 
// 👍 773 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationsIi{
    public static void main(String[] args) {
       Solution solution = new PermutationsIi().new Solution();
        solution.permuteUnique(new int[]{1,1,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> retList;
        public List<List<Integer>> permuteUnique(int[] nums) {
            retList = new ArrayList<>();
            int length = nums.length;
            if (length == 0){
                return retList;
            }
            Arrays.sort(nums);

            boolean[] used = new boolean[length];
            List<Integer> path = new ArrayList<>();
            dfs(nums, used, 0, path);

            return retList;
        }

        private void dfs(int[] nums, boolean[] used, int currentIndex, List<Integer> path) {
            if (currentIndex == nums.length){
                retList.add(new ArrayList(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, used, currentIndex + 1, path);
                used[i] = false;
                path.remove(currentIndex);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}