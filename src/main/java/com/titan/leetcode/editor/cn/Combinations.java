//[77]组合
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 
// 👍 665 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
       Solution solution = new Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            return solution1(n, k);
        }

        private List<List<Integer>> solution1(int n, int k) {
            List<List<Integer>> retList = new ArrayList<>();
            if (k <= 0 && n < 0){
                return retList;
            }

            Deque<Integer> path = new ArrayDeque<>();
            dfs(n, k, 1, path, retList);
            return retList;
        }

        private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> retList) {
            if (path.size() == k){
                retList.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i <= n - (k - path.size()) + 1; i++) {
                path.addLast(i);
                dfs(n, k, i + 1, path, retList);
                path.removeLast();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}