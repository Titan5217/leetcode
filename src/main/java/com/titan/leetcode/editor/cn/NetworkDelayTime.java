//[743]网络延迟时间
//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 
// 👍 327 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NetworkDelayTime{
    public static void main(String[] args) {
       Solution solution = new NetworkDelayTime().new Solution();
        solution.dp(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int INF = 0x3f3f3f3f;
        public int networkDelayTime(int[][] times, int n, int k) {
            return dp(times, n, k);
        }

        private int dp(int[][] times, int n, int k) {
            // 初始化邻接矩阵
            int[][] tmpArray = new int[100][100];
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n; j++) {
                    tmpArray[i][j] = i == j ? 0 : INF;
                }
            }
            for (int[] time: times) {
                tmpArray[time[0]][time[1]] = time[2];
            }

            // 遍历所有节点的可行路径
            floyd(n, tmpArray);

            // 返回路径中最大值
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, tmpArray[k][i]);
            }

            return ans >= INF / 2 ? -1 : ans;
        }

        void floyd(int n, int[][] tmpArray) {
            for (int p = 1; p <= n; p++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        tmpArray[i][j] = Math.min(tmpArray[i][j], tmpArray[i][p] + tmpArray[p][j]);
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}