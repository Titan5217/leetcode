//[847]访问所有节点的最短路径
//存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。 
//
// 给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。 
//
// 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：graph = [[1,2,3],[0],[0],[0]]
//输出：4
//解释：一种可能的路径为 [1,0,2,0,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
//输出：4
//解释：一种可能的路径为 [0,1,4,2,3]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 1 <= n <= 12 
// 0 <= graph[i].length < n 
// graph[i] 不包含 i 
// 如果 graph[a] 包含 b ，那么 graph[b] 也包含 a 
// 输入的图总是连通图 
// 
// Related Topics 位运算 广度优先搜索 图 动态规划 状态压缩 
// 👍 161 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes{
    public static void main(String[] args) {
        Solution solution = new ShortestPathVisitingAllNodes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathLength(int[][] graph) {
            // dp
//            return dp(graph);

            // bfs
            return bfs(graph);
        }

        public int bfs(int[][] graph) {
            int n = graph.length;
            Queue<int[]> queue = new LinkedList<int[]>();
            boolean[][] seen = new boolean[n][1 << n];
            for (int i = 0; i < n; ++i) {
                queue.offer(new int[]{i, 1 << i, 0});
                seen[i][1 << i] = true;
            }

            int ans = 0;
            while (!queue.isEmpty()) {
                int[] tuple = queue.poll();
                int u = tuple[0], mask = tuple[1], dist = tuple[2];
                if (mask == (1 << n) - 1) {
                    ans = dist;
                    break;
                }
                // 搜索相邻的节点
                for (int v : graph[u]) {
                    // 将 mask 的第 v 位置为 1
                    int maskV = mask | (1 << v);
                    if (!seen[v][maskV]) {
                        queue.offer(new int[]{v, maskV, dist + 1});
                        seen[v][maskV] = true;
                    }
                }
            }
            return ans;
        }

        private int dp(int[][] graph) {
            int n = graph.length;
            int[][] mom = new int[n][n];
            // 初始化联通信息
            for (int i = 0; i < n; i++) {
                int[] points = graph[i];
                // 将值置的比较大
                Arrays.fill(mom[i], n + 1);
                // 对角线为0
                mom[i][i] = 0;
                // 重置连接点的值
                for (int point : points) {
                    mom[i][point] = 1;
                    mom[point][i] = 1;
                }
            }

            // 算两点间的最短路径 floyd
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        mom[i][j] = Math.min(mom[i][j], mom[i][k] + mom[k][j]);
                    }
                }
            }

            // 状压DP
            int[][] dp = new int[n][1 << n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], 3 * n);
            }
            for (int i = 1; i < (1 << n); i++) {
                // 2的幂
                if ((i & (i - 1)) == 0){
                    int u = Integer.bitCount((i & (-i)) - 1);
                    dp[u][i] = 0;
                } else {
                    for (int u = 0; u < n; ++u) {
                        if ((i & (1 << u)) != 0) {
                            for (int v = 0; v < n; ++v) {
                                if ((i & (1 << v)) != 0 && u != v) {
                                    dp[u][i] = Math.min(dp[u][i], dp[v][i ^ (1 << u)] + mom[v][u]);
                                }
                            }
                        }
                    }
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int u = 0; u < n; ++u) {
                ans = Math.min(ans, dp[u][(1 << n) - 1]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}