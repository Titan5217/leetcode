//[39]组合总和
//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1472 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum{
    public static void main(String[] args) {
       Solution solution = new CombinationSum().new Solution();
        solution.combinationSum(new int[]{2,3,6,7}, 7);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            // 硬币组合 dp
            // dfs
            return solution1(candidates, target);

        }

        List<List<Integer>> retList = new ArrayList<>();
        private List<List<Integer>> solution1(int[] candidates, int target) {
            dfs(candidates, target, new ArrayList<>(), 0);
            return retList;
        }

        private void dfs(int[] candidates, int target, List<Integer> path, int index) {
            if (index == candidates.length){
                return;
            }
            if (target == 0){
                retList.add(new ArrayList<>(path));
                return;
            }

            dfs(candidates, target, path, index + 1);

            if (candidates[index] <= target){
                path.add(candidates[index]);
                dfs(candidates, target - candidates[index], path, index);
                path.remove(path.size() - 1);
            }
        }

//        private List<List<Integer>> solution1(int[] candidates, int target) {
//            List<String>[] dp = new ArrayList[target + 1];
//            for (int i = 0; i <= target; i++) {
//                dp[i] = new ArrayList<>();
//            }
//            for (int i = 1; i <= target ; i++) {
//                for (int candidate : candidates) {
//                    if (i == candidate){
//                        List<Integer> tmpList = new ArrayList<>();
//                        tmpList.add(candidate);
//                        dp[i].add(tmpList);
//                    } else if (i > candidate){
//                        List<List<Integer>> lists1 = dp[i - candidate];
//                        if (lists1.size() == 0){
//                            continue;
//                        }
//                        dp[i].addAll(lists1);
//                        List<List<Integer>> lists = dp[i];
//                        for (List<Integer> list : lists) {
//                            list.add(candidate);
//                        }
//                    }
//                }
//            }
//            return dp[target];
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}