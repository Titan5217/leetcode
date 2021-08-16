//[40]组合总和 II
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 
// 👍 658 👎 0

package com.titan.leetcode.editor.cn;

import java.util.*;

public class CombinationSumIi{
    public static void main(String[] args) {
       Solution solution = new CombinationSumIi().new Solution();
        solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> retList = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // 【超时】
//            return solution1(candidates, target);

            return solution2(candidates, target);
        }

        private List<List<Integer>> solution2(int[] candidates, int target) {
            int len = candidates.length;
            if (len == 0) {
                return retList;
            }

            // 关键步骤
            Arrays.sort(candidates);

            Deque<Integer> path = new ArrayDeque<>(len);
            dfs2(candidates, len, 0, target, path);
            return retList;
        }

        private void dfs2(int[] candidates, int len, int begin, int target, Deque<Integer> path) {
            if (target == 0) {
                retList.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < len; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }

                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                path.addLast(candidates[i]);

                // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
                dfs2(candidates, len, i + 1, target - candidates[i], path);

                path.removeLast();
            }
        }

//        private List<List<Integer>> solution1(int[] candidates, int target) {
//            Arrays.sort(candidates);
//            dfs(candidates, target, new ArrayList<>(), 0);
//            return new ArrayList<>(retList);
//        }
//
//        private void dfs(int[] candidates, int target, List<Integer> path, int index) {
//            if (target < 0){
//                return;
//            }
//            if (target == 0){
//                retList.add(new ArrayList<>(path));
//                return;
//            }
//
//            for (int i = index; i < candidates.length; i++) {
//                if (candidates[i] > target){
//                    continue;
//                }
//                path.add(candidates[i]);
//                dfs(candidates, target - candidates[i], path, i + 1);
//                path.remove(path.size() - 1);
//            }
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}