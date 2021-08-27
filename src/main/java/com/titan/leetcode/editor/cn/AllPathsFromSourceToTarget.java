//[797]所有可能的路径
//给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序） 
//
// 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。 
//
// 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：graph = [[1,2],[3],[3],[]]
//输出：[[0,1,3],[0,2,3]]
//解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
// 
//
// 示例 2： 
//
// 
//
// 
//输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
//输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// 示例 3： 
//
// 
//输入：graph = [[1],[]]
//输出：[[0,1]]
// 
//
// 示例 4： 
//
// 
//输入：graph = [[1,2,3],[2],[3],[]]
//输出：[[0,1,2,3],[0,2,3],[0,3]]
// 
//
// 示例 5： 
//
// 
//输入：graph = [[1,3],[2],[3],[]]
//输出：[[0,1,2,3],[0,3]]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 2 <= n <= 15 
// 0 <= graph[i][j] < n 
// graph[i][j] != i（即，不存在自环） 
// graph[i] 中的所有元素 互不相同 
// 保证输入为 有向无环图（DAG） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 回溯 
// 👍 161 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPathsFromSourceToTarget{
    public static void main(String[] args) {
       Solution solution = new AllPathsFromSourceToTarget().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            // dfs
            return solution1(graph);
        }

        private List<List<Integer>> solution1(int[][] graph) {
            List<List<Integer>> retList = new ArrayList<>();

            Stack<Integer> path = new Stack<>();
            path.push(0);
            // 从节点0开始，到最后一个节点为止
            dfs(graph, 0, graph.length - 1, retList, path);
            return retList;
        }

        private void dfs(int[][] graph, int index, int endIndex, List<List<Integer>> retList, Stack<Integer> path) {
            if (index == endIndex){
                retList.add(new ArrayList<>(path));
                return;
            }
            for (int endPoint : graph[index]) {
                path.push(endPoint);
                dfs(graph, endPoint, endIndex, retList, path);
                path.pop();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}