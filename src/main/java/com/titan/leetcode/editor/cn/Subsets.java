//[78]子集
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1226 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
       Solution solution = new Subsets().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            // 数组中，每个位置或显示或不显示
            List<List<Integer>> list = new ArrayList<>();
//            Arrays.sort(nums);
            dfs(list, new ArrayList<>(), nums, 0);
            return list;

            // 分治？回溯？
        }

        private void dfs(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
            list.add(new ArrayList<>(tempList));
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                dfs(list, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}